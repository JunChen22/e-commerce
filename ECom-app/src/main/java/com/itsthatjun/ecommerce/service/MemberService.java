package com.itsthatjun.ecommerce.service;

import com.itsthatjun.ecommerce.mbg.model.Admin;

public interface MemberService {

    String generateAuthCode(String telephone);

    String verifyAuthCode(String telephone, String authCode);

    String login(String username, String password);

    String register(Admin admin);
}
