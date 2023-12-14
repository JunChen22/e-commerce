package com.itsthatjun.ecommerce.mbg.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductAttributeType implements Serializable {
    private Integer id;

    private BigDecimal attributeCategoryId;

    private String name;

    private static final long serialVersionUID = 1L;

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