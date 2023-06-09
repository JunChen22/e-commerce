package com.itsthatjun.ecommerce.service;

import com.itsthatjun.ecommerce.mongodb.Document.MemberReadHistory;

import java.util.List;

public interface MemberReadHistoryService {

    int create(MemberReadHistory memberReadHistory);

    List<MemberReadHistory> list(String memberId);
}
