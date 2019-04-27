package com.jay.service;

import com.jay.common.E3Result;
/**
 * created by jaywang on 2019/4/27.
 */
public interface AdminService {
    E3Result adminLogin(String adminname, String adminpassword);
    // 管理员列表

}
