package com.jay.service.impl;

import com.jay.common.E3Result;
import com.jay.mapper.UserMapper;
import com.jay.po.User;
import com.jay.po.UserExample;
import com.jay.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * created by jaywang on 2019/3/13.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public E3Result userLogin(String username, String password) {
        // 根据用户名查询用户信息
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);

        //执行查询
        List<User> list = userMapper.selectByExample(example);
        if (list == null || list.size() == 0) {
            // 数据库不存在此用户 直接返回失败
            return E3Result.build(400, "用户名或密码错误");
        }

        //获取用户信息
        User user = list.get(0);

        //判断密码
        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
            // 密码错误 返回400
            return E3Result.build(400, "用户名或密码错误");
        }else {
            return E3Result.ok(user);
        }
    }
}
