package com.example.spring.ecommerce.demo.springecommerce.mbg.model;

import java.util.Date;

public class ProductChangeLog {
    private String id;

    private String productId;

    private String priceOld;

    private String priceNew;

    private String unitOld;

    private String unitNew;

    private String operateMan;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(String priceOld) {
        this.priceOld = priceOld;
    }

    public String getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(String priceNew) {
        this.priceNew = priceNew;
    }

    public String getUnitOld() {
        return unitOld;
    }

    public void setUnitOld(String unitOld) {
        this.unitOld = unitOld;
    }

    public String getUnitNew() {
        return unitNew;
    }

    public void setUnitNew(String unitNew) {
        this.unitNew = unitNew;
    }

    public String getOperateMan() {
        return operateMan;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}