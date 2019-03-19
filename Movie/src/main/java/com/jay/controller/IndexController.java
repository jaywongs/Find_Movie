package com.jay.controller;

import com.jay.common.E3Result;
import com.jay.common.JsonUtils;
import com.jay.po.*;
import com.jay.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin.services.BrowserService;

import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * created by jaywang on 2019/3/8.
 */
@Controller
public class IndexController {


    @Autowired
    private StarService starService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private BrowseService browseService;

    //主页
    @RequestMapping("/")
    public String showHomePage(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");

        //默认推荐电影
        E3Result TopDefaultMovie = movieService.SelectTopDefaultMovie(5);
        List<Movie> list = (List<Movie>) TopDefaultMovie.getData();
        request.getSession().setAttribute("TopDefaultMovie", list);
        Map movieMap = new HashMap();
        for (int i = 0; i < list.size(); i++) {
            movieMap.put(list.get(i).getMovieid().toString(), i);
        }
        request.getSession().setAttribute("TopDefaultMovieMap", JsonUtils.objectToJson(movieMap));

        return "Home";
    }


    //选电影界面
    @RequestMapping("/index")
    public String showIndex(HttpServletRequest request) {
        E3Result allCategory = categoryService.getAllCategory();
        List<Category> list1 = (List<Category>) allCategory.getData();

        //获取所有电影数据
        Integer categoryId = 0;
        SelectQuery query = new SelectQuery();
        query.setCategoryId(categoryId);
        query.setMovieLimit(0);
        query.setSort("numrating");
        E3Result allMovie = movieService.SortMoiveByCategory(query);
        List<Movie> list2 = (List<Movie>) allMovie.getData();
        //设置session
        request.getSession().setAttribute("category", list1);
        request.getSession().setAttribute("movie", list2);

        return "index";
    }


    //电影详情传值
    @RequestMapping("/Customer/Description")
    @ResponseBody
    public String GoMoiveDescription(HttpServletRequest request) {
        request.getSession().removeAttribute("booluserunlikedmovie");

        //获取用户点击movieid
        int movieid = Integer.parseInt(request.getParameter("id"));
        E3Result e3Result1 = movieService.SortMovieByMovieId(movieid);
        //获取电影详情
        Movie movie = (Movie) e3Result1.getData();
        User user = (User) request.getSession().getAttribute("user");

        //判断用户是否登录以及对这部电影的喜爱
        if (user != null) {
            E3Result e3Result2 = starService.SortReviewByUseridandMovieid(user.getUserid(), movieid);
            Review review = (Review)e3Result2.getData();
            request.getSession().setAttribute("userstar", review);

            //判断登录用户是否喜欢该电影
            int booluserlikedmovie = movieService.booluserunlikedmovie(user.getUserid(), request.getParameter("id"));
            request.getSession().setAttribute("booluserlikedmovie", booluserlikedmovie);
        }else {
            Review review = null;
            request.getSession().setAttribute("userstar", review);
        }

        //设置session
        request.getSession().setAttribute("moviedescription", movie);

        return "success";
    }


    //电影详情界面
    @RequestMapping("/MovieDescription")
    public String showMovieDescription(HttpServletRequest request){
        return "MovieDescription";
    }


    //加载更多按钮(通过类型标签，时序标签以及现有页面呈现的电影数目三个参数查询)
    @RequestMapping(value = "/loadingmore", method = RequestMethod.POST)
    @ResponseBody
    public E3Result loadMoreMovie(HttpServletRequest request) {
        //获取更多
        String sort = request.getParameter("sort");
        int molimit = Integer.parseInt(request.getParameter("molimit"));
        int type = Integer.parseInt(request.getParameter("type"));
        SelectQuery query = new SelectQuery();
        query.setMovieLimit(molimit);
        query.setSort(sort);
        query.setCategoryId(type);
        E3Result e3Result = movieService.SortMoiveByCategory(query);
        List<Movie> movies = (List<Movie>) e3Result.getData();
        return E3Result.ok(movies);
    }


    //选择排序电影（类型和时序）
    @RequestMapping(value = "/typesortmovie", method = RequestMethod.POST)
    @ResponseBody
    public E3Result showtypesortmovie(HttpServletRequest request) {
        //获取所有电影数据
        int type = Integer.parseInt(request.getParameter("type"));
        int molimit = Integer.parseInt(request.getParameter("molimit"));
        String sort = request.getParameter("sort");
        SelectQuery query = new SelectQuery();
        query.setSort(sort);
        query.setMovieLimit(molimit);
        query.setCategoryId(type);
        E3Result e3Result = movieService.SortMoiveByCategory(query);
        List<Movie> movies = (List<Movie>) e3Result.getData();
        return E3Result.ok(movies);
    }

    //电影评星
    @RequestMapping(value = "/getstar", method = RequestMethod.POST)
    @ResponseBody
    public String getstar(HttpServletRequest request) throws ParseException {
        int userid = Integer.parseInt(request.getParameter("userid"));
        int movieid = Integer.parseInt(request.getParameter("movieid"));
        Double star = Double.parseDouble(request.getParameter("star"));
        if (star >= 3.5) {
            //todo
        }
        String str = request.getParameter("time");
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = formate.parse(str);
        Review review = new Review();
        review.setUserid(userid);
        review.setMovieid(movieid);
        review.setStar(star);
        review.setReviewtime(time);

        //入库
        starService.setStar(review);
        review = null;
        E3Result e3Result = starService.SortReviewByUseridandMovieid(userid, movieid);
        review = (Review)e3Result.getData();

        //立即读取影评显示于前端
        request.getSession().setAttribute("userstar", review);
        return "评分成功！";

    }



    //电影详情界面点击相似电影


    //电影详情界面用户喜欢电影（,id. 格式写入数据库，不存在则插入，存在则更新）
    @RequestMapping(value = "/likedmovie", method = RequestMethod.POST)
    @ResponseBody
    public String likemovie(HttpServletRequest request) {
        String movieids=","+request.getParameter("movieid")+".";
        int userid = Integer.parseInt(request.getParameter("userid"));
        int boollike = Integer.parseInt(request.getParameter("boollike"));
        SelectQuery query = new SelectQuery();
        query.setCategoryId(userid);
        query.setMovieLimit(boollike);
        query.setSort(movieids);
        movieService.InsertUserFavouriteMoive(query);
        return "success";
    }

    //点击个人中心按钮
    @RequestMapping(value = "/page/profile", method = RequestMethod.POST)
    @ResponseBody
    public String goProfile(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Integer userid = user.getUserid();
        List<Review> reviews = reviewService.getReviewListByUserId(userid);
        List<Movie> movies = new ArrayList<>();
        Browse browse = browseService.getBrowseByUserid(userid);
        if (browse != null && browse.getMovieids() != null) {
            String[] movieids = browse.getMovieids().replace(".", "").substring(1).split(",");
            for (String movieid :movieids) {
                movies.add(movieService.)
            }
        }
    }

    //个人中心按钮
    @RequestMapping("/profile")
    public String showProfie() {
        return "profile";
    }

    //搜索电影

}


