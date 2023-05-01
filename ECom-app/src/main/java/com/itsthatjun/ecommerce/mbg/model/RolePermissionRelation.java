package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;

public class RolePermissionRelation {
    private Integer id;

    private BigDecimal roleId;

    private BigDecimal permissionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getRoleId() {
        return roleId;
    }

    public void setRoleId(BigDecimal roleId) {
        this.roleId = roleId;
    }

    public BigDecimal getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(BigDecimal permissionId) {
        this.permissionId = permissionId;
    }
}