package com.itsthatjun.ecommerce.controller;

import com.itsthatjun.ecommerce.dao.AdminDao;
import com.itsthatjun.ecommerce.mbg.model.AdminLoginLog;
import com.itsthatjun.ecommerce.mbg.model.Permission;
import com.itsthatjun.ecommerce.mbg.model.Roles;
import com.itsthatjun.ecommerce.service.UMS.implementation.AdminServiceImpl;
import com.itsthatjun.ecommerce.mbg.model.Admin;
import com.itsthatjun.ecommerce.security.LoginRequest;
import com.itsthatjun.ecommerce.security.LoginResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@Api(tags = {"Admin related"}, description = "admin related")
public class AdminController {

    private final AdminServiceImpl adminService;

    private final AdminDao adminDao;

    @Autowired
    public AdminController(AdminServiceImpl adminService, AdminDao adminDao) {
        this.adminService = adminService;
        this.adminDao = adminDao;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        String token = adminService.login(request.getUsername(), request.getPassword());
        if(token.isEmpty()){
            return new ResponseEntity<>(new LoginResponse(false, token), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new LoginResponse(true, token));
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ROLE_admin-root')")
    @ApiOperation(value = "Register a admin account, only main admin can create another admin and assign role and permission")
    public ResponseEntity<?> register(@RequestBody Admin admin){

        // TODO: register a admin
        //adminService.register(admin);
        return null;
    }

    @PreAuthorize("hasRole('ROLE_admin-user')")
    @GetMapping("/roles/{id}")
    @ApiOperation(value = "")
    public List<Roles> getRole(@PathVariable int id){
        List<Roles> roles = adminDao.getRolesList(id);
        return roles;
    }

    @PreAuthorize("hasRole('ROLE_admin-user')")
    @GetMapping("/permission/{id}")
    @ApiOperation(value = "")
    public List<Permission> getPermission(@PathVariable int id){
        List<Permission> permissions = adminDao.getPermissionList(id);
        return permissions;
    }

    @GetMapping("/logs/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    @ApiOperation(value = "")
    public List<AdminLoginLog> getLoginLogs(@PathVariable int id){
        List<AdminLoginLog> logs = adminDao.getLoginLog(id);
        return logs;
    }
}
