package com.jay.controller;

import com.jay.common.Page;
import com.jay.po.User;
import com.jay.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by jaywang on 2019/5/15.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/list")
    public String getUserList(@RequestParam(defaultValue="1")Integer page, @RequestParam(defaultValue="10")Integer rows, String username, Model model) {
        Page<User> users = userService.findUserList(page, rows, username);
        model.addAttribute("page", users);
        model.addAttribute("username", username);
        return "userManage";
    }

    @RequestMapping("/user/add")
    @ResponseBody
    public String addUser(User user) {
        userService.addUser(user);
        return "OK";
    }

    @RequestMapping("/user/delete")
    @ResponseBody
    public String deleteUser(Integer id) {
        userService.deleteUser(id);
        return "OK";
    }

    @RequestMapping("/user/update")
    @ResponseBody
    public String updateUser(User user) {
        userService.updateUser(user);
        return "OK";
    }

    @RequestMapping("/user/edit")
    @ResponseBody
    public User getUserById(Integer id) {
        User user = userService.getUserById(id);
        return user;
    }


}
