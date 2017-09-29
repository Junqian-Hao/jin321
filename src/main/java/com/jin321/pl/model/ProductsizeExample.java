package com.jin321.pl.model;

import java.util.ArrayList;
import java.util.List;

public class ProductsizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductsizeExample() {
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

        public Criteria andPscostIsNull() {
            addCriterion("pscost is null");
            return (Criteria) this;
        }

        public Criteria andPscostIsNotNull() {
            addCriterion("pscost is not null");
            return (Criteria) this;
        }

        public Criteria andPscostEqualTo(Long value) {
            addCriterion("pscost =", value, "pscost");
            return (Criteria) this;
        }

        public Criteria andPscostNotEqualTo(Long value) {
            addCriterion("pscost <>", value, "pscost");
            return (Criteria) this;
        }

        public Criteria andPscostGreaterThan(Long value) {
            addCriterion("pscost >", value, "pscost");
            return (Criteria) this;
        }

        public Criteria andPscostGreaterThanOrEqualTo(Long value) {
            addCriterion("pscost >=", value, "pscost");
            return (Criteria) this;
        }

        public Criteria andPscostLessThan(Long value) {
            addCriterion("pscost <", value, "pscost");
            return (Criteria) this;
        }

        public Criteria andPscostLessThanOrEqualTo(Long value) {
            addCriterion("pscost <=", value, "pscost");
            return (Criteria) this;
        }

        public Criteria andPscostIn(List<Long> values) {
            addCriterion("pscost in", values, "pscost");
            return (Criteria) this;
        }

        public Criteria andPscostNotIn(List<Long> values) {
            addCriterion("pscost not in", values, "pscost");
            return (Criteria) this;
        }

        public Criteria andPscostBetween(Long value1, Long value2) {
            addCriterion("pscost between", value1, value2, "pscost");
            return (Criteria) this;
        }

        public Criteria andPscostNotBetween(Long value1, Long value2) {
            addCriterion("pscost not between", value1, value2, "pscost");
            return (Criteria) this;
        }

        public Criteria andPsoripriceIsNull() {
            addCriterion("psoriprice is null");
            return (Criteria) this;
        }

        public Criteria andPsoripriceIsNotNull() {
            addCriterion("psoriprice is not null");
            return (Criteria) this;
        }

        public Criteria andPsoripriceEqualTo(Long value) {
            addCriterion("psoriprice =", value, "psoriprice");
            return (Criteria) this;
        }

        public Criteria andPsoripriceNotEqualTo(Long value) {
            addCriterion("psoriprice <>", value, "psoriprice");
            return (Criteria) this;
        }

        public Criteria andPsoripriceGreaterThan(Long value) {
            addCriterion("psoriprice >", value, "psoriprice");
            return (Criteria) this;
        }

        public Criteria andPsoripriceGreaterThanOrEqualTo(Long value) {
            addCriterion("psoriprice >=", value, "psoriprice");
            return (Criteria) this;
        }

        public Criteria andPsoripriceLessThan(Long value) {
            addCriterion("psoriprice <", value, "psoriprice");
            return (Criteria) this;
        }

        public Criteria andPsoripriceLessThanOrEqualTo(Long value) {
            addCriterion("psoriprice <=", value, "psoriprice");
            return (Criteria) this;
        }

        public Criteria andPsoripriceIn(List<Long> values) {
            addCriterion("psoriprice in", values, "psoriprice");
            return (Criteria) this;
        }

        public Criteria andPsoripriceNotIn(List<Long> values) {
            addCriterion("psoriprice not in", values, "psoriprice");
            return (Criteria) this;
        }

        public Criteria andPsoripriceBetween(Long value1, Long value2) {
            addCriterion("psoriprice between", value1, value2, "psoriprice");
            return (Criteria) this;
        }

        public Criteria andPsoripriceNotBetween(Long value1, Long value2) {
            addCriterion("psoriprice not between", value1, value2, "psoriprice");
            return (Criteria) this;
        }

        public Criteria andPssellpriceIsNull() {
            addCriterion("pssellprice is null");
            return (Criteria) this;
        }

        public Criteria andPssellpriceIsNotNull() {
            addCriterion("pssellprice is not null");
            return (Criteria) this;
        }

        public Criteria andPssellpriceEqualTo(Long value) {
            addCriterion("pssellprice =", value, "pssellprice");
            return (Criteria) this;
        }

        public Criteria andPssellpriceNotEqualTo(Long value) {
            addCriterion("pssellprice <>", value, "pssellprice");
            return (Criteria) this;
        }

        public Criteria andPssellpriceGreaterThan(Long value) {
            addCriterion("pssellprice >", value, "pssellprice");
            return (Criteria) this;
        }

        public Criteria andPssellpriceGreaterThanOrEqualTo(Long value) {
            addCriterion("pssellprice >=", value, "pssellprice");
            return (Criteria) this;
        }

        public Criteria andPssellpriceLessThan(Long value) {
            addCriterion("pssellprice <", value, "pssellprice");
            return (Criteria) this;
        }

        public Criteria andPssellpriceLessThanOrEqualTo(Long value) {
            addCriterion("pssellprice <=", value, "pssellprice");
            return (Criteria) this;
        }

        public Criteria andPssellpriceIn(List<Long> values) {
            addCriterion("pssellprice in", values, "pssellprice");
            return (Criteria) this;
        }

        public Criteria andPssellpriceNotIn(List<Long> values) {
            addCriterion("pssellprice not in", values, "pssellprice");
            return (Criteria) this;
        }

        public Criteria andPssellpriceBetween(Long value1, Long value2) {
            addCriterion("pssellprice between", value1, value2, "pssellprice");
            return (Criteria) this;
        }

        public Criteria andPssellpriceNotBetween(Long value1, Long value2) {
            addCriterion("pssellprice not between", value1, value2, "pssellprice");
            return (Criteria) this;
        }

        public Criteria andSizenameIsNull() {
            addCriterion("sizename is null");
            return (Criteria) this;
        }

        public Criteria andSizenameIsNotNull() {
            addCriterion("sizename is not null");
            return (Criteria) this;
        }

        public Criteria andSizenameEqualTo(String value) {
            addCriterion("sizename =", value, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameNotEqualTo(String value) {
            addCriterion("sizename <>", value, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameGreaterThan(String value) {
            addCriterion("sizename >", value, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameGreaterThanOrEqualTo(String value) {
            addCriterion("sizename >=", value, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameLessThan(String value) {
            addCriterion("sizename <", value, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameLessThanOrEqualTo(String value) {
            addCriterion("sizename <=", value, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameLike(String value) {
            addCriterion("sizename like", value, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameNotLike(String value) {
            addCriterion("sizename not like", value, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameIn(List<String> values) {
            addCriterion("sizename in", values, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameNotIn(List<String> values) {
            addCriterion("sizename not in", values, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameBetween(String value1, String value2) {
            addCriterion("sizename between", value1, value2, "sizename");
            return (Criteria) this;
        }

        public Criteria andSizenameNotBetween(String value1, String value2) {
            addCriterion("sizename not between", value1, value2, "sizename");
            return (Criteria) this;
        }

        public Criteria andSnumberIsNull() {
            addCriterion("snumber is null");
            return (Criteria) this;
        }

        public Criteria andSnumberIsNotNull() {
            addCriterion("snumber is not null");
            return (Criteria) this;
        }

        public Criteria andSnumberEqualTo(Integer value) {
            addCriterion("snumber =", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotEqualTo(Integer value) {
            addCriterion("snumber <>", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberGreaterThan(Integer value) {
            addCriterion("snumber >", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("snumber >=", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberLessThan(Integer value) {
            addCriterion("snumber <", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberLessThanOrEqualTo(Integer value) {
            addCriterion("snumber <=", value, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberIn(List<Integer> values) {
            addCriterion("snumber in", values, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotIn(List<Integer> values) {
            addCriterion("snumber not in", values, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberBetween(Integer value1, Integer value2) {
            addCriterion("snumber between", value1, value2, "snumber");
            return (Criteria) this;
        }

        public Criteria andSnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("snumber not between", value1, value2, "snumber");
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