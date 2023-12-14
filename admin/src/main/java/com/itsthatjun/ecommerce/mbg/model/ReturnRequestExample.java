package com.itsthatjun.ecommerce.mbg.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReturnRequestExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReturnRequestExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdIsNull() {
            addCriterion("company_address_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdIsNotNull() {
            addCriterion("company_address_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdEqualTo(Integer value) {
            addCriterion("company_address_id =", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdNotEqualTo(Integer value) {
            addCriterion("company_address_id <>", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdGreaterThan(Integer value) {
            addCriterion("company_address_id >", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_address_id >=", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdLessThan(Integer value) {
            addCriterion("company_address_id <", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_address_id <=", value, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdIn(List<Integer> values) {
            addCriterion("company_address_id in", values, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdNotIn(List<Integer> values) {
            addCriterion("company_address_id not in", values, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("company_address_id between", value1, value2, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_address_id not between", value1, value2, "companyAddressId");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNull() {
            addCriterion("order_sn is null");
            return (Criteria) this;
        }

        public Criteria andOrderSnIsNotNull() {
            addCriterion("order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSnEqualTo(String value) {
            addCriterion("order_sn =", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotEqualTo(String value) {
            addCriterion("order_sn <>", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThan(String value) {
            addCriterion("order_sn >", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("order_sn >=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThan(String value) {
            addCriterion("order_sn <", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLessThanOrEqualTo(String value) {
            addCriterion("order_sn <=", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnLike(String value) {
            addCriterion("order_sn like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotLike(String value) {
            addCriterion("order_sn not like", value, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnIn(List<String> values) {
            addCriterion("order_sn in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotIn(List<String> values) {
            addCriterion("order_sn not in", values, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnBetween(String value1, String value2) {
            addCriterion("order_sn between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andOrderSnNotBetween(String value1, String value2) {
            addCriterion("order_sn not between", value1, value2, "orderSn");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Integer value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Integer value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Integer value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Integer value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Integer value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Integer> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Integer> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Integer value1, Integer value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Integer value1, Integer value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityIsNull() {
            addCriterion("return_quantity is null");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityIsNotNull() {
            addCriterion("return_quantity is not null");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityEqualTo(Integer value) {
            addCriterion("return_quantity =", value, "returnQuantity");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityNotEqualTo(Integer value) {
            addCriterion("return_quantity <>", value, "returnQuantity");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityGreaterThan(Integer value) {
            addCriterion("return_quantity >", value, "returnQuantity");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("return_quantity >=", value, "returnQuantity");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityLessThan(Integer value) {
            addCriterion("return_quantity <", value, "returnQuantity");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("return_quantity <=", value, "returnQuantity");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityIn(List<Integer> values) {
            addCriterion("return_quantity in", values, "returnQuantity");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityNotIn(List<Integer> values) {
            addCriterion("return_quantity not in", values, "returnQuantity");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityBetween(Integer value1, Integer value2) {
            addCriterion("return_quantity between", value1, value2, "returnQuantity");
            return (Criteria) this;
        }

        public Criteria andReturnQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("return_quantity not between", value1, value2, "returnQuantity");
            return (Criteria) this;
        }

        public Criteria andReturnNameIsNull() {
            addCriterion("return_name is null");
            return (Criteria) this;
        }

        public Criteria andReturnNameIsNotNull() {
            addCriterion("return_name is not null");
            return (Criteria) this;
        }

        public Criteria andReturnNameEqualTo(String value) {
            addCriterion("return_name =", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameNotEqualTo(String value) {
            addCriterion("return_name <>", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameGreaterThan(String value) {
            addCriterion("return_name >", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameGreaterThanOrEqualTo(String value) {
            addCriterion("return_name >=", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameLessThan(String value) {
            addCriterion("return_name <", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameLessThanOrEqualTo(String value) {
            addCriterion("return_name <=", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameLike(String value) {
            addCriterion("return_name like", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameNotLike(String value) {
            addCriterion("return_name not like", value, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameIn(List<String> values) {
            addCriterion("return_name in", values, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameNotIn(List<String> values) {
            addCriterion("return_name not in", values, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameBetween(String value1, String value2) {
            addCriterion("return_name between", value1, value2, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnNameNotBetween(String value1, String value2) {
            addCriterion("return_name not between", value1, value2, "returnName");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneIsNull() {
            addCriterion("return_phone is null");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneIsNotNull() {
            addCriterion("return_phone is not null");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneEqualTo(String value) {
            addCriterion("return_phone =", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneNotEqualTo(String value) {
            addCriterion("return_phone <>", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneGreaterThan(String value) {
            addCriterion("return_phone >", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("return_phone >=", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneLessThan(String value) {
            addCriterion("return_phone <", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneLessThanOrEqualTo(String value) {
            addCriterion("return_phone <=", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneLike(String value) {
            addCriterion("return_phone like", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneNotLike(String value) {
            addCriterion("return_phone not like", value, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneIn(List<String> values) {
            addCriterion("return_phone in", values, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneNotIn(List<String> values) {
            addCriterion("return_phone not in", values, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneBetween(String value1, String value2) {
            addCriterion("return_phone between", value1, value2, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andReturnPhoneNotBetween(String value1, String value2) {
            addCriterion("return_phone not between", value1, value2, "returnPhone");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNull() {
            addCriterion("handle_time is null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNotNull() {
            addCriterion("handle_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeEqualTo(Date value) {
            addCriterion("handle_time =", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotEqualTo(Date value) {
            addCriterion("handle_time <>", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThan(Date value) {
            addCriterion("handle_time >", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("handle_time >=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThan(Date value) {
            addCriterion("handle_time <", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("handle_time <=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIn(List<Date> values) {
            addCriterion("handle_time in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotIn(List<Date> values) {
            addCriterion("handle_time not in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeBetween(Date value1, Date value2) {
            addCriterion("handle_time between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("handle_time not between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andAskingAmountIsNull() {
            addCriterion("asking_amount is null");
            return (Criteria) this;
        }

        public Criteria andAskingAmountIsNotNull() {
            addCriterion("asking_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAskingAmountEqualTo(BigDecimal value) {
            addCriterion("asking_amount =", value, "askingAmount");
            return (Criteria) this;
        }

        public Criteria andAskingAmountNotEqualTo(BigDecimal value) {
            addCriterion("asking_amount <>", value, "askingAmount");
            return (Criteria) this;
        }

        public Criteria andAskingAmountGreaterThan(BigDecimal value) {
            addCriterion("asking_amount >", value, "askingAmount");
            return (Criteria) this;
        }

        public Criteria andAskingAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("asking_amount >=", value, "askingAmount");
            return (Criteria) this;
        }

        public Criteria andAskingAmountLessThan(BigDecimal value) {
            addCriterion("asking_amount <", value, "askingAmount");
            return (Criteria) this;
        }

        public Criteria andAskingAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("asking_amount <=", value, "askingAmount");
            return (Criteria) this;
        }

        public Criteria andAskingAmountIn(List<BigDecimal> values) {
            addCriterion("asking_amount in", values, "askingAmount");
            return (Criteria) this;
        }

        public Criteria andAskingAmountNotIn(List<BigDecimal> values) {
            addCriterion("asking_amount not in", values, "askingAmount");
            return (Criteria) this;
        }

        public Criteria andAskingAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("asking_amount between", value1, value2, "askingAmount");
            return (Criteria) this;
        }

        public Criteria andAskingAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("asking_amount not between", value1, value2, "askingAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountIsNull() {
            addCriterion("refunded_amount is null");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountIsNotNull() {
            addCriterion("refunded_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountEqualTo(BigDecimal value) {
            addCriterion("refunded_amount =", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountNotEqualTo(BigDecimal value) {
            addCriterion("refunded_amount <>", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountGreaterThan(BigDecimal value) {
            addCriterion("refunded_amount >", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("refunded_amount >=", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountLessThan(BigDecimal value) {
            addCriterion("refunded_amount <", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("refunded_amount <=", value, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountIn(List<BigDecimal> values) {
            addCriterion("refunded_amount in", values, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountNotIn(List<BigDecimal> values) {
            addCriterion("refunded_amount not in", values, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refunded_amount between", value1, value2, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andRefundedAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("refunded_amount not between", value1, value2, "refundedAmount");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andHandleNoteIsNull() {
            addCriterion("handle_note is null");
            return (Criteria) this;
        }

        public Criteria andHandleNoteIsNotNull() {
            addCriterion("handle_note is not null");
            return (Criteria) this;
        }

        public Criteria andHandleNoteEqualTo(String value) {
            addCriterion("handle_note =", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteNotEqualTo(String value) {
            addCriterion("handle_note <>", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteGreaterThan(String value) {
            addCriterion("handle_note >", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteGreaterThanOrEqualTo(String value) {
            addCriterion("handle_note >=", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteLessThan(String value) {
            addCriterion("handle_note <", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteLessThanOrEqualTo(String value) {
            addCriterion("handle_note <=", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteLike(String value) {
            addCriterion("handle_note like", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteNotLike(String value) {
            addCriterion("handle_note not like", value, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteIn(List<String> values) {
            addCriterion("handle_note in", values, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteNotIn(List<String> values) {
            addCriterion("handle_note not in", values, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteBetween(String value1, String value2) {
            addCriterion("handle_note between", value1, value2, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleNoteNotBetween(String value1, String value2) {
            addCriterion("handle_note not between", value1, value2, "handleNote");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorIsNull() {
            addCriterion("handle_operator is null");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorIsNotNull() {
            addCriterion("handle_operator is not null");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorEqualTo(String value) {
            addCriterion("handle_operator =", value, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorNotEqualTo(String value) {
            addCriterion("handle_operator <>", value, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorGreaterThan(String value) {
            addCriterion("handle_operator >", value, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("handle_operator >=", value, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorLessThan(String value) {
            addCriterion("handle_operator <", value, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorLessThanOrEqualTo(String value) {
            addCriterion("handle_operator <=", value, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorLike(String value) {
            addCriterion("handle_operator like", value, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorNotLike(String value) {
            addCriterion("handle_operator not like", value, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorIn(List<String> values) {
            addCriterion("handle_operator in", values, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorNotIn(List<String> values) {
            addCriterion("handle_operator not in", values, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorBetween(String value1, String value2) {
            addCriterion("handle_operator between", value1, value2, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andHandleOperatorNotBetween(String value1, String value2) {
            addCriterion("handle_operator not between", value1, value2, "handleOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorIsNull() {
            addCriterion("receive_operator is null");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorIsNotNull() {
            addCriterion("receive_operator is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorEqualTo(String value) {
            addCriterion("receive_operator =", value, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorNotEqualTo(String value) {
            addCriterion("receive_operator <>", value, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorGreaterThan(String value) {
            addCriterion("receive_operator >", value, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("receive_operator >=", value, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorLessThan(String value) {
            addCriterion("receive_operator <", value, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorLessThanOrEqualTo(String value) {
            addCriterion("receive_operator <=", value, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorLike(String value) {
            addCriterion("receive_operator like", value, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorNotLike(String value) {
            addCriterion("receive_operator not like", value, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorIn(List<String> values) {
            addCriterion("receive_operator in", values, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorNotIn(List<String> values) {
            addCriterion("receive_operator not in", values, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorBetween(String value1, String value2) {
            addCriterion("receive_operator between", value1, value2, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveOperatorNotBetween(String value1, String value2) {
            addCriterion("receive_operator not between", value1, value2, "receiveOperator");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNull() {
            addCriterion("receive_time is null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIsNotNull() {
            addCriterion("receive_time is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeEqualTo(Date value) {
            addCriterion("receive_time =", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotEqualTo(Date value) {
            addCriterion("receive_time <>", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThan(Date value) {
            addCriterion("receive_time >", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_time >=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThan(Date value) {
            addCriterion("receive_time <", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeLessThanOrEqualTo(Date value) {
            addCriterion("receive_time <=", value, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeIn(List<Date> values) {
            addCriterion("receive_time in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotIn(List<Date> values) {
            addCriterion("receive_time not in", values, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeBetween(Date value1, Date value2) {
            addCriterion("receive_time between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveTimeNotBetween(Date value1, Date value2) {
            addCriterion("receive_time not between", value1, value2, "receiveTime");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteIsNull() {
            addCriterion("receive_note is null");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteIsNotNull() {
            addCriterion("receive_note is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteEqualTo(String value) {
            addCriterion("receive_note =", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteNotEqualTo(String value) {
            addCriterion("receive_note <>", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteGreaterThan(String value) {
            addCriterion("receive_note >", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteGreaterThanOrEqualTo(String value) {
            addCriterion("receive_note >=", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteLessThan(String value) {
            addCriterion("receive_note <", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteLessThanOrEqualTo(String value) {
            addCriterion("receive_note <=", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteLike(String value) {
            addCriterion("receive_note like", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteNotLike(String value) {
            addCriterion("receive_note not like", value, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteIn(List<String> values) {
            addCriterion("receive_note in", values, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteNotIn(List<String> values) {
            addCriterion("receive_note not in", values, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteBetween(String value1, String value2) {
            addCriterion("receive_note between", value1, value2, "receiveNote");
            return (Criteria) this;
        }

        public Criteria andReceiveNoteNotBetween(String value1, String value2) {
            addCriterion("receive_note not between", value1, value2, "receiveNote");
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

        public Criteria andUpdatedAtIsNull() {
            addCriterion("updated_at is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("updated_at is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("updated_at =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("updated_at <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("updated_at >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_at >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("updated_at <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("updated_at <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("updated_at in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("updated_at not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("updated_at between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("updated_at not between", value1, value2, "updatedAt");
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