package com.itsthatjun.ecommerce.mbg.model;

import java.util.Date;

public class OrderChangeHistory {
    private Integer id;

    private Integer orderId;

    private String changeOperator;

    private Date createdAt;

    private Integer orderStatus;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getChangeOperator() {
        return changeOperator;
    }

    public void setChangeOperator(String changeOperator) {
        this.changeOperator = changeOperator;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}