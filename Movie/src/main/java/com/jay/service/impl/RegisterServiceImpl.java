package com.jay.service.impl;

import com.jay.common.E3Result;
import com.jay.mapper.BrowseMapper;
import com.jay.mapper.UserMapper;
import com.jay.po.Browse;
import com.jay.po.User;
import com.jay.po.UserExample;
import com.jay.service.RegisterService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
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
        // 数据有效性
        if (StringUtils.isBlank(user.getUsername()) ||StringUtils.isBlank(user.getEmail()) ||StringUtils.isBlank(user.getPassword()) ) {
            return E3Result.build(400, "用户数据不完整，注册失败");
        }

        // 补全pojo
        user.setRegistertime(new Date());
        user.setLastlogintime(new Date());

        //密码MD5加密
        String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(md5Pass);

        //用户信息入库
        userMapper.insert(user);
        Integer userId = user.getUserid();

        //返回添加成功
        return E3Result.ok(userId);
    }

    @Override
    public void selectFavorite(Browse browse) {
        browseMapper.insert(browse);
    }

    @Override
    public E3Result checkDataBoth(@PathVariable String paramName, @PathVariable String paramEmail, @PathVariable Integer type) {
        // 根据不同的type生成不同的查询条件
        UserExample exampleName = new UserExample();
        UserExample exampleEamil = new UserExample();
        UserExample.Criteria criteriaName = exampleName.createCriteria();
        UserExample.Criteria criteriaEmail = exampleEamil.createCriteria();

        // 1：用户名 2：手机号 3：邮箱 4.name + 邮箱
        if (type == 4) {
            criteriaName.andUsernameEqualTo(paramName);
            criteriaEmail.andEmailEqualTo(paramEmail);
        }
        else
            return E3Result.build(400, "数据类型错误");
        // 执行查询
        List<User> listName = userMapper.selectByExample(exampleName);
        List<User> listEmail = userMapper.selectByExample(exampleEamil);
        // 判断结果中是否包含数据
        if (listName != null && listName.size() > 0 || listEmail != null && listEmail.size() > 0) {
            // 如果有数据返回false
            return E3Result.ok(false);
        }
        // 如果没有数据返回true
        return E3Result.ok(true);
    }
}
