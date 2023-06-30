package com.itsthatjun.ecommerce.service.SMS.implementation;

import com.itsthatjun.ecommerce.mbg.mapper.ProductMapper;
import com.itsthatjun.ecommerce.mbg.mapper.PromotionSaleMapper;
import com.itsthatjun.ecommerce.mbg.model.Product;
import com.itsthatjun.ecommerce.mbg.model.ProductExample;
import com.itsthatjun.ecommerce.mbg.model.PromotionSale;
import com.itsthatjun.ecommerce.mbg.model.PromotionSaleExample;
import com.itsthatjun.ecommerce.service.SMS.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceimpl implements SalesService {

    private final PromotionSaleMapper promotionSaleMapper;

    private final ProductMapper productMapper;

    @Autowired
    public SalesServiceimpl(PromotionSaleMapper promotionSaleMapper, ProductMapper productMapper) {
        this.promotionSaleMapper = promotionSaleMapper;
        this.productMapper = productMapper;
    }

    // 0-> not on sale; 1-> is on sale; 2-> flash sale/special sales/clarance/used item
    @Override
    public List<PromotionSale> getAllPromotionalSale() {
        PromotionSaleExample saleExample = new PromotionSaleExample();
        saleExample.createCriteria().andStatusEqualTo(1);  // default active sales
        List<PromotionSale> result = promotionSaleMapper.selectByExample(saleExample);
        return result.size() > 0 ? result : null;
    }

    // 0-> not on sale; 1-> is on sale; 2-> flash sale/special sales/clarance/used item

    @Override
    public List<Product> getAllPromotionalSaleItems() {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andOnSaleStatusBetween(0,2); // not inclusive
        List<Product> result = productMapper.selectByExample(productExample);
        return result.size() > 0 ? result : null;
    }

    @Override
    public List<Product> getAllFlashSaleItems() {
        ProductExample productExample = new ProductExample();
        productExample.createCriteria().andOnSaleStatusBetween(1,3); // not inclusive
        List<Product> result = productMapper.selectByExample(productExample);
        return result.size() > 0 ? result : null;
    }
}
