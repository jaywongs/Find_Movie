package com.jay.service;

import com.jay.po.User;

/**
 * created by jaywang on 2019/3/8.
 */
public interface UserService {
    public User getUserById (Integer id);

    public void updateUser(Integer userid, String password, String email);
}
