package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;
import java.util.Date;

public class MemberLoginLog {
    private Integer id;

    private BigDecimal memberId;

    private Date loginTime;

    private String ipAddress;

    private String loginType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMemberId() {
        return memberId;
    }

    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
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

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }
}