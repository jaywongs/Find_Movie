package com.jay.controller;

import com.jay.common.Page;
import com.jay.po.NewMovie;
import com.jay.po.Query;
import com.jay.service.MovieService;
import com.jay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by jaywang on 2019/5/11.
 */
@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/movie/list")
    public String list(Query query, Model model) {

        Page<NewMovie> movies = movieService.findMovieList(query);

    }


}
