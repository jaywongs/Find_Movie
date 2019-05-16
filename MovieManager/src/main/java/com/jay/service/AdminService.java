package com.jay.service;

import com.jay.common.E3Result;
import com.jay.common.Page;
import com.jay.po.Admin;

/**
 * created by jaywang on 2019/4/27.
 */
public interface AdminService {

    E3Result adminLogin(String adminname, String adminpassword);

    // 管理员列表
    public Page<Admin> findAdminList(Integer page, Integer rows, String adminname);

    //
    public void addAdmin(Admin admin);

    public void deleteAdmin(Integer id);

    public void updateAdmin(Admin admin);

    public Admin getAdminById(Integer id);

}
