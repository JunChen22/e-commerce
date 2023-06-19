package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductUpdateLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductUpdateLogExample() {
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

        public Criteria andPriceOldIsNull() {
            addCriterion("price_old is null");
            return (Criteria) this;
        }

        public Criteria andPriceOldIsNotNull() {
            addCriterion("price_old is not null");
            return (Criteria) this;
        }

        public Criteria andPriceOldEqualTo(BigDecimal value) {
            addCriterion("price_old =", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldNotEqualTo(BigDecimal value) {
            addCriterion("price_old <>", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldGreaterThan(BigDecimal value) {
            addCriterion("price_old >", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_old >=", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldLessThan(BigDecimal value) {
            addCriterion("price_old <", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_old <=", value, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldIn(List<BigDecimal> values) {
            addCriterion("price_old in", values, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldNotIn(List<BigDecimal> values) {
            addCriterion("price_old not in", values, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_old between", value1, value2, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceOldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_old not between", value1, value2, "priceOld");
            return (Criteria) this;
        }

        public Criteria andPriceNewIsNull() {
            addCriterion("price_new is null");
            return (Criteria) this;
        }

        public Criteria andPriceNewIsNotNull() {
            addCriterion("price_new is not null");
            return (Criteria) this;
        }

        public Criteria andPriceNewEqualTo(BigDecimal value) {
            addCriterion("price_new =", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewNotEqualTo(BigDecimal value) {
            addCriterion("price_new <>", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewGreaterThan(BigDecimal value) {
            addCriterion("price_new >", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_new >=", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewLessThan(BigDecimal value) {
            addCriterion("price_new <", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_new <=", value, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewIn(List<BigDecimal> values) {
            addCriterion("price_new in", values, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewNotIn(List<BigDecimal> values) {
            addCriterion("price_new not in", values, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_new between", value1, value2, "priceNew");
            return (Criteria) this;
        }

        public Criteria andPriceNewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_new not between", value1, value2, "priceNew");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldIsNull() {
            addCriterion("sale_price_old is null");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldIsNotNull() {
            addCriterion("sale_price_old is not null");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldEqualTo(BigDecimal value) {
            addCriterion("sale_price_old =", value, "salePriceOld");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldNotEqualTo(BigDecimal value) {
            addCriterion("sale_price_old <>", value, "salePriceOld");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldGreaterThan(BigDecimal value) {
            addCriterion("sale_price_old >", value, "salePriceOld");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price_old >=", value, "salePriceOld");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldLessThan(BigDecimal value) {
            addCriterion("sale_price_old <", value, "salePriceOld");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price_old <=", value, "salePriceOld");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldIn(List<BigDecimal> values) {
            addCriterion("sale_price_old in", values, "salePriceOld");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldNotIn(List<BigDecimal> values) {
            addCriterion("sale_price_old not in", values, "salePriceOld");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price_old between", value1, value2, "salePriceOld");
            return (Criteria) this;
        }

        public Criteria andSalePriceOldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price_old not between", value1, value2, "salePriceOld");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewIsNull() {
            addCriterion("sale_price_new is null");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewIsNotNull() {
            addCriterion("sale_price_new is not null");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewEqualTo(BigDecimal value) {
            addCriterion("sale_price_new =", value, "salePriceNew");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewNotEqualTo(BigDecimal value) {
            addCriterion("sale_price_new <>", value, "salePriceNew");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewGreaterThan(BigDecimal value) {
            addCriterion("sale_price_new >", value, "salePriceNew");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price_new >=", value, "salePriceNew");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewLessThan(BigDecimal value) {
            addCriterion("sale_price_new <", value, "salePriceNew");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sale_price_new <=", value, "salePriceNew");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewIn(List<BigDecimal> values) {
            addCriterion("sale_price_new in", values, "salePriceNew");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewNotIn(List<BigDecimal> values) {
            addCriterion("sale_price_new not in", values, "salePriceNew");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price_new between", value1, value2, "salePriceNew");
            return (Criteria) this;
        }

        public Criteria andSalePriceNewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sale_price_new not between", value1, value2, "salePriceNew");
            return (Criteria) this;
        }

        public Criteria andOperateManIsNull() {
            addCriterion("operate_man is null");
            return (Criteria) this;
        }

        public Criteria andOperateManIsNotNull() {
            addCriterion("operate_man is not null");
            return (Criteria) this;
        }

        public Criteria andOperateManEqualTo(String value) {
            addCriterion("operate_man =", value, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManNotEqualTo(String value) {
            addCriterion("operate_man <>", value, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManGreaterThan(String value) {
            addCriterion("operate_man >", value, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManGreaterThanOrEqualTo(String value) {
            addCriterion("operate_man >=", value, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManLessThan(String value) {
            addCriterion("operate_man <", value, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManLessThanOrEqualTo(String value) {
            addCriterion("operate_man <=", value, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManLike(String value) {
            addCriterion("operate_man like", value, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManNotLike(String value) {
            addCriterion("operate_man not like", value, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManIn(List<String> values) {
            addCriterion("operate_man in", values, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManNotIn(List<String> values) {
            addCriterion("operate_man not in", values, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManBetween(String value1, String value2) {
            addCriterion("operate_man between", value1, value2, "operateMan");
            return (Criteria) this;
        }

        public Criteria andOperateManNotBetween(String value1, String value2) {
            addCriterion("operate_man not between", value1, value2, "operateMan");
            return (Criteria) this;
        }

        public Criteria andStockOldIsNull() {
            addCriterion("stock_old is null");
            return (Criteria) this;
        }

        public Criteria andStockOldIsNotNull() {
            addCriterion("stock_old is not null");
            return (Criteria) this;
        }

        public Criteria andStockOldEqualTo(BigDecimal value) {
            addCriterion("stock_old =", value, "stockOld");
            return (Criteria) this;
        }

        public Criteria andStockOldNotEqualTo(BigDecimal value) {
            addCriterion("stock_old <>", value, "stockOld");
            return (Criteria) this;
        }

        public Criteria andStockOldGreaterThan(BigDecimal value) {
            addCriterion("stock_old >", value, "stockOld");
            return (Criteria) this;
        }

        public Criteria andStockOldGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_old >=", value, "stockOld");
            return (Criteria) this;
        }

        public Criteria andStockOldLessThan(BigDecimal value) {
            addCriterion("stock_old <", value, "stockOld");
            return (Criteria) this;
        }

        public Criteria andStockOldLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_old <=", value, "stockOld");
            return (Criteria) this;
        }

        public Criteria andStockOldIn(List<BigDecimal> values) {
            addCriterion("stock_old in", values, "stockOld");
            return (Criteria) this;
        }

        public Criteria andStockOldNotIn(List<BigDecimal> values) {
            addCriterion("stock_old not in", values, "stockOld");
            return (Criteria) this;
        }

        public Criteria andStockOldBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_old between", value1, value2, "stockOld");
            return (Criteria) this;
        }

        public Criteria andStockOldNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_old not between", value1, value2, "stockOld");
            return (Criteria) this;
        }

        public Criteria andStockNewIsNull() {
            addCriterion("stock_new is null");
            return (Criteria) this;
        }

        public Criteria andStockNewIsNotNull() {
            addCriterion("stock_new is not null");
            return (Criteria) this;
        }

        public Criteria andStockNewEqualTo(BigDecimal value) {
            addCriterion("stock_new =", value, "stockNew");
            return (Criteria) this;
        }

        public Criteria andStockNewNotEqualTo(BigDecimal value) {
            addCriterion("stock_new <>", value, "stockNew");
            return (Criteria) this;
        }

        public Criteria andStockNewGreaterThan(BigDecimal value) {
            addCriterion("stock_new >", value, "stockNew");
            return (Criteria) this;
        }

        public Criteria andStockNewGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_new >=", value, "stockNew");
            return (Criteria) this;
        }

        public Criteria andStockNewLessThan(BigDecimal value) {
            addCriterion("stock_new <", value, "stockNew");
            return (Criteria) this;
        }

        public Criteria andStockNewLessThanOrEqualTo(BigDecimal value) {
            addCriterion("stock_new <=", value, "stockNew");
            return (Criteria) this;
        }

        public Criteria andStockNewIn(List<BigDecimal> values) {
            addCriterion("stock_new in", values, "stockNew");
            return (Criteria) this;
        }

        public Criteria andStockNewNotIn(List<BigDecimal> values) {
            addCriterion("stock_new not in", values, "stockNew");
            return (Criteria) this;
        }

        public Criteria andStockNewBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_new between", value1, value2, "stockNew");
            return (Criteria) this;
        }

        public Criteria andStockNewNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("stock_new not between", value1, value2, "stockNew");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("created_at is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("created_at is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("created_at =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("created_at <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("created_at >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("created_at >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("created_at <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("created_at <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("created_at in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("created_at not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("created_at between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("created_at not between", value1, value2, "createdAt");
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