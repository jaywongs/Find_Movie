package com.jay.service.impl;

import com.jay.common.E3Result;
import com.jay.mapper.BrowseMapper;
import com.jay.mapper.MovieMapper;
import com.jay.po.Movie;
import com.jay.po.MovieExample;
import com.jay.po.SelectQuery;
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
    private BrowseMapper browseMapper;
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

    @Override
    public E3Result SortMoiveByCategory(SelectQuery query) {
        MovieExample example = new MovieExample();
        MovieExample.Criteria criteria = example.createCriteria();
        //
        List<Movie> list = movieMapper.selectByCategory(query);

        return E3Result.ok(list);
    }

    @Override
    public int booluserunlikedmovie(int userid,String movieid)
    {
        return  browseMapper.booluserunlikedmovie(userid, movieid);
    }

    @Override
    public void InsertUserFavouriteMoive(SelectQuery selectQuery) {
        browseMapper.insertuserfavourtemovie(selectQuery);
    }

    @Override
    public Movie getMovieByMovieid(Integer id) {
        return movieMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Movie> selectMoviesByName(String moviename) {
        return movieMapper.selectMovieNameLike(moviename);
    }
}
