package com.jay.service.impl;

import com.jay.mapper.ReviewMapper;
import com.jay.po.Review;
import com.jay.po.ReviewExample;
import com.jay.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by jaywang on 2019/3/19.
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public List<Review> getReviewListByUserId(Integer id) {
        ReviewExample example = new ReviewExample();
        ReviewExample.Criteria criteria = example.createCriteria();
        criteria.andUseridEqualTo(id);
        List<Review> reviews = reviewMapper.selectByExample(example);
        return reviews;
    }
}
