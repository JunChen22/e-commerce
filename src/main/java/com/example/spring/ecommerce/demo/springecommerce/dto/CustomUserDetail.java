package com.example.spring.ecommerce.demo.springecommerce.dto;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Permission;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {

    private Admin admin;
    private List<Permission> permissionList;

    public CustomUserDetail(Admin admin, List<Permission> permissionList) {
        this.admin = admin;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return admin.getPassword();
    }

    @Override
    public String getUsername() {
        return admin.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
