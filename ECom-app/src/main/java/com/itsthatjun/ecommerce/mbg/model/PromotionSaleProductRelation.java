package com.itsthatjun.ecommerce.mbg.model;

public class PromotionSaleProductRelation {
    private Integer id;

    private Integer promotionSaleId;

    private Integer productId;

    private String productSkuCode;

    private Long promotionPrice;

    private Long promotionCount;

    private Long promotionLimit;

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

    public Long getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Long promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Long getPromotionCount() {
        return promotionCount;
    }

    public void setPromotionCount(Long promotionCount) {
        this.promotionCount = promotionCount;
    }

    public Long getPromotionLimit() {
        return promotionLimit;
    }

    public void setPromotionLimit(Long promotionLimit) {
        this.promotionLimit = promotionLimit;
    }
}