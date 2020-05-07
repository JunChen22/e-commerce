package com.example.spring.ecommerce.demo.springecommerce.Service.impl;

import com.example.spring.ecommerce.demo.springecommerce.Service.AdminService;
import com.example.spring.ecommerce.demo.springecommerce.dto.CustomUserDetail;
import com.example.spring.ecommerce.demo.springecommerce.mbg.mapper.AdminMapper;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Admin;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.AdminExample;
import com.example.spring.ecommerce.demo.springecommerce.security.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AdminServiceImpl implements UserDetailsService, AdminService {

    private final AdminMapper adminMapper;
    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper, JwtTokenUtil jwtTokenUtil) {
        this.adminMapper = adminMapper;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public String login(String username, String password) {
        String token = "";
        try{
            UserDetails userDetails = loadUserByUsername(username);
            // decode password to compare
            if(!passwordEncoder().matches(password, userDetails.getPassword())){
                throw new BadCredentialsException("incorrect password");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            System.out.println("login error");
        }
        return token;
    }

    @Override
    public String register() {
        //TODO: register
        return null;
    }

    @Override
    public Admin getAdminByUsername(String username) {
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Admin> AdminList = adminMapper.selectByExample(example);
        if(AdminList != null && !AdminList.isEmpty()){
            return AdminList.get(0);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = getAdminByUsername(username);
        if(admin != null){
            // TODO: empty permission for now
            return new CustomUserDetail(admin, Collections.emptyList());
        }
        throw new UsernameNotFoundException("Username not found");
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
