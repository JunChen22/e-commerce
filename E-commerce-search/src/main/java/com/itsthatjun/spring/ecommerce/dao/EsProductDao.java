package com.itsthatjun.spring.ecommerce.dao;

import com.itsthatjun.spring.ecommerce.elasticsearch.document.EsProduct;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
