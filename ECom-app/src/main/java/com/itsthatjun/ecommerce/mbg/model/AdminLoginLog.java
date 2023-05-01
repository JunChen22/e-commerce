package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;
import java.util.Date;

public class AdminLoginLog {
    private Integer id;

    private BigDecimal adminId;

    private Date loginTime;

    private String ipAddress;

    private String userAgent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAdminId() {
        return adminId;
    }

    public void setAdminId(BigDecimal adminId) {
        this.adminId = adminId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}