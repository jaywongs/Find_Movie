package com.jay.service;

import com.jay.common.Page;
import com.jay.po.User;

/**
 * created by jaywang on 2019/5/11.
 */
public interface UserService {

    //查询用户类别
    public Page<User> findUserList(Integer page, Integer rows, String username);

    //删除用户
    public void deleteUser(Integer id);

    //编辑用户
    public User getUserById(Integer id);

    //更新用户信息
    public void updateUser(User user);

    //添加用户
    public void addUser(User user);

}
