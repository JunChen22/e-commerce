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

    private String sn;

    private BigDecimal newStatus;

    private BigDecimal recommendStatus;

    private BigDecimal verifyStatus;

    private String subTitle;

    private String coverPicture;

    private BigDecimal pictureAlbum;

    private String description;

    private BigDecimal originalPrice;

    private Integer onSaleStatus;

    private BigDecimal salePrice;

    private Integer stock;

    private Integer lowStock;

    private Integer unitSold;

    private BigDecimal weight;

    private String keywords;

    private String detailTitle;

    private String detailDesc;

    private BigDecimal descriptionAlbum;

    private Integer deleteStatus;

    private Integer publishStatus;

    private Date createdAt;

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

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

    public String getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(String coverPicture) {
        this.coverPicture = coverPicture;
    }

    public BigDecimal getPictureAlbum() {
        return pictureAlbum;
    }

    public void setPictureAlbum(BigDecimal pictureAlbum) {
        this.pictureAlbum = pictureAlbum;
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

    public Integer getOnSaleStatus() {
        return onSaleStatus;
    }

    public void setOnSaleStatus(Integer onSaleStatus) {
        this.onSaleStatus = onSaleStatus;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getLowStock() {
        return lowStock;
    }

    public void setLowStock(Integer lowStock) {
        this.lowStock = lowStock;
    }

    public Integer getUnitSold() {
        return unitSold;
    }

    public void setUnitSold(Integer unitSold) {
        this.unitSold = unitSold;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
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

    public BigDecimal getDescriptionAlbum() {
        return descriptionAlbum;
    }

    public void setDescriptionAlbum(BigDecimal descriptionAlbum) {
        this.descriptionAlbum = descriptionAlbum;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}