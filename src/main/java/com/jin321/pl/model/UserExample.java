package com.jin321.pl.model;

import java.util.ArrayList;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUserwxidIsNull() {
            addCriterion("userWXid is null");
            return (Criteria) this;
        }

        public Criteria andUserwxidIsNotNull() {
            addCriterion("userWXid is not null");
            return (Criteria) this;
        }

        public Criteria andUserwxidEqualTo(String value) {
            addCriterion("userWXid =", value, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidNotEqualTo(String value) {
            addCriterion("userWXid <>", value, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidGreaterThan(String value) {
            addCriterion("userWXid >", value, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidGreaterThanOrEqualTo(String value) {
            addCriterion("userWXid >=", value, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidLessThan(String value) {
            addCriterion("userWXid <", value, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidLessThanOrEqualTo(String value) {
            addCriterion("userWXid <=", value, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidLike(String value) {
            addCriterion("userWXid like", value, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidNotLike(String value) {
            addCriterion("userWXid not like", value, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidIn(List<String> values) {
            addCriterion("userWXid in", values, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidNotIn(List<String> values) {
            addCriterion("userWXid not in", values, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidBetween(String value1, String value2) {
            addCriterion("userWXid between", value1, value2, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUserwxidNotBetween(String value1, String value2) {
            addCriterion("userWXid not between", value1, value2, "userwxid");
            return (Criteria) this;
        }

        public Criteria andUcommitionIsNull() {
            addCriterion("ucommition is null");
            return (Criteria) this;
        }

        public Criteria andUcommitionIsNotNull() {
            addCriterion("ucommition is not null");
            return (Criteria) this;
        }

        public Criteria andUcommitionEqualTo(Float value) {
            addCriterion("ucommition =", value, "ucommition");
            return (Criteria) this;
        }

        public Criteria andUcommitionNotEqualTo(Float value) {
            addCriterion("ucommition <>", value, "ucommition");
            return (Criteria) this;
        }

        public Criteria andUcommitionGreaterThan(Float value) {
            addCriterion("ucommition >", value, "ucommition");
            return (Criteria) this;
        }

        public Criteria andUcommitionGreaterThanOrEqualTo(Float value) {
            addCriterion("ucommition >=", value, "ucommition");
            return (Criteria) this;
        }

        public Criteria andUcommitionLessThan(Float value) {
            addCriterion("ucommition <", value, "ucommition");
            return (Criteria) this;
        }

        public Criteria andUcommitionLessThanOrEqualTo(Float value) {
            addCriterion("ucommition <=", value, "ucommition");
            return (Criteria) this;
        }

        public Criteria andUcommitionIn(List<Float> values) {
            addCriterion("ucommition in", values, "ucommition");
            return (Criteria) this;
        }

        public Criteria andUcommitionNotIn(List<Float> values) {
            addCriterion("ucommition not in", values, "ucommition");
            return (Criteria) this;
        }

        public Criteria andUcommitionBetween(Float value1, Float value2) {
            addCriterion("ucommition between", value1, value2, "ucommition");
            return (Criteria) this;
        }

        public Criteria andUcommitionNotBetween(Float value1, Float value2) {
            addCriterion("ucommition not between", value1, value2, "ucommition");
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