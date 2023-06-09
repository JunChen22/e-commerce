package com.itsthatjun.ecommerce.service.UMS;


import com.itsthatjun.ecommerce.mbg.model.Admin;
import com.itsthatjun.ecommerce.mbg.model.Permission;

import java.util.List;

public interface AdminService {
    String login(String username, String password);
    String register(Admin admin);
    Admin getAdminByUsername(String username);
}
