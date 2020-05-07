package com.example.spring.ecommerce.demo.springecommerce.Service.impl;

import com.example.spring.ecommerce.demo.springecommerce.Service.MemberService;
import com.example.spring.ecommerce.demo.springecommerce.mbg.mapper.MemberMapper;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Member;
import com.example.spring.ecommerce.demo.springecommerce.mbg.model.MemberExample;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
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
}
