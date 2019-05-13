package com.jay.service;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * created by jaywang on 2019/5/10.
 */
@Service
public class SystemLogoutFilter extends LogoutFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        //退出系统前清除程序
        Subject subject = getSubject(request, response);
        String redirectUrl = getRedirectUrl(request, response, subject);

        try {
            subject.logout();
        } catch (SessionException e){
            e.printStackTrace();
        }
        issueRedirect(request, response, redirectUrl);

        return false;
    }
}
