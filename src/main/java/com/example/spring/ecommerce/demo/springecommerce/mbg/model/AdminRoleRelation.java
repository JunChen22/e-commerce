package com.example.spring.ecommerce.demo.springecommerce.mbg.model;

import java.math.BigDecimal;

public class AdminRoleRelation {
    private Integer id;

    private BigDecimal adminId;

    private BigDecimal roleId;

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

    public BigDecimal getRoleId() {
        return roleId;
    }

    public void setRoleId(BigDecimal roleId) {
        this.roleId = roleId;
    }
}