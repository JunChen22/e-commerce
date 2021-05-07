package com.example.spring.ecommerce.demo.springecommerce.Service.impl;

import com.example.spring.ecommerce.demo.springecommerce.Service.MemberReadHistoryService;
import com.example.spring.ecommerce.demo.springecommerce.mongodb.Document.MemberReadHistory;
import com.example.spring.ecommerce.demo.springecommerce.mongodb.Repository.MemberReadHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberReadHistoryImpl implements MemberReadHistoryService {

    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;

    @Override
    public int create(MemberReadHistory memberReadHistory) {
        System.out.println("at creating member history");
        memberReadHistoryRepository.save(memberReadHistory);
        System.out.println(memberReadHistory.getMemberNickname() + " saved");
        return 0;
    }

    @Override
    public List<MemberReadHistory> list(String memberId) {
        return memberReadHistoryRepository.findAllById(memberId);
    }
}
