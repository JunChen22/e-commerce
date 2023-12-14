package com.itsthatjun.ecommerce.dto.UMS;

import com.itsthatjun.ecommerce.mbg.model.Admin;
import com.itsthatjun.ecommerce.mbg.model.AdminLoginLog;
import com.itsthatjun.ecommerce.mbg.model.Permission;
import com.itsthatjun.ecommerce.mbg.model.Roles;
import lombok.Data;

import java.util.List;

@Data
public class AdminDetail {

    private Admin admin;
    private List<Roles> roles;
    private List<Permission> permissions;
    private List<AdminLoginLog> loginLogs;
}
