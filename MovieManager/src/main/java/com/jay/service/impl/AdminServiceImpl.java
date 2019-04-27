package com.jay.service.impl;

import com.jay.common.E3Result;
import com.jay.mapper.AdminMapper;
import com.jay.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * created by jaywang on 2019/4/27.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public E3Result adminLogin(String adminname, String adminpassword) {
        return null;
    }
}
