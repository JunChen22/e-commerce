package com.itsthatjun.spring.ecommerce.Service;

import com.itsthatjun.spring.ecommerce.mongodb.Document.MemberReadHistory;

import java.util.List;

public interface MemberReadHistoryService {

    int create(MemberReadHistory memberReadHistory);

    List<MemberReadHistory> list(String memberId);
}
