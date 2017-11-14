package com.jin321.pl.model;

import java.util.ArrayList;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Integer value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Integer value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Integer value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Integer value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Integer value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Integer> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Integer> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Integer value1, Integer value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Integer value1, Integer value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andPnameIsNull() {
            addCriterion("pname is null");
            return (Criteria) this;
        }

        public Criteria andPnameIsNotNull() {
            addCriterion("pname is not null");
            return (Criteria) this;
        }

        public Criteria andPnameEqualTo(String value) {
            addCriterion("pname =", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotEqualTo(String value) {
            addCriterion("pname <>", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThan(String value) {
            addCriterion("pname >", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameGreaterThanOrEqualTo(String value) {
            addCriterion("pname >=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThan(String value) {
            addCriterion("pname <", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLessThanOrEqualTo(String value) {
            addCriterion("pname <=", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameLike(String value) {
            addCriterion("pname like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotLike(String value) {
            addCriterion("pname not like", value, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameIn(List<String> values) {
            addCriterion("pname in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotIn(List<String> values) {
            addCriterion("pname not in", values, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameBetween(String value1, String value2) {
            addCriterion("pname between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPnameNotBetween(String value1, String value2) {
            addCriterion("pname not between", value1, value2, "pname");
            return (Criteria) this;
        }

        public Criteria andPsummaryIsNull() {
            addCriterion("psummary is null");
            return (Criteria) this;
        }

        public Criteria andPsummaryIsNotNull() {
            addCriterion("psummary is not null");
            return (Criteria) this;
        }

        public Criteria andPsummaryEqualTo(String value) {
            addCriterion("psummary =", value, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryNotEqualTo(String value) {
            addCriterion("psummary <>", value, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryGreaterThan(String value) {
            addCriterion("psummary >", value, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryGreaterThanOrEqualTo(String value) {
            addCriterion("psummary >=", value, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryLessThan(String value) {
            addCriterion("psummary <", value, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryLessThanOrEqualTo(String value) {
            addCriterion("psummary <=", value, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryLike(String value) {
            addCriterion("psummary like", value, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryNotLike(String value) {
            addCriterion("psummary not like", value, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryIn(List<String> values) {
            addCriterion("psummary in", values, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryNotIn(List<String> values) {
            addCriterion("psummary not in", values, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryBetween(String value1, String value2) {
            addCriterion("psummary between", value1, value2, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsummaryNotBetween(String value1, String value2) {
            addCriterion("psummary not between", value1, value2, "psummary");
            return (Criteria) this;
        }

        public Criteria andPsellnumIsNull() {
            addCriterion("psellnum is null");
            return (Criteria) this;
        }

        public Criteria andPsellnumIsNotNull() {
            addCriterion("psellnum is not null");
            return (Criteria) this;
        }

        public Criteria andPsellnumEqualTo(Integer value) {
            addCriterion("psellnum =", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumNotEqualTo(Integer value) {
            addCriterion("psellnum <>", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumGreaterThan(Integer value) {
            addCriterion("psellnum >", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("psellnum >=", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumLessThan(Integer value) {
            addCriterion("psellnum <", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumLessThanOrEqualTo(Integer value) {
            addCriterion("psellnum <=", value, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumIn(List<Integer> values) {
            addCriterion("psellnum in", values, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumNotIn(List<Integer> values) {
            addCriterion("psellnum not in", values, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumBetween(Integer value1, Integer value2) {
            addCriterion("psellnum between", value1, value2, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPsellnumNotBetween(Integer value1, Integer value2) {
            addCriterion("psellnum not between", value1, value2, "psellnum");
            return (Criteria) this;
        }

        public Criteria andPtypeaIsNull() {
            addCriterion("ptypea is null");
            return (Criteria) this;
        }

        public Criteria andPtypeaIsNotNull() {
            addCriterion("ptypea is not null");
            return (Criteria) this;
        }

        public Criteria andPtypeaEqualTo(Integer value) {
            addCriterion("ptypea =", value, "ptypea");
            return (Criteria) this;
        }

        public Criteria andPtypeaNotEqualTo(Integer value) {
            addCriterion("ptypea <>", value, "ptypea");
            return (Criteria) this;
        }

        public Criteria andPtypeaGreaterThan(Integer value) {
            addCriterion("ptypea >", value, "ptypea");
            return (Criteria) this;
        }

        public Criteria andPtypeaGreaterThanOrEqualTo(Integer value) {
            addCriterion("ptypea >=", value, "ptypea");
            return (Criteria) this;
        }

        public Criteria andPtypeaLessThan(Integer value) {
            addCriterion("ptypea <", value, "ptypea");
            return (Criteria) this;
        }

        public Criteria andPtypeaLessThanOrEqualTo(Integer value) {
            addCriterion("ptypea <=", value, "ptypea");
            return (Criteria) this;
        }

        public Criteria andPtypeaIn(List<Integer> values) {
            addCriterion("ptypea in", values, "ptypea");
            return (Criteria) this;
        }

        public Criteria andPtypeaNotIn(List<Integer> values) {
            addCriterion("ptypea not in", values, "ptypea");
            return (Criteria) this;
        }

        public Criteria andPtypeaBetween(Integer value1, Integer value2) {
            addCriterion("ptypea between", value1, value2, "ptypea");
            return (Criteria) this;
        }

        public Criteria andPtypeaNotBetween(Integer value1, Integer value2) {
            addCriterion("ptypea not between", value1, value2, "ptypea");
            return (Criteria) this;
        }

        public Criteria andPtypebIsNull() {
            addCriterion("ptypeb is null");
            return (Criteria) this;
        }

        public Criteria andPtypebIsNotNull() {
            addCriterion("ptypeb is not null");
            return (Criteria) this;
        }

        public Criteria andPtypebEqualTo(Integer value) {
            addCriterion("ptypeb =", value, "ptypeb");
            return (Criteria) this;
        }

        public Criteria andPtypebNotEqualTo(Integer value) {
            addCriterion("ptypeb <>", value, "ptypeb");
            return (Criteria) this;
        }

        public Criteria andPtypebGreaterThan(Integer value) {
            addCriterion("ptypeb >", value, "ptypeb");
            return (Criteria) this;
        }

        public Criteria andPtypebGreaterThanOrEqualTo(Integer value) {
            addCriterion("ptypeb >=", value, "ptypeb");
            return (Criteria) this;
        }

        public Criteria andPtypebLessThan(Integer value) {
            addCriterion("ptypeb <", value, "ptypeb");
            return (Criteria) this;
        }

        public Criteria andPtypebLessThanOrEqualTo(Integer value) {
            addCriterion("ptypeb <=", value, "ptypeb");
            return (Criteria) this;
        }

        public Criteria andPtypebIn(List<Integer> values) {
            addCriterion("ptypeb in", values, "ptypeb");
            return (Criteria) this;
        }

        public Criteria andPtypebNotIn(List<Integer> values) {
            addCriterion("ptypeb not in", values, "ptypeb");
            return (Criteria) this;
        }

        public Criteria andPtypebBetween(Integer value1, Integer value2) {
            addCriterion("ptypeb between", value1, value2, "ptypeb");
            return (Criteria) this;
        }

        public Criteria andPtypebNotBetween(Integer value1, Integer value2) {
            addCriterion("ptypeb not between", value1, value2, "ptypeb");
            return (Criteria) this;
        }

        public Criteria andPtypecIsNull() {
            addCriterion("ptypec is null");
            return (Criteria) this;
        }

        public Criteria andPtypecIsNotNull() {
            addCriterion("ptypec is not null");
            return (Criteria) this;
        }

        public Criteria andPtypecEqualTo(Integer value) {
            addCriterion("ptypec =", value, "ptypec");
            return (Criteria) this;
        }

        public Criteria andPtypecNotEqualTo(Integer value) {
            addCriterion("ptypec <>", value, "ptypec");
            return (Criteria) this;
        }

        public Criteria andPtypecGreaterThan(Integer value) {
            addCriterion("ptypec >", value, "ptypec");
            return (Criteria) this;
        }

        public Criteria andPtypecGreaterThanOrEqualTo(Integer value) {
            addCriterion("ptypec >=", value, "ptypec");
            return (Criteria) this;
        }

        public Criteria andPtypecLessThan(Integer value) {
            addCriterion("ptypec <", value, "ptypec");
            return (Criteria) this;
        }

        public Criteria andPtypecLessThanOrEqualTo(Integer value) {
            addCriterion("ptypec <=", value, "ptypec");
            return (Criteria) this;
        }

        public Criteria andPtypecIn(List<Integer> values) {
            addCriterion("ptypec in", values, "ptypec");
            return (Criteria) this;
        }

        public Criteria andPtypecNotIn(List<Integer> values) {
            addCriterion("ptypec not in", values, "ptypec");
            return (Criteria) this;
        }

        public Criteria andPtypecBetween(Integer value1, Integer value2) {
            addCriterion("ptypec between", value1, value2, "ptypec");
            return (Criteria) this;
        }

        public Criteria andPtypecNotBetween(Integer value1, Integer value2) {
            addCriterion("ptypec not between", value1, value2, "ptypec");
            return (Criteria) this;
        }

        public Criteria andIsTogetherIsNull() {
            addCriterion("is_together is null");
            return (Criteria) this;
        }

        public Criteria andIsTogetherIsNotNull() {
            addCriterion("is_together is not null");
            return (Criteria) this;
        }

        public Criteria andIsTogetherEqualTo(Boolean value) {
            addCriterion("is_together =", value, "isTogether");
            return (Criteria) this;
        }

        public Criteria andIsTogetherNotEqualTo(Boolean value) {
            addCriterion("is_together <>", value, "isTogether");
            return (Criteria) this;
        }

        public Criteria andIsTogetherGreaterThan(Boolean value) {
            addCriterion("is_together >", value, "isTogether");
            return (Criteria) this;
        }

        public Criteria andIsTogetherGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_together >=", value, "isTogether");
            return (Criteria) this;
        }

        public Criteria andIsTogetherLessThan(Boolean value) {
            addCriterion("is_together <", value, "isTogether");
            return (Criteria) this;
        }

        public Criteria andIsTogetherLessThanOrEqualTo(Boolean value) {
            addCriterion("is_together <=", value, "isTogether");
            return (Criteria) this;
        }

        public Criteria andIsTogetherIn(List<Boolean> values) {
            addCriterion("is_together in", values, "isTogether");
            return (Criteria) this;
        }

        public Criteria andIsTogetherNotIn(List<Boolean> values) {
            addCriterion("is_together not in", values, "isTogether");
            return (Criteria) this;
        }

        public Criteria andIsTogetherBetween(Boolean value1, Boolean value2) {
            addCriterion("is_together between", value1, value2, "isTogether");
            return (Criteria) this;
        }

        public Criteria andIsTogetherNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_together not between", value1, value2, "isTogether");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("is_delete is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("is_delete is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("is_delete =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("is_delete <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("is_delete >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_delete >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("is_delete <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("is_delete <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("is_delete in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("is_delete not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("is_delete between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("is_delete not between", value1, value2, "isDelete");
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