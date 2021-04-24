package com.example.spring.ecommerce.demo.springecommerce.controller;

import com.example.spring.ecommerce.demo.springecommerce.Service.MemberService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sso")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public String getAuthCode(@RequestParam String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public String updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone,authCode);
    }
}
