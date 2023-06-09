package com.itsthatjun.ecommerce.security;

import com.itsthatjun.ecommerce.mbg.model.Admin;
import com.itsthatjun.ecommerce.mbg.model.Permission;
import com.itsthatjun.ecommerce.mbg.model.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetail implements UserDetails {

    private Admin admin;
    private List<Roles> rolesList;
    private List<Permission> permissionList;

    public CustomUserDetail(Admin admin, List<Roles> rolesList, List<Permission> permissionList) {
        this.admin = admin;
        this.rolesList = rolesList;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();
        // Add authorities for permissions
        authorities.addAll(permissionList.stream()
                .filter(permission -> permission.getValue() != null && permission.getStatus().equals("active"))
                .map(permission -> new SimpleGrantedAuthority(permission.getValue()))
                .collect(Collectors.toList()));

        // Add authorities for roles
        authorities.addAll(rolesList.stream()
                .filter(role -> role.getStatus().equals("active"))
                .map(role -> new SimpleGrantedAuthority( role.getName()))
                .collect(Collectors.toList()));

        return authorities;
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
