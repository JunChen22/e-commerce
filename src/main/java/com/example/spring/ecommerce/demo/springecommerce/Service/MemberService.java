package com.example.spring.ecommerce.demo.springecommerce.Service;

import com.example.spring.ecommerce.demo.springecommerce.mbg.model.Member;

public interface MemberService {

    String generateAuthCode(String telephone);

    String verifyAuthCode(String telephone, String authCode);
}
