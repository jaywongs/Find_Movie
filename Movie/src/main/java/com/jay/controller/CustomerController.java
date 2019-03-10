package com.jay.controller;

import com.jay.po.Movie;
import com.jay.po.Topdefaultmovies;
import com.jay.service.TopdefaultMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * created by jaywang on 2019/3/8.
 */
@Controller
public class CustomerController {

    @Autowired
    private TopdefaultMovieService topdefaultMovieService;

    @RequestMapping("/page/register")
    public String reg(HttpServletRequest request) {
        //推荐topMovie
        List<Movie> list = topdefaultMovieService.SelectRegDefaultMovie();
        request.getSession().setAttribute("TopRegDefaultMovie", list);
        return "register"; 
    }

}
