package com.itsthatjun.ecommerce.elasticsearch.repository;

import com.itsthatjun.ecommerce.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsProductRepository extends ElasticsearchRepository<EsProduct, Long> {

    List<EsProduct> findByKeywords(String keyword);
    List<EsProduct> findByName(String name);
    List<EsProduct> findByNameOrKeywords(String name, String keywords);
    List<EsProduct> findByNameContainingOrSubTitleContainingOrKeywordsContaining(String name, String subtitle, String keywords, Pageable page);
    // Elastic Search don't support findAllContaining
    List<EsProduct> findAll();

    List<EsProduct> findByNameContainingOrKeywordsContaining(String name, String keywords);
}
