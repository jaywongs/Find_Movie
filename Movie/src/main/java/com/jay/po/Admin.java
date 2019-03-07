package com.jay.po;

public class Admin {
    private Integer adminid;

    private String adminname;

    private String adminpassword;

    private Integer role;

    public Admin(Integer adminid, String adminname, String adminpassword, Integer role) {
        this.adminid = adminid;
        this.adminname = adminname;
        this.adminpassword = adminpassword;
        this.role = role;
    }

    public Admin() {
        super();
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword == null ? null : adminpassword.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}