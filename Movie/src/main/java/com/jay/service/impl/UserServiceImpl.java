package com.jay.service.impl;

import com.jay.mapper.UserMapper;
import com.jay.po.User;
import com.jay.po.UserExample;
import com.jay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;


/**
 * created by jaywang on 2019/3/8.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }


    @Override
    public void updateUser(Integer userid, String password, String email) {
        String md5Pass = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = new User();
        user.setUserid(userid);
        user.setPassword(md5Pass);
        user.setEmail(email);

        userMapper.updateByPrimaryKey(user);
    }


}
