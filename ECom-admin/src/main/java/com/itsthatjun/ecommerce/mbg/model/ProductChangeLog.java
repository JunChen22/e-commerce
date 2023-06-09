package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductChangeLog {
    private Integer id;

    private Integer productId;

    private BigDecimal priceOld;

    private BigDecimal priceNew;

    private BigDecimal unitOld;

    private BigDecimal unitNew;

    private String operateMan;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(BigDecimal priceOld) {
        this.priceOld = priceOld;
    }

    public BigDecimal getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(BigDecimal priceNew) {
        this.priceNew = priceNew;
    }

    public BigDecimal getUnitOld() {
        return unitOld;
    }

    public void setUnitOld(BigDecimal unitOld) {
        this.unitOld = unitOld;
    }

    public BigDecimal getUnitNew() {
        return unitNew;
    }

    public void setUnitNew(BigDecimal unitNew) {
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