package com.itsthatjun.ecommerce.controller.UMS;

import com.itsthatjun.ecommerce.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
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

    @PostMapping("/login")
    public String login() {
        return "hello";
    }


    @PostMapping("/register")
    public String register() {
        return "hello";
    }
}
