package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;

public class ProductAttribute {
    private Integer id;

    private Integer productId;

    private BigDecimal attributeTypeId;

    private String attributeValue;

    private String attributeUnit;

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

    public BigDecimal getAttributeTypeId() {
        return attributeTypeId;
    }

    public void setAttributeTypeId(BigDecimal attributeTypeId) {
        this.attributeTypeId = attributeTypeId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getAttributeUnit() {
        return attributeUnit;
    }

    public void setAttributeUnit(String attributeUnit) {
        this.attributeUnit = attributeUnit;
    }
}