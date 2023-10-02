package com.itsthatjun.ecommerce.dto.SMS;

import com.itsthatjun.ecommerce.dto.DiscountType;
import com.itsthatjun.ecommerce.dto.PromotionType;
import com.itsthatjun.ecommerce.mbg.model.PromotionSale;
import com.itsthatjun.ecommerce.mbg.model.PromotionSaleProduct;
import lombok.Data;

import java.util.List;


@Data
public class OnSaleRequest {
    private PromotionSale promotionSale;
    private PromotionType promotionType;
    private DiscountType discountType;
    private double discountAmount;
    private int productCategoryId;
    private int brandId;
    private String operator;
    private List<PromotionSaleProduct> onSaleProduct;
}
