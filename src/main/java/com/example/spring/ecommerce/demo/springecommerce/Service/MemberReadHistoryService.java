package com.example.spring.ecommerce.demo.springecommerce.Service;

import com.example.spring.ecommerce.demo.springecommerce.mongodb.Document.MemberReadHistory;

import java.util.List;

public interface MemberReadHistoryService {

    int create(MemberReadHistory memberReadHistory);

    List<MemberReadHistory> list(String memberId);
}
