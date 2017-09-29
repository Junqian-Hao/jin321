package com.jin321.pl.model;

import java.util.ArrayList;
import java.util.List;

public class SecondrelateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SecondrelateExample() {
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

        public Criteria andR2idIsNull() {
            addCriterion("r2id is null");
            return (Criteria) this;
        }

        public Criteria andR2idIsNotNull() {
            addCriterion("r2id is not null");
            return (Criteria) this;
        }

        public Criteria andR2idEqualTo(Integer value) {
            addCriterion("r2id =", value, "r2id");
            return (Criteria) this;
        }

        public Criteria andR2idNotEqualTo(Integer value) {
            addCriterion("r2id <>", value, "r2id");
            return (Criteria) this;
        }

        public Criteria andR2idGreaterThan(Integer value) {
            addCriterion("r2id >", value, "r2id");
            return (Criteria) this;
        }

        public Criteria andR2idGreaterThanOrEqualTo(Integer value) {
            addCriterion("r2id >=", value, "r2id");
            return (Criteria) this;
        }

        public Criteria andR2idLessThan(Integer value) {
            addCriterion("r2id <", value, "r2id");
            return (Criteria) this;
        }

        public Criteria andR2idLessThanOrEqualTo(Integer value) {
            addCriterion("r2id <=", value, "r2id");
            return (Criteria) this;
        }

        public Criteria andR2idIn(List<Integer> values) {
            addCriterion("r2id in", values, "r2id");
            return (Criteria) this;
        }

        public Criteria andR2idNotIn(List<Integer> values) {
            addCriterion("r2id not in", values, "r2id");
            return (Criteria) this;
        }

        public Criteria andR2idBetween(Integer value1, Integer value2) {
            addCriterion("r2id between", value1, value2, "r2id");
            return (Criteria) this;
        }

        public Criteria andR2idNotBetween(Integer value1, Integer value2) {
            addCriterion("r2id not between", value1, value2, "r2id");
            return (Criteria) this;
        }

        public Criteria andR2u1idIsNull() {
            addCriterion("r2u1id is null");
            return (Criteria) this;
        }

        public Criteria andR2u1idIsNotNull() {
            addCriterion("r2u1id is not null");
            return (Criteria) this;
        }

        public Criteria andR2u1idEqualTo(String value) {
            addCriterion("r2u1id =", value, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idNotEqualTo(String value) {
            addCriterion("r2u1id <>", value, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idGreaterThan(String value) {
            addCriterion("r2u1id >", value, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idGreaterThanOrEqualTo(String value) {
            addCriterion("r2u1id >=", value, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idLessThan(String value) {
            addCriterion("r2u1id <", value, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idLessThanOrEqualTo(String value) {
            addCriterion("r2u1id <=", value, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idLike(String value) {
            addCriterion("r2u1id like", value, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idNotLike(String value) {
            addCriterion("r2u1id not like", value, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idIn(List<String> values) {
            addCriterion("r2u1id in", values, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idNotIn(List<String> values) {
            addCriterion("r2u1id not in", values, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idBetween(String value1, String value2) {
            addCriterion("r2u1id between", value1, value2, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u1idNotBetween(String value1, String value2) {
            addCriterion("r2u1id not between", value1, value2, "r2u1id");
            return (Criteria) this;
        }

        public Criteria andR2u2idIsNull() {
            addCriterion("r2u2id is null");
            return (Criteria) this;
        }

        public Criteria andR2u2idIsNotNull() {
            addCriterion("r2u2id is not null");
            return (Criteria) this;
        }

        public Criteria andR2u2idEqualTo(String value) {
            addCriterion("r2u2id =", value, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idNotEqualTo(String value) {
            addCriterion("r2u2id <>", value, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idGreaterThan(String value) {
            addCriterion("r2u2id >", value, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idGreaterThanOrEqualTo(String value) {
            addCriterion("r2u2id >=", value, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idLessThan(String value) {
            addCriterion("r2u2id <", value, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idLessThanOrEqualTo(String value) {
            addCriterion("r2u2id <=", value, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idLike(String value) {
            addCriterion("r2u2id like", value, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idNotLike(String value) {
            addCriterion("r2u2id not like", value, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idIn(List<String> values) {
            addCriterion("r2u2id in", values, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idNotIn(List<String> values) {
            addCriterion("r2u2id not in", values, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idBetween(String value1, String value2) {
            addCriterion("r2u2id between", value1, value2, "r2u2id");
            return (Criteria) this;
        }

        public Criteria andR2u2idNotBetween(String value1, String value2) {
            addCriterion("r2u2id not between", value1, value2, "r2u2id");
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