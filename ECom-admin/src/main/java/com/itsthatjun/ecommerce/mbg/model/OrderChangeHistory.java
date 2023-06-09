package com.itsthatjun.ecommerce.mbg.model;

import java.util.Date;

public class OrderChangeHistory {
    private Integer id;

    private Integer orderId;

    private String changeOperator;

    private Date createTime;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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