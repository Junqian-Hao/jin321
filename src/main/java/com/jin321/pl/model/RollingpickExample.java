package com.jin321.pl.model;

import java.util.ArrayList;
import java.util.List;

public class RollingpickExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RollingpickExample() {
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

        public Criteria andRpidIsNull() {
            addCriterion("rpid is null");
            return (Criteria) this;
        }

        public Criteria andRpidIsNotNull() {
            addCriterion("rpid is not null");
            return (Criteria) this;
        }

        public Criteria andRpidEqualTo(Integer value) {
            addCriterion("rpid =", value, "rpid");
            return (Criteria) this;
        }

        public Criteria andRpidNotEqualTo(Integer value) {
            addCriterion("rpid <>", value, "rpid");
            return (Criteria) this;
        }

        public Criteria andRpidGreaterThan(Integer value) {
            addCriterion("rpid >", value, "rpid");
            return (Criteria) this;
        }

        public Criteria andRpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rpid >=", value, "rpid");
            return (Criteria) this;
        }

        public Criteria andRpidLessThan(Integer value) {
            addCriterion("rpid <", value, "rpid");
            return (Criteria) this;
        }

        public Criteria andRpidLessThanOrEqualTo(Integer value) {
            addCriterion("rpid <=", value, "rpid");
            return (Criteria) this;
        }

        public Criteria andRpidIn(List<Integer> values) {
            addCriterion("rpid in", values, "rpid");
            return (Criteria) this;
        }

        public Criteria andRpidNotIn(List<Integer> values) {
            addCriterion("rpid not in", values, "rpid");
            return (Criteria) this;
        }

        public Criteria andRpidBetween(Integer value1, Integer value2) {
            addCriterion("rpid between", value1, value2, "rpid");
            return (Criteria) this;
        }

        public Criteria andRpidNotBetween(Integer value1, Integer value2) {
            addCriterion("rpid not between", value1, value2, "rpid");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andRpicurlIsNull() {
            addCriterion("rpicurl is null");
            return (Criteria) this;
        }

        public Criteria andRpicurlIsNotNull() {
            addCriterion("rpicurl is not null");
            return (Criteria) this;
        }

        public Criteria andRpicurlEqualTo(String value) {
            addCriterion("rpicurl =", value, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlNotEqualTo(String value) {
            addCriterion("rpicurl <>", value, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlGreaterThan(String value) {
            addCriterion("rpicurl >", value, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlGreaterThanOrEqualTo(String value) {
            addCriterion("rpicurl >=", value, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlLessThan(String value) {
            addCriterion("rpicurl <", value, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlLessThanOrEqualTo(String value) {
            addCriterion("rpicurl <=", value, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlLike(String value) {
            addCriterion("rpicurl like", value, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlNotLike(String value) {
            addCriterion("rpicurl not like", value, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlIn(List<String> values) {
            addCriterion("rpicurl in", values, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlNotIn(List<String> values) {
            addCriterion("rpicurl not in", values, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlBetween(String value1, String value2) {
            addCriterion("rpicurl between", value1, value2, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andRpicurlNotBetween(String value1, String value2) {
            addCriterion("rpicurl not between", value1, value2, "rpicurl");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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