package com.jay.controller;

import com.jay.common.E3Result;
import com.jay.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
/**
 * Created by jaywangs on 2019/4/25
 */

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    public String showLogin() {
        return "adminLogin";
    }

    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public E3Result login(String adminname, String adminpassword, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(adminname, adminpassword);
        try {
            subject.login(token);
        }catch (UnknownAccountException e) {
            e.printStackTrace();
            model.addAttribute("userName", "用户名错误！");
            return E3Result.build(500, "用户名错误");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            model.addAttribute("passwd", "密码错误");
            return E3Result.build(500, "密码错误" );
        }
        return E3Result.ok();
    }



}
