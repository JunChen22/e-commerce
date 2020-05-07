package com.example.spring.ecommerce.demo.springecommerce.controller.admin;

import com.example.spring.ecommerce.demo.springecommerce.Service.impl.AdminServiceImpl;
import com.example.spring.ecommerce.demo.springecommerce.security.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminServiceImpl adminService;

    @Autowired
    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody  LoginRequest request){
        String token = adminService.login(request.getUsername(), request.getPassword());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
