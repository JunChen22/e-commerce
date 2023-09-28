package com.itsthatjun.ecommerce.mbg.model;

import java.util.Date;

public class ReturnLog {
    private Integer id;

    private Integer returnRequestId;

    private String action;

    private String operator;

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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}