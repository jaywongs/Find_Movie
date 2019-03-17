package com.jay.service.impl;

import com.jay.common.E3Result;
import com.jay.mapper.ReviewMapper;
import com.jay.po.Review;
import com.jay.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by jaywang on 2019/3/17.
 */
@Service
public class StarServiceImpl implements StarService {

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public void setStar(Review review) {
        reviewMapper.insert(review);
    }

    @Override
    public E3Result SortReviewByUseridandMovieid(Integer userid, Integer movieid) {
        //搜索影评,用于用户评价一部电影后立即获取其评价的信息
        Review review = reviewMapper.selectByUseridandMovieid(userid, movieid);
        return E3Result.ok(review);
    }
}
