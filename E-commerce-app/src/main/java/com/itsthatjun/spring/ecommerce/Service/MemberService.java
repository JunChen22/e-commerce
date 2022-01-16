package com.itsthatjun.spring.ecommerce.Service;

public interface MemberService {

    String generateAuthCode(String telephone);

    String verifyAuthCode(String telephone, String authCode);
}
