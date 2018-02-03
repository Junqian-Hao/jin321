package com.jin321.pl.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DealerbuyformExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DealerbuyformExample() {
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

        public Criteria andDbfidIsNull() {
            addCriterion("dbfid is null");
            return (Criteria) this;
        }

        public Criteria andDbfidIsNotNull() {
            addCriterion("dbfid is not null");
            return (Criteria) this;
        }

        public Criteria andDbfidEqualTo(Long value) {
            addCriterion("dbfid =", value, "dbfid");
            return (Criteria) this;
        }

        public Criteria andDbfidNotEqualTo(Long value) {
            addCriterion("dbfid <>", value, "dbfid");
            return (Criteria) this;
        }

        public Criteria andDbfidGreaterThan(Long value) {
            addCriterion("dbfid >", value, "dbfid");
            return (Criteria) this;
        }

        public Criteria andDbfidGreaterThanOrEqualTo(Long value) {
            addCriterion("dbfid >=", value, "dbfid");
            return (Criteria) this;
        }

        public Criteria andDbfidLessThan(Long value) {
            addCriterion("dbfid <", value, "dbfid");
            return (Criteria) this;
        }

        public Criteria andDbfidLessThanOrEqualTo(Long value) {
            addCriterion("dbfid <=", value, "dbfid");
            return (Criteria) this;
        }

        public Criteria andDbfidIn(List<Long> values) {
            addCriterion("dbfid in", values, "dbfid");
            return (Criteria) this;
        }

        public Criteria andDbfidNotIn(List<Long> values) {
            addCriterion("dbfid not in", values, "dbfid");
            return (Criteria) this;
        }

        public Criteria andDbfidBetween(Long value1, Long value2) {
            addCriterion("dbfid between", value1, value2, "dbfid");
            return (Criteria) this;
        }

        public Criteria andDbfidNotBetween(Long value1, Long value2) {
            addCriterion("dbfid not between", value1, value2, "dbfid");
            return (Criteria) this;
        }

        public Criteria andBuyformstateIsNull() {
            addCriterion("buyformstate is null");
            return (Criteria) this;
        }

        public Criteria andBuyformstateIsNotNull() {
            addCriterion("buyformstate is not null");
            return (Criteria) this;
        }

        public Criteria andBuyformstateEqualTo(Integer value) {
            addCriterion("buyformstate =", value, "buyformstate");
            return (Criteria) this;
        }

        public Criteria andBuyformstateNotEqualTo(Integer value) {
            addCriterion("buyformstate <>", value, "buyformstate");
            return (Criteria) this;
        }

        public Criteria andBuyformstateGreaterThan(Integer value) {
            addCriterion("buyformstate >", value, "buyformstate");
            return (Criteria) this;
        }

        public Criteria andBuyformstateGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyformstate >=", value, "buyformstate");
            return (Criteria) this;
        }

        public Criteria andBuyformstateLessThan(Integer value) {
            addCriterion("buyformstate <", value, "buyformstate");
            return (Criteria) this;
        }

        public Criteria andBuyformstateLessThanOrEqualTo(Integer value) {
            addCriterion("buyformstate <=", value, "buyformstate");
            return (Criteria) this;
        }

        public Criteria andBuyformstateIn(List<Integer> values) {
            addCriterion("buyformstate in", values, "buyformstate");
            return (Criteria) this;
        }

        public Criteria andBuyformstateNotIn(List<Integer> values) {
            addCriterion("buyformstate not in", values, "buyformstate");
            return (Criteria) this;
        }

        public Criteria andBuyformstateBetween(Integer value1, Integer value2) {
            addCriterion("buyformstate between", value1, value2, "buyformstate");
            return (Criteria) this;
        }

        public Criteria andBuyformstateNotBetween(Integer value1, Integer value2) {
            addCriterion("buyformstate not between", value1, value2, "buyformstate");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNull() {
            addCriterion("totalmoney is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("totalmoney is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(BigDecimal value) {
            addCriterion("totalmoney =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(BigDecimal value) {
            addCriterion("totalmoney <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(BigDecimal value) {
            addCriterion("totalmoney >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("totalmoney >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(BigDecimal value) {
            addCriterion("totalmoney <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("totalmoney <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<BigDecimal> values) {
            addCriterion("totalmoney in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<BigDecimal> values) {
            addCriterion("totalmoney not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalmoney between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("totalmoney not between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andDbfdateIsNull() {
            addCriterion("dbfdate is null");
            return (Criteria) this;
        }

        public Criteria andDbfdateIsNotNull() {
            addCriterion("dbfdate is not null");
            return (Criteria) this;
        }

        public Criteria andDbfdateEqualTo(Date value) {
            addCriterion("dbfdate =", value, "dbfdate");
            return (Criteria) this;
        }

        public Criteria andDbfdateNotEqualTo(Date value) {
            addCriterion("dbfdate <>", value, "dbfdate");
            return (Criteria) this;
        }

        public Criteria andDbfdateGreaterThan(Date value) {
            addCriterion("dbfdate >", value, "dbfdate");
            return (Criteria) this;
        }

        public Criteria andDbfdateGreaterThanOrEqualTo(Date value) {
            addCriterion("dbfdate >=", value, "dbfdate");
            return (Criteria) this;
        }

        public Criteria andDbfdateLessThan(Date value) {
            addCriterion("dbfdate <", value, "dbfdate");
            return (Criteria) this;
        }

        public Criteria andDbfdateLessThanOrEqualTo(Date value) {
            addCriterion("dbfdate <=", value, "dbfdate");
            return (Criteria) this;
        }

        public Criteria andDbfdateIn(List<Date> values) {
            addCriterion("dbfdate in", values, "dbfdate");
            return (Criteria) this;
        }

        public Criteria andDbfdateNotIn(List<Date> values) {
            addCriterion("dbfdate not in", values, "dbfdate");
            return (Criteria) this;
        }

        public Criteria andDbfdateBetween(Date value1, Date value2) {
            addCriterion("dbfdate between", value1, value2, "dbfdate");
            return (Criteria) this;
        }

        public Criteria andDbfdateNotBetween(Date value1, Date value2) {
            addCriterion("dbfdate not between", value1, value2, "dbfdate");
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