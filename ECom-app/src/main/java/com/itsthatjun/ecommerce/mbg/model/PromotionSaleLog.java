package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;
import java.util.Date;

public class PromotionSaleLog {
    private Integer id;

    private Integer promotionSaleId;

    private String saleAction;

    private Integer promotionType;

    private Integer discountType;

    private BigDecimal amount;

    private String operateMan;

    private Date createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPromotionSaleId() {
        return promotionSaleId;
    }

    public void setPromotionSaleId(Integer promotionSaleId) {
        this.promotionSaleId = promotionSaleId;
    }

    public String getSaleAction() {
        return saleAction;
    }

    public void setSaleAction(String saleAction) {
        this.saleAction = saleAction;
    }

    public Integer getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(Integer promotionType) {
        this.promotionType = promotionType;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOperateMan() {
        return operateMan;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}