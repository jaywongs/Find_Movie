package com.jay.service.impl;

import com.jay.common.E3Result;

/**
 * created by jaywang on 2019/3/8.
 */
public interface MovieService {
    //选择默认的电影5部(暂时用于推荐表中用户推荐电影不足五部的时候增加)
    E3Result SelectTopDefaultMovie(int limit);

    //搜索电影by id
    E3Result SortMovieByMovieId(int id);
    

}
