package com.itsthatjun.ecommerce.service.UMS;

import com.itsthatjun.ecommerce.mbg.model.Admin;
import com.itsthatjun.ecommerce.mbg.model.Member;

public interface MemberService {

    String generateAuthCode(String telephone);

    String verifyAuthCode(String telephone, String authCode);

    String login(String username, String password);

    String register(Member member);

    // TODO: use redis to send out auth code
    // public void updatePassword();

    Member getMemberByUserName(String username);

    Member getCurrentUser();
}
