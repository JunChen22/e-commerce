package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;

public class PromotionSaleProduct {
    private Integer id;

    private Integer promotionSaleId;

    private Integer productId;

    private String productSkuCode;

    private BigDecimal promotionPrice;

    private Integer promotionLimitItem;

    private Integer promotionLimitPerUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPromotionSaleId() {
        return promotionSaleId;
    }

    public void setPromotionSaleId(Integer promotionSaleId) {
        this.promotionSaleId = promotionSaleId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductSkuCode() {
        return productSkuCode;
    }

    public void setProductSkuCode(String productSkuCode) {
        this.productSkuCode = productSkuCode;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getPromotionLimitItem() {
        return promotionLimitItem;
    }

    public void setPromotionLimitItem(Integer promotionLimitItem) {
        this.promotionLimitItem = promotionLimitItem;
    }

    public Integer getPromotionLimitPerUser() {
        return promotionLimitPerUser;
    }

    public void setPromotionLimitPerUser(Integer promotionLimitPerUser) {
        this.promotionLimitPerUser = promotionLimitPerUser;
    }
}