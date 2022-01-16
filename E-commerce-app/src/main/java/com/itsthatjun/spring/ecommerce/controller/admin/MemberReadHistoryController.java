package com.itsthatjun.spring.ecommerce.controller.admin;

import com.itsthatjun.spring.ecommerce.Service.impl.MemberReadHistoryImpl;
import com.itsthatjun.spring.ecommerce.mongodb.Document.MemberReadHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member/readHistory")
public class MemberReadHistoryController {

    @Autowired
    private MemberReadHistoryImpl memberReadHistoryService;

    @PostMapping("/create")
    public String createMemberHistory(@RequestBody MemberReadHistory memberReadHistory){
        System.out.println("at member history controller");
        memberReadHistoryService.create(memberReadHistory);
        return "created";
    }

    @GetMapping("/read/{id}")
    public String getMembers(@PathVariable String id){
        System.out.println("getting member id " + id);
        for(MemberReadHistory history: memberReadHistoryService.list(id)){
            System.out.println(history.getMemberNickname());
        }
        return "get member history done";
    }
}
