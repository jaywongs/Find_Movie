package com.jay.service;

import com.jay.common.E3Result;
import com.jay.po.Movie;
import com.jay.po.SelectQuery;

/**
 * created by jaywang on 2019/3/8.
 */
public interface MovieService {
    //选择默认的电影5部(暂时用于推荐表中用户推荐电影不足五部的时候增加)
    E3Result SelectTopDefaultMovie(int limit);

    //搜索电影by id
    E3Result SortMovieByMovieId(int id);

    //分类排序选择每次20部
    E3Result SortMoiveByCategory(SelectQuery query);

    //判断用户对电影的喜爱
    int booluserunlikedmovie(int userid, String movieid);

    //用户like的电影
    void InsertUserFavouriteMoive(SelectQuery selectQuery);

    //根据userid获取电影
     Movie getMovieByMovieid(Integer id);



}
