package com.itsthatjun.spring.ecommerce.Service;

import com.itsthatjun.spring.ecommerce.mbg.model.Admin;
import com.itsthatjun.spring.ecommerce.mbg.model.Permission;

import java.util.List;

public interface AdminService {
    String login(String username, String password);
    String register(Admin admin);
    Admin getAdminByUsername(String username);
    List<Permission> getPermissionList(int id);
}
