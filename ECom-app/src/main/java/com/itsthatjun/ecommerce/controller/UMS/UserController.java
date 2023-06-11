package com.itsthatjun.ecommerce.controller.UMS;

import com.itsthatjun.ecommerce.mbg.model.Member;
import com.itsthatjun.ecommerce.security.LoginRequest;
import com.itsthatjun.ecommerce.security.LoginResponse;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(tags = "User related", description = "retrieve user information")
public class UserController {

    private final MemberServiceImpl memberService;

    @Autowired
    public UserController(MemberServiceImpl memberService) {
        this.memberService = memberService;
    }

    // retrieve user Order

    // retrieve user data

    // update user account

    @PostMapping("/login")
    @ApiOperation(value = "Login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        String token = memberService.login(request.getUsername(), request.getPassword());
        if(token.isEmpty()){
            return new ResponseEntity<>(new LoginResponse(false, token), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new LoginResponse(true, token));
    }

    @PostMapping("/register")
    @ApiOperation(value = "Register")
    public ResponseEntity<?> register(@RequestBody Member member){
        memberService.register(member);
        return null;
    }

    // delete user
}
