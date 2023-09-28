package com.itsthatjun.ecommerce.mbg.model;

import java.util.Date;

public class ReturnReasonPictures {
    private Integer id;

    private Integer returnRequestId;

    private String filename;

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReturnRequestId() {
        return returnRequestId;
    }

    public void setReturnRequestId(Integer returnRequestId) {
        this.returnRequestId = returnRequestId;
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