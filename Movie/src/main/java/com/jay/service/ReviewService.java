package com.jay.service;

import com.jay.po.Review;

import java.util.List;

/**
 * created by jaywang on 2019/3/19.
 */
public interface ReviewService {
    List<Review> getReviewListByUserId(Integer id);
}
