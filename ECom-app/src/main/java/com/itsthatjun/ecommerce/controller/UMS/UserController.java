package com.itsthatjun.ecommerce.controller.UMS;

import com.itsthatjun.ecommerce.dto.UMS.MemberDetail;
import com.itsthatjun.ecommerce.mbg.model.Address;
import com.itsthatjun.ecommerce.service.Messaging.UserMessageService;
import com.itsthatjun.ecommerce.service.UMS.implementation.MemberServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api(tags = "User related", description = "retrieve user information")
public class UserController {

    private final MemberServiceImpl memberService;

    private final UserMessageService messageService;

    @Autowired
    public UserController(MemberServiceImpl memberService, UserMessageService messageService) {
        this.memberService = memberService;
        this.messageService = messageService;
    }

    @GetMapping("/getInfo")
    @ApiOperation(value = "")
    public MemberDetail getInfo() {
        int userId = memberService.getCurrentUser().getId();
        return memberService.getInfo(userId);
    }

    @PostMapping("/register")
    @ApiOperation(value = "Register")
    public MemberDetail register(@RequestBody MemberDetail newMemberDetail) {
        messageService.sendUserNewMessage(newMemberDetail);
        return newMemberDetail;
    }

    @PostMapping("/updatePassword")
    @ApiOperation(value = "")
    public String updatePassword(@RequestBody String newPassword) {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendUserNewPassWordMessage(newPassword, userId);
        return newPassword;
    }

    @PostMapping("/updateInfo")
    @ApiOperation(value = "password, name, icon")
    public MemberDetail updateInfo(@RequestBody MemberDetail memberDetail) {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendUserUpdateInfoMessage(memberDetail, userId);
        return memberDetail;
    }

    @PostMapping("/updateAddress")
    @ApiOperation(value = "")
    public Address updateAddress(@RequestBody Address newAddress) {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendUserUpdateAddressMessage(newAddress, userId);
        return newAddress;
    }

    @PostMapping("/deleteAccount")
    @ApiOperation(value = "")
    public void deleteAccount() {
        int userId = memberService.getCurrentUser().getId();
        messageService.sendUserDeleteAccountMessage(userId);
    }
}
