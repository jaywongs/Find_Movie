package com.jay.service.impl;

import com.jay.mapper.TopdefaultmoviesMapper;
import com.jay.po.Movie;
import com.jay.service.TopdefaultMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by jaywang on 2019/3/9.
 */
@Service
public class TopdefaultMovieServiceImpl implements TopdefaultMovieService {

    @Autowired
    private TopdefaultmoviesMapper topdefaultmoviesMapper;
    public List<Movie> SelectRegDefaultMovie() {
        List<Movie> list = topdefaultmoviesMapper.selectRegDefaultMovie();
        return list;
    }
}
