package com.example.spring.ecommerce.demo.springecommerce.mbg.model;

import java.math.BigDecimal;

public class Product {
    private Integer id;

    private BigDecimal brandId;

    private BigDecimal categoryId;

    private String name;

    private String picture;

    private String description;

    private BigDecimal price;

    private BigDecimal salePrice;

    private BigDecimal stock;

    private String descriptionAlbum;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getBrandId() {
        return brandId;
    }

    public void setBrandId(BigDecimal brandId) {
        this.brandId = brandId;
    }

    public BigDecimal getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(BigDecimal categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getDescriptionAlbum() {
        return descriptionAlbum;
    }

    public void setDescriptionAlbum(String descriptionAlbum) {
        this.descriptionAlbum = descriptionAlbum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}