package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;
import java.util.Date;

public class Comment {
    private Integer id;

    private BigDecimal productId;

    private String memberName;

    private String memberIcon;

    private BigDecimal star;

    private Date createTime;

    private String tittle;

    private BigDecimal likes;

    private String content;

    private String pictures;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getProductId() {
        return productId;
    }

    public void setProductId(BigDecimal productId) {
        this.productId = productId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberIcon() {
        return memberIcon;
    }

    public void setMemberIcon(String memberIcon) {
        this.memberIcon = memberIcon;
    }

    public BigDecimal getStar() {
        return star;
    }

    public void setStar(BigDecimal star) {
        this.star = star;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public BigDecimal getLikes() {
        return likes;
    }

    public void setLikes(BigDecimal likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }
}