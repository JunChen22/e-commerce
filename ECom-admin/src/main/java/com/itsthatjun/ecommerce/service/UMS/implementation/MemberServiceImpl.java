package com.itsthatjun.ecommerce.service.UMS.implementation;

import com.itsthatjun.ecommerce.mbg.mapper.MemberMapper;
import com.itsthatjun.ecommerce.mbg.model.Member;
import com.itsthatjun.ecommerce.mbg.model.MemberExample;
import com.itsthatjun.ecommerce.service.UMS.MemberService;

import com.itsthatjun.ecommerce.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Random;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public Member getUserDetail(String username) {
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Member> member = memberMapper.selectByExample(example);
        return member.get(0);
    }

    @Override
    public Member deactivateMember(String username) {
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Member> members = memberMapper.selectByExample(example);
        members.get(0).setStatus(0);
        memberMapper.updateByExampleSelective(members.get(0), example);
        return members.get(0);
    }

    @Override
    public Member activateMember(String username) {
        MemberExample example = new MemberExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<Member> members = memberMapper.selectByExample(example);
        members.get(0).setStatus(1);
        memberMapper.updateByExampleSelective(members.get(0), example);
        return members.get(0);
    }
}
