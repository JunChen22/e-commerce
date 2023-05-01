package com.itsthatjun.ecommerce.dao;

import com.itsthatjun.ecommerce.elasticsearch.document.EsProduct;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EsProductDao {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
