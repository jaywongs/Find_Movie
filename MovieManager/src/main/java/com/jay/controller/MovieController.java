package com.jay.controller;

import com.jay.common.Page;
import com.jay.po.Category;
import com.jay.po.Movie;
import com.jay.po.NewMovie;
import com.jay.po.Query;
import com.jay.service.MovieService;
import com.jay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * created by jaywang on 2019/5/11.
 */
@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

//    @Autowired
//    private UserService userService;

    @RequestMapping(value = "/movie")
    public String showMovie(){
        return "redirect:/movie/list.action";
    }

    //电影列表
    @RequestMapping(value = "/movie/list")
    public String list(Query query, Model model) {

        Page<NewMovie> movies = movieService.findMovieList(query);
        model.addAttribute("page", movies);
        List<Category> categoryList = movieService.selectCategory();
        model.addAttribute("categoryList", categoryList);

        //
        model.addAttribute("moviename", query.getMovieName());
        model.addAttribute("categoryId", query.getCategoryId());
        return "movieManage";
    }

    //用户管理
    @RequestMapping(value = "/movie/userlist")
    public String showUser() {
        return "redirect:/user/list.action";
    }

    //管理员管理
    @RequestMapping(value = "/movie/adminlist")
    public String showAdmin() {
        return "redirect:/admin/list.action";
    }

    //添加电影
    @RequestMapping("/movie/add")
    @ResponseBody
    public String addMovie(Movie movie, HttpServletRequest request){
        String [] categoryIds = request.getParameterValues("categoryId");
        movieService.addMovie(movie, categoryIds);
        return "OK";
    }

    //删除电影
    @RequestMapping("/movie/delete")
    @ResponseBody
    public String deleteMovie(Integer id){
        movieService.deleteMovie(id);
        return "OK";
    }

    //更新电影
    @RequestMapping("/movie/update")
    @ResponseBody
    public String updateMovie(Movie movie, HttpServletRequest request){
        String [] categoryIds = request.getParameterValues("categoryId");
        movieService.updateMovie(movie, categoryIds);
        return "OK";
    }

    @RequestMapping("/movie/edit")
    @ResponseBody
    public NewMovie getMovieById(Integer id){
        NewMovie newMovie = movieService.getMovieById(id);
        return newMovie;
    }
}
