package com.jay.controller;

import com.jay.Common.E3Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.jvm.hotspot.debugger.Page;

import javax.security.auth.Subject;

/**
 * Created by jaywangs on 2019/4/25
 */

@Controller
public class AdminController {

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
    }

}
