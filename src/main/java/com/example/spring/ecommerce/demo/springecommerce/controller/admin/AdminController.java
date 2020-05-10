package com.example.spring.ecommerce.demo.springecommerce.controller.admin;

import com.example.spring.ecommerce.demo.springecommerce.Service.impl.AdminServiceImpl;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Admin;
import com.example.spring.ecommerce.demo.springecommerce.security.LoginRequest;
import com.example.spring.ecommerce.demo.springecommerce.security.LoginResponse;
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
        String token = adminService.login(request.getUsername(), request.getPassword());
        if(token.isEmpty()){
            return new ResponseEntity<>(new LoginResponse(false, token), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new LoginResponse(true, token),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Admin admin){
        adminService.register(admin);
        return null;
    }
}
