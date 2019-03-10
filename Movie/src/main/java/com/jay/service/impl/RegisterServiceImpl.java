package com.jay.service.impl;

import com.jay.common.E3Result;
import com.jay.mapper.BrowseMapper;
import com.jay.mapper.UserMapper;
import com.jay.po.Browse;
import com.jay.po.User;
import com.jay.po.UserExample;
import com.jay.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by jaywang on 2019/3/10.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BrowseMapper browseMapper;

    @Override
    public E3Result checkData(String param, int type) {
        // 根据不同的type生成不同的查询条件
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        // 1：用户名 2：手机号 3：邮箱
        if (type == 1) {
            criteria.andUsernameEqualTo(param);
        }
        else if (type == 3) {
            criteria.andEmailEqualTo(param);
        }
        else
            return E3Result.build(400, "数据类型错误");
        // 执行查询
        List<User> list = userMapper.selectByExample(example);
        // 判断结果中是否包含数据
        if (list != null && list.size() > 0) {
            // 如果有数据返回false
            return E3Result.ok(false);
        }
        // 如果没有数据返回true
        return E3Result.ok(true);
    }

    @Override
    public E3Result register(User user) {
        return null;
    }

    @Override
    public void selectFavorite(Browse browse) {

    }

    @Override
    public E3Result checkDataBoth(String paramName, String paramEmail, Integer type) {
        return null;
    }
}
