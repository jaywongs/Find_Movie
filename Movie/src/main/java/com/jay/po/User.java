package com.jay.po;

import java.util.Date;

public class User {
    private Integer userid;

    private String username;

    private String password;

    private Date registertime;

    private Date lastlogintime;

    private String email;

    public User(Integer userid, String username, String password, Date registertime, Date lastlogintime, String email) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.registertime = registertime;
        this.lastlogintime = lastlogintime;
        this.email = email;
    }

    public User() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}