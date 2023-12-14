package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PromotionSaleProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PromotionSaleProductExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdIsNull() {
            addCriterion("promotion_sale_id is null");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdIsNotNull() {
            addCriterion("promotion_sale_id is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdEqualTo(Integer value) {
            addCriterion("promotion_sale_id =", value, "promotionSaleId");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdNotEqualTo(Integer value) {
            addCriterion("promotion_sale_id <>", value, "promotionSaleId");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdGreaterThan(Integer value) {
            addCriterion("promotion_sale_id >", value, "promotionSaleId");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_sale_id >=", value, "promotionSaleId");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdLessThan(Integer value) {
            addCriterion("promotion_sale_id <", value, "promotionSaleId");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_sale_id <=", value, "promotionSaleId");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdIn(List<Integer> values) {
            addCriterion("promotion_sale_id in", values, "promotionSaleId");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdNotIn(List<Integer> values) {
            addCriterion("promotion_sale_id not in", values, "promotionSaleId");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdBetween(Integer value1, Integer value2) {
            addCriterion("promotion_sale_id between", value1, value2, "promotionSaleId");
            return (Criteria) this;
        }

        public Criteria andPromotionSaleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_sale_id not between", value1, value2, "promotionSaleId");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeIsNull() {
            addCriterion("product_sku_code is null");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeIsNotNull() {
            addCriterion("product_sku_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeEqualTo(String value) {
            addCriterion("product_sku_code =", value, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeNotEqualTo(String value) {
            addCriterion("product_sku_code <>", value, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeGreaterThan(String value) {
            addCriterion("product_sku_code >", value, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_sku_code >=", value, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeLessThan(String value) {
            addCriterion("product_sku_code <", value, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeLessThanOrEqualTo(String value) {
            addCriterion("product_sku_code <=", value, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeLike(String value) {
            addCriterion("product_sku_code like", value, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeNotLike(String value) {
            addCriterion("product_sku_code not like", value, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeIn(List<String> values) {
            addCriterion("product_sku_code in", values, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeNotIn(List<String> values) {
            addCriterion("product_sku_code not in", values, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeBetween(String value1, String value2) {
            addCriterion("product_sku_code between", value1, value2, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andProductSkuCodeNotBetween(String value1, String value2) {
            addCriterion("product_sku_code not between", value1, value2, "productSkuCode");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceIsNull() {
            addCriterion("promotion_price is null");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceIsNotNull() {
            addCriterion("promotion_price is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceEqualTo(BigDecimal value) {
            addCriterion("promotion_price =", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceNotEqualTo(BigDecimal value) {
            addCriterion("promotion_price <>", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceGreaterThan(BigDecimal value) {
            addCriterion("promotion_price >", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_price >=", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceLessThan(BigDecimal value) {
            addCriterion("promotion_price <", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("promotion_price <=", value, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceIn(List<BigDecimal> values) {
            addCriterion("promotion_price in", values, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceNotIn(List<BigDecimal> values) {
            addCriterion("promotion_price not in", values, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_price between", value1, value2, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("promotion_price not between", value1, value2, "promotionPrice");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemIsNull() {
            addCriterion("promotion_limit_item is null");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemIsNotNull() {
            addCriterion("promotion_limit_item is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemEqualTo(Integer value) {
            addCriterion("promotion_limit_item =", value, "promotionLimitItem");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemNotEqualTo(Integer value) {
            addCriterion("promotion_limit_item <>", value, "promotionLimitItem");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemGreaterThan(Integer value) {
            addCriterion("promotion_limit_item >", value, "promotionLimitItem");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_limit_item >=", value, "promotionLimitItem");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemLessThan(Integer value) {
            addCriterion("promotion_limit_item <", value, "promotionLimitItem");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_limit_item <=", value, "promotionLimitItem");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemIn(List<Integer> values) {
            addCriterion("promotion_limit_item in", values, "promotionLimitItem");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemNotIn(List<Integer> values) {
            addCriterion("promotion_limit_item not in", values, "promotionLimitItem");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemBetween(Integer value1, Integer value2) {
            addCriterion("promotion_limit_item between", value1, value2, "promotionLimitItem");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitItemNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_limit_item not between", value1, value2, "promotionLimitItem");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserIsNull() {
            addCriterion("promotion_limit_per_user is null");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserIsNotNull() {
            addCriterion("promotion_limit_per_user is not null");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserEqualTo(Integer value) {
            addCriterion("promotion_limit_per_user =", value, "promotionLimitPerUser");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserNotEqualTo(Integer value) {
            addCriterion("promotion_limit_per_user <>", value, "promotionLimitPerUser");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserGreaterThan(Integer value) {
            addCriterion("promotion_limit_per_user >", value, "promotionLimitPerUser");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("promotion_limit_per_user >=", value, "promotionLimitPerUser");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserLessThan(Integer value) {
            addCriterion("promotion_limit_per_user <", value, "promotionLimitPerUser");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserLessThanOrEqualTo(Integer value) {
            addCriterion("promotion_limit_per_user <=", value, "promotionLimitPerUser");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserIn(List<Integer> values) {
            addCriterion("promotion_limit_per_user in", values, "promotionLimitPerUser");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserNotIn(List<Integer> values) {
            addCriterion("promotion_limit_per_user not in", values, "promotionLimitPerUser");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserBetween(Integer value1, Integer value2) {
            addCriterion("promotion_limit_per_user between", value1, value2, "promotionLimitPerUser");
            return (Criteria) this;
        }

        public Criteria andPromotionLimitPerUserNotBetween(Integer value1, Integer value2) {
            addCriterion("promotion_limit_per_user not between", value1, value2, "promotionLimitPerUser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}