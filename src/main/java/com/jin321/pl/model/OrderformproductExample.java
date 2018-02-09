package com.jin321.pl.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderformproductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderformproductExample() {
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

        public Criteria andOfpidIsNull() {
            addCriterion("ofpid is null");
            return (Criteria) this;
        }

        public Criteria andOfpidIsNotNull() {
            addCriterion("ofpid is not null");
            return (Criteria) this;
        }

        public Criteria andOfpidEqualTo(Integer value) {
            addCriterion("ofpid =", value, "ofpid");
            return (Criteria) this;
        }

        public Criteria andOfpidNotEqualTo(Integer value) {
            addCriterion("ofpid <>", value, "ofpid");
            return (Criteria) this;
        }

        public Criteria andOfpidGreaterThan(Integer value) {
            addCriterion("ofpid >", value, "ofpid");
            return (Criteria) this;
        }

        public Criteria andOfpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ofpid >=", value, "ofpid");
            return (Criteria) this;
        }

        public Criteria andOfpidLessThan(Integer value) {
            addCriterion("ofpid <", value, "ofpid");
            return (Criteria) this;
        }

        public Criteria andOfpidLessThanOrEqualTo(Integer value) {
            addCriterion("ofpid <=", value, "ofpid");
            return (Criteria) this;
        }

        public Criteria andOfpidIn(List<Integer> values) {
            addCriterion("ofpid in", values, "ofpid");
            return (Criteria) this;
        }

        public Criteria andOfpidNotIn(List<Integer> values) {
            addCriterion("ofpid not in", values, "ofpid");
            return (Criteria) this;
        }

        public Criteria andOfpidBetween(Integer value1, Integer value2) {
            addCriterion("ofpid between", value1, value2, "ofpid");
            return (Criteria) this;
        }

        public Criteria andOfpidNotBetween(Integer value1, Integer value2) {
            addCriterion("ofpid not between", value1, value2, "ofpid");
            return (Criteria) this;
        }

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Long value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Long value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Long value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Long value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Long value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Long value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Long> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Long> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Long value1, Long value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Long value1, Long value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
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

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andPamountIsNull() {
            addCriterion("pamount is null");
            return (Criteria) this;
        }

        public Criteria andPamountIsNotNull() {
            addCriterion("pamount is not null");
            return (Criteria) this;
        }

        public Criteria andPamountEqualTo(Integer value) {
            addCriterion("pamount =", value, "pamount");
            return (Criteria) this;
        }

        public Criteria andPamountNotEqualTo(Integer value) {
            addCriterion("pamount <>", value, "pamount");
            return (Criteria) this;
        }

        public Criteria andPamountGreaterThan(Integer value) {
            addCriterion("pamount >", value, "pamount");
            return (Criteria) this;
        }

        public Criteria andPamountGreaterThanOrEqualTo(Integer value) {
            addCriterion("pamount >=", value, "pamount");
            return (Criteria) this;
        }

        public Criteria andPamountLessThan(Integer value) {
            addCriterion("pamount <", value, "pamount");
            return (Criteria) this;
        }

        public Criteria andPamountLessThanOrEqualTo(Integer value) {
            addCriterion("pamount <=", value, "pamount");
            return (Criteria) this;
        }

        public Criteria andPamountIn(List<Integer> values) {
            addCriterion("pamount in", values, "pamount");
            return (Criteria) this;
        }

        public Criteria andPamountNotIn(List<Integer> values) {
            addCriterion("pamount not in", values, "pamount");
            return (Criteria) this;
        }

        public Criteria andPamountBetween(Integer value1, Integer value2) {
            addCriterion("pamount between", value1, value2, "pamount");
            return (Criteria) this;
        }

        public Criteria andPamountNotBetween(Integer value1, Integer value2) {
            addCriterion("pamount not between", value1, value2, "pamount");
            return (Criteria) this;
        }

        public Criteria andPbuypriceIsNull() {
            addCriterion("pbuyprice is null");
            return (Criteria) this;
        }

        public Criteria andPbuypriceIsNotNull() {
            addCriterion("pbuyprice is not null");
            return (Criteria) this;
        }

        public Criteria andPbuypriceEqualTo(BigDecimal value) {
            addCriterion("pbuyprice =", value, "pbuyprice");
            return (Criteria) this;
        }

        public Criteria andPbuypriceNotEqualTo(BigDecimal value) {
            addCriterion("pbuyprice <>", value, "pbuyprice");
            return (Criteria) this;
        }

        public Criteria andPbuypriceGreaterThan(BigDecimal value) {
            addCriterion("pbuyprice >", value, "pbuyprice");
            return (Criteria) this;
        }

        public Criteria andPbuypriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pbuyprice >=", value, "pbuyprice");
            return (Criteria) this;
        }

        public Criteria andPbuypriceLessThan(BigDecimal value) {
            addCriterion("pbuyprice <", value, "pbuyprice");
            return (Criteria) this;
        }

        public Criteria andPbuypriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pbuyprice <=", value, "pbuyprice");
            return (Criteria) this;
        }

        public Criteria andPbuypriceIn(List<BigDecimal> values) {
            addCriterion("pbuyprice in", values, "pbuyprice");
            return (Criteria) this;
        }

        public Criteria andPbuypriceNotIn(List<BigDecimal> values) {
            addCriterion("pbuyprice not in", values, "pbuyprice");
            return (Criteria) this;
        }

        public Criteria andPbuypriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pbuyprice between", value1, value2, "pbuyprice");
            return (Criteria) this;
        }

        public Criteria andPbuypriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pbuyprice not between", value1, value2, "pbuyprice");
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