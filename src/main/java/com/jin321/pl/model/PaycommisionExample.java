package com.jin321.pl.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaycommisionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaycommisionExample() {
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

        public Criteria andPcidIsNull() {
            addCriterion("pcid is null");
            return (Criteria) this;
        }

        public Criteria andPcidIsNotNull() {
            addCriterion("pcid is not null");
            return (Criteria) this;
        }

        public Criteria andPcidEqualTo(Integer value) {
            addCriterion("pcid =", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidNotEqualTo(Integer value) {
            addCriterion("pcid <>", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidGreaterThan(Integer value) {
            addCriterion("pcid >", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidGreaterThanOrEqualTo(Integer value) {
            addCriterion("pcid >=", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidLessThan(Integer value) {
            addCriterion("pcid <", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidLessThanOrEqualTo(Integer value) {
            addCriterion("pcid <=", value, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidIn(List<Integer> values) {
            addCriterion("pcid in", values, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidNotIn(List<Integer> values) {
            addCriterion("pcid not in", values, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidBetween(Integer value1, Integer value2) {
            addCriterion("pcid between", value1, value2, "pcid");
            return (Criteria) this;
        }

        public Criteria andPcidNotBetween(Integer value1, Integer value2) {
            addCriterion("pcid not between", value1, value2, "pcid");
            return (Criteria) this;
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

        public Criteria andPaynumIsNull() {
            addCriterion("paynum is null");
            return (Criteria) this;
        }

        public Criteria andPaynumIsNotNull() {
            addCriterion("paynum is not null");
            return (Criteria) this;
        }

        public Criteria andPaynumEqualTo(BigDecimal value) {
            addCriterion("paynum =", value, "paynum");
            return (Criteria) this;
        }

        public Criteria andPaynumNotEqualTo(BigDecimal value) {
            addCriterion("paynum <>", value, "paynum");
            return (Criteria) this;
        }

        public Criteria andPaynumGreaterThan(BigDecimal value) {
            addCriterion("paynum >", value, "paynum");
            return (Criteria) this;
        }

        public Criteria andPaynumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("paynum >=", value, "paynum");
            return (Criteria) this;
        }

        public Criteria andPaynumLessThan(BigDecimal value) {
            addCriterion("paynum <", value, "paynum");
            return (Criteria) this;
        }

        public Criteria andPaynumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("paynum <=", value, "paynum");
            return (Criteria) this;
        }

        public Criteria andPaynumIn(List<BigDecimal> values) {
            addCriterion("paynum in", values, "paynum");
            return (Criteria) this;
        }

        public Criteria andPaynumNotIn(List<BigDecimal> values) {
            addCriterion("paynum not in", values, "paynum");
            return (Criteria) this;
        }

        public Criteria andPaynumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paynum between", value1, value2, "paynum");
            return (Criteria) this;
        }

        public Criteria andPaynumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("paynum not between", value1, value2, "paynum");
            return (Criteria) this;
        }

        public Criteria andPaydateIsNull() {
            addCriterion("paydate is null");
            return (Criteria) this;
        }

        public Criteria andPaydateIsNotNull() {
            addCriterion("paydate is not null");
            return (Criteria) this;
        }

        public Criteria andPaydateEqualTo(Date value) {
            addCriterion("paydate =", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotEqualTo(Date value) {
            addCriterion("paydate <>", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateGreaterThan(Date value) {
            addCriterion("paydate >", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateGreaterThanOrEqualTo(Date value) {
            addCriterion("paydate >=", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLessThan(Date value) {
            addCriterion("paydate <", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateLessThanOrEqualTo(Date value) {
            addCriterion("paydate <=", value, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateIn(List<Date> values) {
            addCriterion("paydate in", values, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotIn(List<Date> values) {
            addCriterion("paydate not in", values, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateBetween(Date value1, Date value2) {
            addCriterion("paydate between", value1, value2, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaydateNotBetween(Date value1, Date value2) {
            addCriterion("paydate not between", value1, value2, "paydate");
            return (Criteria) this;
        }

        public Criteria andPaymsgIsNull() {
            addCriterion("paymsg is null");
            return (Criteria) this;
        }

        public Criteria andPaymsgIsNotNull() {
            addCriterion("paymsg is not null");
            return (Criteria) this;
        }

        public Criteria andPaymsgEqualTo(String value) {
            addCriterion("paymsg =", value, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgNotEqualTo(String value) {
            addCriterion("paymsg <>", value, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgGreaterThan(String value) {
            addCriterion("paymsg >", value, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgGreaterThanOrEqualTo(String value) {
            addCriterion("paymsg >=", value, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgLessThan(String value) {
            addCriterion("paymsg <", value, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgLessThanOrEqualTo(String value) {
            addCriterion("paymsg <=", value, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgLike(String value) {
            addCriterion("paymsg like", value, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgNotLike(String value) {
            addCriterion("paymsg not like", value, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgIn(List<String> values) {
            addCriterion("paymsg in", values, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgNotIn(List<String> values) {
            addCriterion("paymsg not in", values, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgBetween(String value1, String value2) {
            addCriterion("paymsg between", value1, value2, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgNotBetween(String value1, String value2) {
            addCriterion("paymsg not between", value1, value2, "paymsg");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrIsNull() {
            addCriterion("paymsgusr is null");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrIsNotNull() {
            addCriterion("paymsgusr is not null");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrEqualTo(String value) {
            addCriterion("paymsgusr =", value, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrNotEqualTo(String value) {
            addCriterion("paymsgusr <>", value, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrGreaterThan(String value) {
            addCriterion("paymsgusr >", value, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrGreaterThanOrEqualTo(String value) {
            addCriterion("paymsgusr >=", value, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrLessThan(String value) {
            addCriterion("paymsgusr <", value, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrLessThanOrEqualTo(String value) {
            addCriterion("paymsgusr <=", value, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrLike(String value) {
            addCriterion("paymsgusr like", value, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrNotLike(String value) {
            addCriterion("paymsgusr not like", value, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrIn(List<String> values) {
            addCriterion("paymsgusr in", values, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrNotIn(List<String> values) {
            addCriterion("paymsgusr not in", values, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrBetween(String value1, String value2) {
            addCriterion("paymsgusr between", value1, value2, "paymsgusr");
            return (Criteria) this;
        }

        public Criteria andPaymsgusrNotBetween(String value1, String value2) {
            addCriterion("paymsgusr not between", value1, value2, "paymsgusr");
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