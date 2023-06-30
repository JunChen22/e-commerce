package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;

public class PromotionSaleProductRelation {
    private Integer id;

    private Integer promotionSaleId;

    private Integer productId;

    private String productSkuCode;

    private BigDecimal promotionPrice;

    private Integer promotionCount;

    private Integer promotionLimit;

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

    public Integer getPromotionCount() {
        return promotionCount;
    }

    public void setPromotionCount(Integer promotionCount) {
        this.promotionCount = promotionCount;
    }

    public Integer getPromotionLimit() {
        return promotionLimit;
    }

    public void setPromotionLimit(Integer promotionLimit) {
        this.promotionLimit = promotionLimit;
    }
}