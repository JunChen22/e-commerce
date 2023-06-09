package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer id;

    private Integer brandId;

    private String brandName;

    private String name;

    private Integer categoryId;

    private String categoryName;

    private Integer attributeCategoryId;

    private BigDecimal sn;

    private BigDecimal deleteStatus;

    private BigDecimal publishStatus;

    private BigDecimal newStatus;

    private BigDecimal recommendStatus;

    private BigDecimal verifyStatus;

    private String subTitle;

    private String picture;

    private String description;

    private BigDecimal originalPrice;

    private BigDecimal onSaleStatus;

    private BigDecimal salePrice;

    private BigDecimal stock;

    private BigDecimal lowStock;

    private String unit;

    private BigDecimal weight;

    private Date promotionStartTime;

    private Date promotionEndTime;

    private BigDecimal promotionPerLimit;

    private BigDecimal promotionType;

    private String keywords;

    private String descriptionAlbum;

    private String albumPics;

    private String detailTitle;

    private String detailDesc;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getAttributeCategoryId() {
        return attributeCategoryId;
    }

    public void setAttributeCategoryId(Integer attributeCategoryId) {
        this.attributeCategoryId = attributeCategoryId;
    }

    public BigDecimal getSn() {
        return sn;
    }

    public void setSn(BigDecimal sn) {
        this.sn = sn;
    }

    public BigDecimal getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(BigDecimal deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public BigDecimal getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(BigDecimal publishStatus) {
        this.publishStatus = publishStatus;
    }

    public BigDecimal getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(BigDecimal newStatus) {
        this.newStatus = newStatus;
    }

    public BigDecimal getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(BigDecimal recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public BigDecimal getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(BigDecimal verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
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

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getOnSaleStatus() {
        return onSaleStatus;
    }

    public void setOnSaleStatus(BigDecimal onSaleStatus) {
        this.onSaleStatus = onSaleStatus;
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

    public BigDecimal getLowStock() {
        return lowStock;
    }

    public void setLowStock(BigDecimal lowStock) {
        this.lowStock = lowStock;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Date getPromotionStartTime() {
        return promotionStartTime;
    }

    public void setPromotionStartTime(Date promotionStartTime) {
        this.promotionStartTime = promotionStartTime;
    }

    public Date getPromotionEndTime() {
        return promotionEndTime;
    }

    public void setPromotionEndTime(Date promotionEndTime) {
        this.promotionEndTime = promotionEndTime;
    }

    public BigDecimal getPromotionPerLimit() {
        return promotionPerLimit;
    }

    public void setPromotionPerLimit(BigDecimal promotionPerLimit) {
        this.promotionPerLimit = promotionPerLimit;
    }

    public BigDecimal getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(BigDecimal promotionType) {
        this.promotionType = promotionType;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescriptionAlbum() {
        return descriptionAlbum;
    }

    public void setDescriptionAlbum(String descriptionAlbum) {
        this.descriptionAlbum = descriptionAlbum;
    }

    public String getAlbumPics() {
        return albumPics;
    }

    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
    }

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}