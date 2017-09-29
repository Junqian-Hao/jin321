package com.jin321.pl.model;

import java.util.ArrayList;
import java.util.List;

public class ProductpicsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductpicsExample() {
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

        public Criteria andPpidIsNull() {
            addCriterion("ppid is null");
            return (Criteria) this;
        }

        public Criteria andPpidIsNotNull() {
            addCriterion("ppid is not null");
            return (Criteria) this;
        }

        public Criteria andPpidEqualTo(Integer value) {
            addCriterion("ppid =", value, "ppid");
            return (Criteria) this;
        }

        public Criteria andPpidNotEqualTo(Integer value) {
            addCriterion("ppid <>", value, "ppid");
            return (Criteria) this;
        }

        public Criteria andPpidGreaterThan(Integer value) {
            addCriterion("ppid >", value, "ppid");
            return (Criteria) this;
        }

        public Criteria andPpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ppid >=", value, "ppid");
            return (Criteria) this;
        }

        public Criteria andPpidLessThan(Integer value) {
            addCriterion("ppid <", value, "ppid");
            return (Criteria) this;
        }

        public Criteria andPpidLessThanOrEqualTo(Integer value) {
            addCriterion("ppid <=", value, "ppid");
            return (Criteria) this;
        }

        public Criteria andPpidIn(List<Integer> values) {
            addCriterion("ppid in", values, "ppid");
            return (Criteria) this;
        }

        public Criteria andPpidNotIn(List<Integer> values) {
            addCriterion("ppid not in", values, "ppid");
            return (Criteria) this;
        }

        public Criteria andPpidBetween(Integer value1, Integer value2) {
            addCriterion("ppid between", value1, value2, "ppid");
            return (Criteria) this;
        }

        public Criteria andPpidNotBetween(Integer value1, Integer value2) {
            addCriterion("ppid not between", value1, value2, "ppid");
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

        public Criteria andPpicurlIsNull() {
            addCriterion("ppicurl is null");
            return (Criteria) this;
        }

        public Criteria andPpicurlIsNotNull() {
            addCriterion("ppicurl is not null");
            return (Criteria) this;
        }

        public Criteria andPpicurlEqualTo(String value) {
            addCriterion("ppicurl =", value, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlNotEqualTo(String value) {
            addCriterion("ppicurl <>", value, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlGreaterThan(String value) {
            addCriterion("ppicurl >", value, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlGreaterThanOrEqualTo(String value) {
            addCriterion("ppicurl >=", value, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlLessThan(String value) {
            addCriterion("ppicurl <", value, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlLessThanOrEqualTo(String value) {
            addCriterion("ppicurl <=", value, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlLike(String value) {
            addCriterion("ppicurl like", value, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlNotLike(String value) {
            addCriterion("ppicurl not like", value, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlIn(List<String> values) {
            addCriterion("ppicurl in", values, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlNotIn(List<String> values) {
            addCriterion("ppicurl not in", values, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlBetween(String value1, String value2) {
            addCriterion("ppicurl between", value1, value2, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andPpicurlNotBetween(String value1, String value2) {
            addCriterion("ppicurl not between", value1, value2, "ppicurl");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicIsNull() {
            addCriterion("is_headpic is null");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicIsNotNull() {
            addCriterion("is_headpic is not null");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicEqualTo(Boolean value) {
            addCriterion("is_headpic =", value, "isHeadpic");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicNotEqualTo(Boolean value) {
            addCriterion("is_headpic <>", value, "isHeadpic");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicGreaterThan(Boolean value) {
            addCriterion("is_headpic >", value, "isHeadpic");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_headpic >=", value, "isHeadpic");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicLessThan(Boolean value) {
            addCriterion("is_headpic <", value, "isHeadpic");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicLessThanOrEqualTo(Boolean value) {
            addCriterion("is_headpic <=", value, "isHeadpic");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicIn(List<Boolean> values) {
            addCriterion("is_headpic in", values, "isHeadpic");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicNotIn(List<Boolean> values) {
            addCriterion("is_headpic not in", values, "isHeadpic");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicBetween(Boolean value1, Boolean value2) {
            addCriterion("is_headpic between", value1, value2, "isHeadpic");
            return (Criteria) this;
        }

        public Criteria andIsHeadpicNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_headpic not between", value1, value2, "isHeadpic");
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