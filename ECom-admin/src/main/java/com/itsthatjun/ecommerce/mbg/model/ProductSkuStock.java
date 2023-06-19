package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;

public class ProductSkuStock {
    private Integer id;

    private Integer productId;

    private String skuCode;

    private String picture;

    private BigDecimal price;

    private BigDecimal promotionPrice;

    private BigDecimal stock;

    private BigDecimal lowStock;

    private BigDecimal lockStock;

    private BigDecimal unitSold;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getLowStock() {
        return lowStock;
    }

    public void setLowStock(BigDecimal lowStock) {
        this.lowStock = lowStock;
    }

    public BigDecimal getLockStock() {
        return lockStock;
    }

    public void setLockStock(BigDecimal lockStock) {
        this.lockStock = lockStock;
    }

    public BigDecimal getUnitSold() {
        return unitSold;
    }

    public void setUnitSold(BigDecimal unitSold) {
        this.unitSold = unitSold;
    }
}