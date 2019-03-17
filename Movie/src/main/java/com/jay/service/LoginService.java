package com.jay.service;

import com.jay.common.E3Result;

/**
 * created by jaywang on 2019/3/13.
 */
public interface LoginService {
    E3Result userLogin(String username, String password);
}
