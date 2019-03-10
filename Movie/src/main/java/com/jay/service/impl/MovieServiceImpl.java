package com.jay.service.impl;

import com.jay.common.E3Result;
import com.jay.mapper.MovieMapper;
import com.jay.po.Movie;
import com.jay.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by jaywang on 2019/3/8.
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public E3Result SelectTopDefaultMovie(int limit) {
        List<Movie> list = movieMapper.selectTopDefaultMovie(limit);
        if (list == null || list.size() == 0) {
            return E3Result.build(400, "获取电影信息错误");
        }
        return E3Result.ok(list);
    }

    @Override
    public E3Result SortMovieByMovieId(int id) {
        // 查询
        Movie movie = movieMapper.selectByPrimaryKey(id);
        return E3Result.ok(movie);
    }
}
