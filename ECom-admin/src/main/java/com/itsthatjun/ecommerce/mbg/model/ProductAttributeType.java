package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;

public class ProductAttributeType {
    private Integer id;

    private BigDecimal attributeCategoryId;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getAttributeCategoryId() {
        return attributeCategoryId;
    }

    public void setAttributeCategoryId(BigDecimal attributeCategoryId) {
        this.attributeCategoryId = attributeCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}