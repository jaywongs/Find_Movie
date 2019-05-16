package com.jay.service;

import com.jay.common.Page;
import com.jay.po.Category;
import com.jay.po.Movie;
import com.jay.po.NewMovie;
import com.jay.po.Query;

import java.util.List;

/**
 * created by jaywang on 2019/5/11.
 */
public interface MovieService {

    // 查询客户列表
    public Page<NewMovie> findMovieList(Query query);

    public NewMovie getMovieById(Integer id);

    public void deleteMovie(Integer id);

    public List<Category> selectCategory();

    public void updateMovie(Movie movie, String[] categoryIds);

    public void addMovie(Movie movie, String[] categoryIds);

}
