package com.itsthatjun.ecommerce.service.UMS.implementation;

import com.itsthatjun.ecommerce.dao.AdminDao;
import com.itsthatjun.ecommerce.security.CustomUserDetail;
import com.itsthatjun.ecommerce.mbg.mapper.AdminMapper;
import com.itsthatjun.ecommerce.mbg.model.Admin;
import com.itsthatjun.ecommerce.mbg.model.AdminExample;
import com.itsthatjun.ecommerce.mbg.model.Permission;
import com.itsthatjun.ecommerce.mbg.model.Roles;
import com.itsthatjun.ecommerce.security.jwt.JwtTokenUtil;
import com.itsthatjun.ecommerce.service.UMS.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements UserDetailsService, AdminService {

    @Autowired
    private final AdminMapper adminMapper;

    private final JwtTokenUtil jwtTokenUtil;

    private final AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminMapper adminMapper, JwtTokenUtil jwtTokenUtil, AdminDao adminDao) {
        this.adminMapper = adminMapper;
        this.jwtTokenUtil = jwtTokenUtil;
        this.adminDao = adminDao;
    }

    @Override
    public String register(Admin newAdmin) {
        newAdmin.setCreatedAt(new Date());
        newAdmin.setStatus("active");
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(newAdmin.getUsername());
        List<Admin> existing = adminMapper.selectByExample(example);

        //TODO: add role and permission, maybe in here or a separate controller/dao
        if(!existing.isEmpty()){
            System.out.println("existing account");
            return null; // TODO: make exception for existing account
        }
        newAdmin.setPassword(passwordEncoder().encode(newAdmin.getPassword()));
        adminMapper.insert(newAdmin);
        return "Admin successfully added";
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

            // Authorities shouldn't be giving during validation
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            // TODO: add a login error exception
            System.out.println("login error");
        }
        return token;
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

            List<Permission> permissions = adminDao.getPermissionList(admin.getId());
            List<Roles> roles = adminDao.getRolesList(admin.getId());

            return new CustomUserDetail(admin, roles, permissions);
        }
        //TODO: wasn't invoked when entering wrong username
        throw new UsernameNotFoundException("Username not found");
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
