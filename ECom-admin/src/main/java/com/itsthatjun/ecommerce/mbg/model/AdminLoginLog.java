package com.itsthatjun.ecommerce.mbg.model;

import java.util.Date;

public class AdminLoginLog {
    private Integer id;

    private Integer adminId;

    private Date loginDate;

    private String loginTime;

    private String ipAddress;

    private Integer userAgent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Integer getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(Integer userAgent) {
        this.userAgent = userAgent;
    }
}