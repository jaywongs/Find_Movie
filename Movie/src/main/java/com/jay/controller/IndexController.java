package com.jay.controller;

import com.jay.common.E3Result;
import com.jay.common.JsonUtils;
import com.jay.po.Movie;
import com.jay.po.User;
import com.jay.service.MovieService;
import com.jay.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by jaywang on 2019/3/8.
 */
@Controller
public class IndexController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private RegisterService registerService;

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


    @RequestMapping("/customer/checkBox/{paramName}/{paraEmail}/{type}")
    @ResponseBody
    public E3Result checkDataBoth(@PathVariable String paramName, @PathVariable String paramEmail, @PathVariable Integer type){
        try {
            String str = URLDecoder.decode(paramName, "UTF-8");
            E3Result e3Result = registerService.
        }
    }

