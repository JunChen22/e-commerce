package com.itsthatjun.ecommerce.service.UMS.implementation;

import com.itsthatjun.ecommerce.dto.UMS.MemberDetail;
import com.itsthatjun.ecommerce.mbg.mapper.AddressMapper;
import com.itsthatjun.ecommerce.mbg.mapper.MemberChangeLogMapper;
import com.itsthatjun.ecommerce.mbg.mapper.MemberMapper;
import com.itsthatjun.ecommerce.mbg.model.*;
import com.itsthatjun.ecommerce.security.CustomUserDetail;
import com.itsthatjun.ecommerce.service.UMS.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService , UserDetailsService {

    private final MemberMapper memberMapper;

    private final AddressMapper addressMapper;

    private final MemberChangeLogMapper logMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper, AddressMapper addressMapper, MemberChangeLogMapper logMapper) {
        this.memberMapper = memberMapper;
        this.addressMapper = addressMapper;
        this.logMapper = logMapper;
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
    public MemberDetail register(MemberDetail memberDetail) {
        Member newMember = memberDetail.getMember();
        Address address = memberDetail.getAddress();

        String newUserName = newMember.getUsername();
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(newUserName);
        List<Member> existing = memberMapper.selectByExample(example);

        if (!existing.isEmpty()) {
            System.out.println("existing account");
            return null; // TODO: make exception for existing account
        }

        String passWord = newMember.getPassword();
        newMember.setPassword(passwordEncoder().encode(passWord));

        newMember.setCreatedAt(new Date());
        newMember.setStatus(1);
        memberMapper.insert(newMember);

        int newMemberId = newMember.getId();

        address.setMemberId(newMemberId);
        addressMapper.insert(address);

        createUpdateLog(newMemberId, "create account", "user");
        return memberDetail;
    }

    @Override
    public MemberDetail getInfo(int userId) {
        MemberDetail memberDetail = new MemberDetail();
        Member member = memberMapper.selectByPrimaryKey(userId);
        memberDetail.setMember(member);

        AddressExample addressExample = new AddressExample();
        addressExample.createCriteria().andMemberIdEqualTo(userId);
        List<Address> addressList = addressMapper.selectByExample(addressExample);

        if (!addressList.isEmpty()) memberDetail.setAddress(addressList.get(0));

        return memberDetail;
    }

    @Override
    public Member updatePassword(int userId, String newPassword) {
        Member member = memberMapper.selectByPrimaryKey(userId);
        String currentPassword = member.getPassword();
        String newEncodedPassword = passwordEncoder().encode(newPassword);

        if (passwordEncoder().matches(newPassword, currentPassword)) return member; // TODO: send reminder, same password

        member.setPassword(newEncodedPassword);
        memberMapper.updateByPrimaryKey(member);

        createUpdateLog(member.getId(), "update account password", "user");
        return member;
    }

    @Override
    public Member updateInfo(MemberDetail memberDetail) {
        int userId = memberDetail.getMember().getId();
        Member member = memberMapper.selectByPrimaryKey(userId);

        Member updateMember = memberDetail.getMember();

        memberMapper.updateByPrimaryKey(updateMember);
        createUpdateLog(member.getId(), "update account information", "user");
        return updateMember;
    }

    @Override
    public Address updateAddress(int userId, Address newAddress) {
        newAddress.setMemberId(userId);
        addressMapper.updateByPrimaryKeySelective(newAddress);
        createUpdateLog(userId, "update account address", "user");
        return newAddress;
    }

    @Override
    public void deleteAccount(int userId) {
        Member member = memberMapper.selectByPrimaryKey(userId);
        member.setDeleteStatus(1);
        member.setStatus(0);

        memberMapper.updateByPrimaryKey(member);
        createUpdateLog(member.getId(), "delete account", "user");
    }

    private void createUpdateLog(int userId, String updateAction, String operator) {
        MemberChangeLog changeLog = new MemberChangeLog();
        changeLog.setMemberId(userId);
        changeLog.setUpdateAction(updateAction);
        changeLog.setOperator(operator);
        changeLog.setCreatedAt(new Date());
        logMapper.insert(changeLog);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = getMemberByUserName(username);
        if (member != null) {
            return new CustomUserDetail(member);
        }
        //TODO: wasn't invoked when entering wrong username
        throw new UsernameNotFoundException("Username not found");
    }

    private Member getMemberByUserName(String username) {
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Member> memberList = memberMapper.selectByExample(example);

        if (memberList.isEmpty()) return null;
        return memberList.get(0);
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
