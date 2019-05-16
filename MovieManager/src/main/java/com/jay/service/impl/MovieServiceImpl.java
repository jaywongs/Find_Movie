package com.jay.service.impl;

import com.jay.common.Page;
import com.jay.mapper.CategoryMapper;
import com.jay.mapper.MovieMapper;
import com.jay.mapper.MoviecategoryMapper;
import com.jay.po.*;
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
    @Override
    public void deleteMovie(Integer id) {
        MoviecategoryExample moviecategoryExample = new MoviecategoryExample();
        MoviecategoryExample.Criteria criteria = moviecategoryExample.createCriteria();
        criteria.andMovieidEqualTo(id);
        moviecategoryMapper.deleteByExample(moviecategoryExample);
        movieMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Category> selectCategory() {
        CategoryExample example = new CategoryExample();
        List<Category> list = categoryMapper.selectByExample(example);
        return list;
    }

    @Override
    public void updateMovie(Movie movie, String[] categoryIds) {
        movieMapper.updateByPrimaryKey(movie);
        int movieid = movie.getMovieid();

        MoviecategoryExample moviecategoryExample = new MoviecategoryExample();
        MoviecategoryExample.Criteria criteria = moviecategoryExample.createCriteria();
        criteria.andMovieidEqualTo(movieid);

        for (String categoryId : categoryIds){
            Moviecategory moviecategory = new Moviecategory();
            int tempcategoryId = Integer.parseInt(categoryId);
            moviecategory.setMovcatid(movieid);
            moviecategory.setCategoryid(tempcategoryId);

            moviecategoryMapper.updateByExample(moviecategory, moviecategoryExample);
        }
    }

    @Override
    public void addMovie(Movie movie, String[] categoryIds) {
        movieMapper.insert(movie);
        int movieid = movie.getMovieid();
        for (String categoryId : categoryIds){
            Moviecategory moviecategory = new Moviecategory();
            int tempcategoryId = Integer.parseInt(categoryId);
            moviecategory.setMovcatid(movieid);
            moviecategory.setCategoryid(tempcategoryId);

            // 电影类别表添加相应记录
            moviecategoryMapper.insert(moviecategory);
        }

    }

    //根据电影id获取该条电影记录(包括类别）
    @Override
    public NewMovie getMovieById(Integer id) {
        NewMovie newMovie = new NewMovie();
        Movie movie = movieMapper.selectByPrimaryKey(id);

        newMovie.setMovieid(movie.getMovieid());
        newMovie.setMoviename(movie.getMoviename());
        newMovie.setAverating(movie.getAverating());
        newMovie.setDescription(movie.getDescription());
        newMovie.setDirector(movie.getDirector());
        newMovie.setLeadactors(movie.getLeadactors());
        newMovie.setNumrating(movie.getNumrating());
        newMovie.setPicture(movie.getPicture());
        newMovie.setShowyear(movie.getShowyear());

        //根据电影id查询电影对应的类别
        MoviecategoryExample example = new MoviecategoryExample();
        MoviecategoryExample.Criteria criteria = example.createCriteria();
        criteria.andMovieidEqualTo(id);
        List<Moviecategory> list = moviecategoryMapper.selectByExample(example);

        List temps = new ArrayList();
        String categoryName = " ";
        //将符合条件的id放到list里
        for (Moviecategory moviecategory : list){
            int temId = moviecategory.getCategoryid();
            temps.add(temId);
            Category category = categoryMapper.selectByPrimaryKey(temId);
            categoryName = categoryName + category.getCategory() + "/";
        }
        //list转为数组并放到newMovie中
        Integer [] arrs = (Integer[]) temps.toArray(new Integer[temps.size()]);
        newMovie.setCategoryid(arrs);

        //设置newMovie的category名称
        newMovie.setCategoryname(categoryName);
        return newMovie;
    }
}
