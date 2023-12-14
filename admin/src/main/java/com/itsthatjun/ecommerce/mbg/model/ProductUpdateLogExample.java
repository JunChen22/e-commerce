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

        public Criteria andOldStockIsNull() {
            addCriterion("old_stock is null");
            return (Criteria) this;
        }

        public Criteria andOldStockIsNotNull() {
            addCriterion("old_stock is not null");
            return (Criteria) this;
        }

        public Criteria andOldStockEqualTo(Integer value) {
            addCriterion("old_stock =", value, "oldStock");
            return (Criteria) this;
        }

        public Criteria andOldStockNotEqualTo(Integer value) {
            addCriterion("old_stock <>", value, "oldStock");
            return (Criteria) this;
        }

        public Criteria andOldStockGreaterThan(Integer value) {
            addCriterion("old_stock >", value, "oldStock");
            return (Criteria) this;
        }

        public Criteria andOldStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("old_stock >=", value, "oldStock");
            return (Criteria) this;
        }

        public Criteria andOldStockLessThan(Integer value) {
            addCriterion("old_stock <", value, "oldStock");
            return (Criteria) this;
        }

        public Criteria andOldStockLessThanOrEqualTo(Integer value) {
            addCriterion("old_stock <=", value, "oldStock");
            return (Criteria) this;
        }

        public Criteria andOldStockIn(List<Integer> values) {
            addCriterion("old_stock in", values, "oldStock");
            return (Criteria) this;
        }

        public Criteria andOldStockNotIn(List<Integer> values) {
            addCriterion("old_stock not in", values, "oldStock");
            return (Criteria) this;
        }

        public Criteria andOldStockBetween(Integer value1, Integer value2) {
            addCriterion("old_stock between", value1, value2, "oldStock");
            return (Criteria) this;
        }

        public Criteria andOldStockNotBetween(Integer value1, Integer value2) {
            addCriterion("old_stock not between", value1, value2, "oldStock");
            return (Criteria) this;
        }

        public Criteria andAddedStockIsNull() {
            addCriterion("added_stock is null");
            return (Criteria) this;
        }

        public Criteria andAddedStockIsNotNull() {
            addCriterion("added_stock is not null");
            return (Criteria) this;
        }

        public Criteria andAddedStockEqualTo(Integer value) {
            addCriterion("added_stock =", value, "addedStock");
            return (Criteria) this;
        }

        public Criteria andAddedStockNotEqualTo(Integer value) {
            addCriterion("added_stock <>", value, "addedStock");
            return (Criteria) this;
        }

        public Criteria andAddedStockGreaterThan(Integer value) {
            addCriterion("added_stock >", value, "addedStock");
            return (Criteria) this;
        }

        public Criteria andAddedStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("added_stock >=", value, "addedStock");
            return (Criteria) this;
        }

        public Criteria andAddedStockLessThan(Integer value) {
            addCriterion("added_stock <", value, "addedStock");
            return (Criteria) this;
        }

        public Criteria andAddedStockLessThanOrEqualTo(Integer value) {
            addCriterion("added_stock <=", value, "addedStock");
            return (Criteria) this;
        }

        public Criteria andAddedStockIn(List<Integer> values) {
            addCriterion("added_stock in", values, "addedStock");
            return (Criteria) this;
        }

        public Criteria andAddedStockNotIn(List<Integer> values) {
            addCriterion("added_stock not in", values, "addedStock");
            return (Criteria) this;
        }

        public Criteria andAddedStockBetween(Integer value1, Integer value2) {
            addCriterion("added_stock between", value1, value2, "addedStock");
            return (Criteria) this;
        }

        public Criteria andAddedStockNotBetween(Integer value1, Integer value2) {
            addCriterion("added_stock not between", value1, value2, "addedStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockIsNull() {
            addCriterion("total_stock is null");
            return (Criteria) this;
        }

        public Criteria andTotalStockIsNotNull() {
            addCriterion("total_stock is not null");
            return (Criteria) this;
        }

        public Criteria andTotalStockEqualTo(Integer value) {
            addCriterion("total_stock =", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockNotEqualTo(Integer value) {
            addCriterion("total_stock <>", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockGreaterThan(Integer value) {
            addCriterion("total_stock >", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_stock >=", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockLessThan(Integer value) {
            addCriterion("total_stock <", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockLessThanOrEqualTo(Integer value) {
            addCriterion("total_stock <=", value, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockIn(List<Integer> values) {
            addCriterion("total_stock in", values, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockNotIn(List<Integer> values) {
            addCriterion("total_stock not in", values, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockBetween(Integer value1, Integer value2) {
            addCriterion("total_stock between", value1, value2, "totalStock");
            return (Criteria) this;
        }

        public Criteria andTotalStockNotBetween(Integer value1, Integer value2) {
            addCriterion("total_stock not between", value1, value2, "totalStock");
            return (Criteria) this;
        }

        public Criteria andUpdateActionIsNull() {
            addCriterion("update_action is null");
            return (Criteria) this;
        }

        public Criteria andUpdateActionIsNotNull() {
            addCriterion("update_action is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateActionEqualTo(String value) {
            addCriterion("update_action =", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionNotEqualTo(String value) {
            addCriterion("update_action <>", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionGreaterThan(String value) {
            addCriterion("update_action >", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionGreaterThanOrEqualTo(String value) {
            addCriterion("update_action >=", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionLessThan(String value) {
            addCriterion("update_action <", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionLessThanOrEqualTo(String value) {
            addCriterion("update_action <=", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionLike(String value) {
            addCriterion("update_action like", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionNotLike(String value) {
            addCriterion("update_action not like", value, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionIn(List<String> values) {
            addCriterion("update_action in", values, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionNotIn(List<String> values) {
            addCriterion("update_action not in", values, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionBetween(String value1, String value2) {
            addCriterion("update_action between", value1, value2, "updateAction");
            return (Criteria) this;
        }

        public Criteria andUpdateActionNotBetween(String value1, String value2) {
            addCriterion("update_action not between", value1, value2, "updateAction");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
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