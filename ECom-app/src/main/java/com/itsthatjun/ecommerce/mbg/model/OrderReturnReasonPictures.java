package com.itsthatjun.ecommerce.mbg.model;

import java.util.Date;

public class OrderReturnReasonPictures {
    private Integer id;

    private Integer orderReturnReasonId;

    private String filename;

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderReturnReasonId() {
        return orderReturnReasonId;
    }

    public void setOrderReturnReasonId(Integer orderReturnReasonId) {
        this.orderReturnReasonId = orderReturnReasonId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}