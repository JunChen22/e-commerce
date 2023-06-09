package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;

public class ProductAttributeCategory {
    private Integer id;

    private String name;

    private BigDecimal attributeAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAttributeAmount() {
        return attributeAmount;
    }

    public void setAttributeAmount(BigDecimal attributeAmount) {
        this.attributeAmount = attributeAmount;
    }
}