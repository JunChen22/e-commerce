package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;

public class ProductCategory {
    private Integer id;

    private String name;

    private BigDecimal productCount;

    private String icon;

    private BigDecimal parentId;

    private BigDecimal level;

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

    public BigDecimal getProductCount() {
        return productCount;
    }

    public void setProductCount(BigDecimal productCount) {
        this.productCount = productCount;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public BigDecimal getParentId() {
        return parentId;
    }

    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
    }

    public BigDecimal getLevel() {
        return level;
    }

    public void setLevel(BigDecimal level) {
        this.level = level;
    }
}