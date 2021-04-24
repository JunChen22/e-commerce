package com.example.spring.ecommerce.demo.springecommerce.mongodb.Repository;

import com.example.spring.ecommerce.demo.springecommerce.mongodb.Document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory, String> {
    List<MemberReadHistory> findAllById(String memberId);
    MemberReadHistory findByProductId(Long productId);
}
