package com.jay.service;

import com.jay.common.E3Result;
import com.jay.po.Review;

/**
 * created by jaywang on 2019/3/17.
 */
public interface StarService {
    public void setStar(Review review);
    //获取评价信息
    E3Result SortReviewByUseridandMovieid(Integer userid, Integer movieid);
}
