package com.example.spring.ecommerce.demo.springecommerce.Service;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Member;

public interface MemberService {

    public Member getMemberByUserName(String username);
}
