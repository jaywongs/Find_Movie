package com.jay.service;

import com.jay.po.Browse;

/**
 * created by jaywang on 2019/3/19.
 */
public interface BrowseService {
    //获取浏览记录
    Browse getBrowseByUserid(Integer userid);
}
