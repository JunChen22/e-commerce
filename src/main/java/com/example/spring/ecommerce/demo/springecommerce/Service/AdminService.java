package com.example.spring.ecommerce.demo.springecommerce.Service;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Admin;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Permission;

import java.util.List;

public interface AdminService {
    String login(String username, String password);
    String register(Admin admin);
    Admin getAdminByUsername(String username);
    List<Permission> getPermissionList(int id);
}
