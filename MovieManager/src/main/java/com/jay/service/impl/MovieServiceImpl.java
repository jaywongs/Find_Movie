package com.jay.service.impl;

import com.jay.common.Page;
import com.jay.mapper.CategoryMapper;
import com.jay.mapper.MovieMapper;
import com.jay.mapper.MoviecategoryMapper;
import com.jay.po.Movie;
import com.jay.po.MoviecategoryExample;
import com.jay.po.NewMovie;
import com.jay.po.Query;
import com.jay.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * created by jaywang on 2019/5/11.
 */
@Service("movieService")
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private MoviecategoryMapper moviecategoryMapper;

    @Override
    public Page<NewMovie> findMovieList(Query query) {
        Page<NewMovie> page = new Page<>();
        page.setSize(10);
        query.setSize(10);
        if (null != query) {
            // 判断当前页
            if (null != query.getPage()) {
                page.setPage(query.getPage());
                query.setStartRow((query.getPage() - 1) * query.getSize());
            }
            if (null != query.getMovieName() && !"".equals(query.getMovieName().trim())){
                query.setMovieName(query.getMovieName().trim());
            }
            if (0 != (query.getCategoryId())){
                query.setCategoryId(query.getCategoryId());
            }
            page.setTotal(movieMapper.movieCount(query));
            List<NewMovie> newMovieList = new ArrayList<>();
            List<Movie> movieList = movieMapper.selectMovieListByQuery(query);
            for (Movie movie : movieList) {
                NewMovie newMovie = getMovieById(movie.getMovieid());
                newMovieList.add(newMovie);
            }
            page.setRows(newMovieList);
        }
        return page;
    }

    //删除电影
    public void deleteMovie(Integer id) {
        MoviecategoryExample moviecategoryExample = new MoviecategoryExample();
        MoviecategoryExample.Criteria criteria = moviecategoryExample.createCriteria();
        criteria.andMovieidEqualTo(id);
        moviecategoryMapper.deleteByExample(moviecategoryExample);
        movieMapper.deleteByPrimaryKey(id);
    }


}
