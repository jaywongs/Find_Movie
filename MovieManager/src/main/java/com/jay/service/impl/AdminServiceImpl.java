package com.jay.service.impl;

import com.jay.common.E3Result;
import com.jay.common.Page;
import com.jay.mapper.AdminMapper;
import com.jay.po.Admin;
import com.jay.po.AdminExample;
import com.jay.service.AdminService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

/**
 * created by jaywang on 2019/4/27.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public E3Result adminLogin(String adminname, String adminpassword) {
        // 1、判断账号和密码是否正确
        // 根据账号查询管理员信息
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminnameEqualTo(adminname);
        // 查询
        List<Admin> list = adminMapper.selectByExample(example);
        if (null == list || list.size() == 0){
            return E3Result.build(400, "用户名或密码错误");
        }
        // 取用户信息
        Admin admin = list.get(0);
        if (!admin.getAdminpassword().equals(DigestUtils.md5DigestAsHex(adminpassword.getBytes()))){
            return E3Result.build(400, "密码错误");
        }else {
            return E3Result.ok(admin);
        }
    }

    @Override
    public Page<Admin> findAdminList(Integer page, Integer rows, String adminname) {
        Admin admin = new Admin();
        if (StringUtils.isNotBlank(adminname)){
            admin.setAdminname(adminname);
        }

        admin.setStart((page - 1) * rows);
        admin.setRows(rows);

        List<Admin> admins = adminMapper.selectAdminList(admin);
        Integer count = adminMapper.selectAdminListCount(admin);
        Page<Admin> result = new Page<>();
        result.setPage(page);
        result.setSize(rows);
        result.setTotal(count);
        result.setRows(admins);
        return result;
    }

    @Override
    public void addAdmin(Admin admin) {
        admin.setRole(1);
        adminMapper.insert(admin);
    }

    @Override
    public void deleteAdmin(Integer id) {
        adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public Admin getAdminById(Integer id) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        return admin;
    }
}
