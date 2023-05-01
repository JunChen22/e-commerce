package com.itsthatjun.ecommerce.Service;

public interface MemberService {

    String generateAuthCode(String telephone);

    String verifyAuthCode(String telephone, String authCode);
}
