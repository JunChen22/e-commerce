package com.itsthatjun.ecommerce.service.UMS.implementation;

import com.itsthatjun.ecommerce.mbg.mapper.MemberMapper;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.security.CustomUserDetail;
import com.itsthatjun.ecommerce.security.jwt.JwtTokenUtil;
import com.itsthatjun.ecommerce.service.UMS.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
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
public class MemberServiceImpl implements MemberService , UserDetailsService {

    private final MemberMapper memberMapper;

    private final JwtTokenUtil jwtTokenUtil;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper, JwtTokenUtil jwtTokenUtil) {
        this.memberMapper = memberMapper;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    public String generateAuthCode(String telephone) {
        // TODO: redis
        return null;
    }

    @Override
    public String verifyAuthCode(String telephone, String authCode) {
        // TODO: redis
        return null;
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
    public String register(Member newMember) {
        newMember.setCreatedAt(new Date());
        newMember.setStatus(1);
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(newMember.getUsername());
        List<Member> existing = memberMapper.selectByExample(example);

        if(!existing.isEmpty()){
            System.out.println("existing account");
            return null; // TODO: make exception for existing account
        }
        newMember.setPassword(passwordEncoder().encode(newMember.getPassword()));
        memberMapper.insert(newMember);
        return "Member successfully added";
    }

    @Override
    public Member getMemberByUserName(String username) {
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);

        List<Member> memberList = memberMapper.selectByExample(example);

        if(memberList != null && !memberList.isEmpty()){
            return memberList.get(0);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = getMemberByUserName(username);
        if(member != null){
            return new CustomUserDetail(member);
        }
        //TODO: wasn't invoked when entering wrong username
        throw new UsernameNotFoundException("Username not found");
    }

    @Override
    public Member getCurrentUser() {
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        CustomUserDetail memberDetail = (CustomUserDetail) auth.getPrincipal();
        return memberDetail.getMember();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
