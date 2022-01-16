package com.itsthatjun.spring.ecommerce.controller.admin;

import com.itsthatjun.spring.ecommerce.Service.impl.AdminServiceImpl;
import com.itsthatjun.spring.ecommerce.mbg.model.Admin;
import com.itsthatjun.spring.ecommerce.security.LoginRequest;
import com.itsthatjun.spring.ecommerce.security.LoginResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Api(tags = {"User related"})
public class AdminController {

    private final AdminServiceImpl adminService;

    @Autowired
    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        System.out.println("at login page");
        String token = adminService.login(request.getUsername(), request.getPassword());
        if(token.isEmpty()){
            return new ResponseEntity<>(new LoginResponse(false, token), HttpStatus.NOT_FOUND);
        }
        adminService.getPermissionList(0);
        return new ResponseEntity<>(new LoginResponse(true, token),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin){
        adminService.register(admin);
        return null;
    }
}
