package com.example.spring.ecommerce.demo.springecommerce.dao;

import com.example.spring.ecommerce.demo.springecommerce.elasticsearch.document.EsProduct;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
