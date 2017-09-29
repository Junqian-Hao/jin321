package com.jin321.pl.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TimeproductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TimeproductExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andTpidIsNull() {
            addCriterion("tpid is null");
            return (Criteria) this;
        }

        public Criteria andTpidIsNotNull() {
            addCriterion("tpid is not null");
            return (Criteria) this;
        }

        public Criteria andTpidEqualTo(Integer value) {
            addCriterion("tpid =", value, "tpid");
            return (Criteria) this;
        }

        public Criteria andTpidNotEqualTo(Integer value) {
            addCriterion("tpid <>", value, "tpid");
            return (Criteria) this;
        }

        public Criteria andTpidGreaterThan(Integer value) {
            addCriterion("tpid >", value, "tpid");
            return (Criteria) this;
        }

        public Criteria andTpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tpid >=", value, "tpid");
            return (Criteria) this;
        }

        public Criteria andTpidLessThan(Integer value) {
            addCriterion("tpid <", value, "tpid");
            return (Criteria) this;
        }

        public Criteria andTpidLessThanOrEqualTo(Integer value) {
            addCriterion("tpid <=", value, "tpid");
            return (Criteria) this;
        }

        public Criteria andTpidIn(List<Integer> values) {
            addCriterion("tpid in", values, "tpid");
            return (Criteria) this;
        }

        public Criteria andTpidNotIn(List<Integer> values) {
            addCriterion("tpid not in", values, "tpid");
            return (Criteria) this;
        }

        public Criteria andTpidBetween(Integer value1, Integer value2) {
            addCriterion("tpid between", value1, value2, "tpid");
            return (Criteria) this;
        }

        public Criteria andTpidNotBetween(Integer value1, Integer value2) {
            addCriterion("tpid not between", value1, value2, "tpid");
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

        public Criteria andTimestartIsNull() {
            addCriterion("timestart is null");
            return (Criteria) this;
        }

        public Criteria andTimestartIsNotNull() {
            addCriterion("timestart is not null");
            return (Criteria) this;
        }

        public Criteria andTimestartEqualTo(Date value) {
            addCriterionForJDBCDate("timestart =", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartNotEqualTo(Date value) {
            addCriterionForJDBCDate("timestart <>", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartGreaterThan(Date value) {
            addCriterionForJDBCDate("timestart >", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("timestart >=", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartLessThan(Date value) {
            addCriterionForJDBCDate("timestart <", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("timestart <=", value, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartIn(List<Date> values) {
            addCriterionForJDBCDate("timestart in", values, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartNotIn(List<Date> values) {
            addCriterionForJDBCDate("timestart not in", values, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("timestart between", value1, value2, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimestartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("timestart not between", value1, value2, "timestart");
            return (Criteria) this;
        }

        public Criteria andTimeendIsNull() {
            addCriterion("timeend is null");
            return (Criteria) this;
        }

        public Criteria andTimeendIsNotNull() {
            addCriterion("timeend is not null");
            return (Criteria) this;
        }

        public Criteria andTimeendEqualTo(Date value) {
            addCriterionForJDBCDate("timeend =", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendNotEqualTo(Date value) {
            addCriterionForJDBCDate("timeend <>", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendGreaterThan(Date value) {
            addCriterionForJDBCDate("timeend >", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("timeend >=", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendLessThan(Date value) {
            addCriterionForJDBCDate("timeend <", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("timeend <=", value, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendIn(List<Date> values) {
            addCriterionForJDBCDate("timeend in", values, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendNotIn(List<Date> values) {
            addCriterionForJDBCDate("timeend not in", values, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("timeend between", value1, value2, "timeend");
            return (Criteria) this;
        }

        public Criteria andTimeendNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("timeend not between", value1, value2, "timeend");
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