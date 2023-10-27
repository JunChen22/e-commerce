package com.itsthatjun.ecommerce.mbg.model;

import java.io.Serializable;
import java.util.Date;

public class ReturnLog implements Serializable {
    private Integer id;

    private Integer returnRequestId;

    private String updateAction;

    private String operator;

    private Date createdAt;

    private static final long serialVersionUID = 1L;

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

    public String getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(String updateAction) {
        this.updateAction = updateAction;
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