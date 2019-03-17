package com.jay.controller;

import com.jay.common.E3Result;
import com.jay.po.Browse;
import com.jay.po.Movie;
import com.jay.po.User;
import com.jay.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.List;

/**
 * created by jaywang on 2019/3/8.
 */
@Controller
public class CustomerController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private TopdefaultMovieService topdefaultMovieService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    //注册页面
    @RequestMapping("/page/register")
    public String reg(HttpServletRequest request) {
        //推荐topMovie
        List<Movie> list = topdefaultMovieService.SelectRegDefaultMovie();
        request.getSession().setAttribute("TopRegDefaultMovie", list);
        return "register";
    }

    //点击注册按钮后先对用户名和邮箱进行检查
    @RequestMapping("/customer/checkboth/{paramName}/{paramEmail}/{type}")
    @ResponseBody
    public E3Result checkDataBoth(@PathVariable String paramName, @PathVariable String paramEmail, @PathVariable Integer type){
        try {
            String str = URLDecoder.decode(paramName, "UTF-8"); //如果前端传入的中文， 则解码.
            E3Result e3Result = registerService.checkDataBoth(str, paramEmail, type);
            return e3Result;
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    //检查用户名/邮箱是否符合规范(在没有点击注册按钮前检查)
    @RequestMapping("/customer/check/{param}/{type}")
    @ResponseBody
    public E3Result checkData(@PathVariable String param, @PathVariable Integer type){
        try {
            String str = URLDecoder.decode(param, "UTF-8");
            E3Result e3Result = registerService.checkData(str, type);
            return e3Result;
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    //检查完成后注册
    @RequestMapping(value = "/customer/register", method = RequestMethod.POST)
    @ResponseBody
    public E3Result register(User user, HttpServletRequest request) {
        //返回用户id,用于用户选择喜欢的电影后把相应信息存broswer表
        Integer userId = 0;
        E3Result e3Result = registerService.register(user);
        if (e3Result.getStatus() == 200) {
            userId = (Integer) e3Result.getData();
        }
        request.getSession().setAttribute("userId", userId);
        System.out.println("------------注册成功--------------");
        return e3Result;
    }

    //注册完成后选择喜欢的电影
    @RequestMapping(value = "/customer/register/movieSubmit", method = RequestMethod.POST)
    @ResponseBody
    public String selectedMovie (String ids, HttpServletRequest request) {
        if (ids == null || ids == "")
            return "fail";
        else {
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            Browse browse = new Browse();
            System.out.println(userId);
            browse.setUserid(userId);
            browse.setMovieids(ids);
            browse.setBrowsetime(new Date());
            registerService.selectFavorite(browse);
            return "ok";
        }
    }

    //选择完电影后点击确定跳转到登录界面
    @RequestMapping("/page/login")
    public String log() {
        return "login";
    }

    //点击登录后
    @RequestMapping(value = "/customer/login", method = RequestMethod.POST)
    @ResponseBody
    public E3Result login(String username, String password, Model model, HttpServletRequest request) {
        E3Result e3Result = loginService.userLogin(username, password);
        User user = null;
        // 登录成功
        if (e3Result.getStatus() == 200) {
            user = (User)e3Result.getData();
        }
        request.getSession().setAttribute("user", user);

        return e3Result;
    }

    //用户退出
    @RequestMapping("/page/logout")
    public String pagelogout(HttpServletRequest request) {
        // 注销session
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("TopRegDefaultMovie");
        return "Home";
    }

    // 更新密码
    @RequestMapping("/user/update")
    @ResponseBody
    public String update(HttpServletRequest request) {
        String useridstr = request.getParameter("userid");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Integer userid = Integer.parseInt(useridstr);

        userService.updateUser(userid, password, email);
        return "ok";
    }

    @RequestMapping("/user/edit")
    @ResponseBody
    public User getUserById(Integer id) {
        User user = userService.getUserById(id);
        return user;
    }

}
