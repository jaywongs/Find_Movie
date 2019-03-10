package com.jay.service;

import com.jay.common.E3Result;
import com.jay.po.Browse;
import com.jay.po.User;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * created by jaywang on 2019/3/10.
 */
public interface RegisterService {
    //实时检查输入合法性
    public E3Result checkData(String param, int type);

    public E3Result register(User user);

    //注册是写入用户喜欢的电影
    public void selectFavorite(Browse browse);

    //点击注册按钮时检查合法性
    E3Result checkDataBoth(@PathVariable String paramName, @PathVariable String paramEmail, @PathVariable Integer type);
}
