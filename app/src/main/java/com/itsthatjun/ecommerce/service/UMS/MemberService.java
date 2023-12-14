package com.itsthatjun.ecommerce.service.UMS;

import com.itsthatjun.ecommerce.dto.UMS.MemberDetail;
import com.itsthatjun.ecommerce.mbg.model.Address;
import com.itsthatjun.ecommerce.mbg.model.Member;
import com.itsthatjun.ecommerce.mbg.model.MemberLoginLog;
import io.swagger.annotations.ApiOperation;
import reactor.core.publisher.Mono;

public interface MemberService {

    @ApiOperation(value = "")       // TODO: with redis and sending email
    String generateAuthCode(String telephone);

    @ApiOperation(value = "")      // TODO: use redis to send out auth code
    String verifyAuthCode(String telephone, String authCode);

    @ApiOperation(value = "")
    MemberDetail register(MemberDetail memberDetail);

    @ApiOperation(value = "")
    MemberDetail getInfo(int userId);

    @ApiOperation(value = "")
    Member updatePassword(int userId, String newPassword);

    @ApiOperation(value = "password, name, icon")
    Member updateInfo(MemberDetail memberDetail);

    @ApiOperation(value = "")
    Address updateAddress(int userId, Address newAddress);

    @ApiOperation(value = "")
    void deleteAccount(int userId);

    @ApiOperation(value = "")
    Member getCurrentUser();
}
