package com.jin321.pl.model;

import java.util.ArrayList;
import java.util.List;

public class DealerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DealerExample() {
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

        public Criteria andDnameIsNull() {
            addCriterion("dname is null");
            return (Criteria) this;
        }

        public Criteria andDnameIsNotNull() {
            addCriterion("dname is not null");
            return (Criteria) this;
        }

        public Criteria andDnameEqualTo(String value) {
            addCriterion("dname =", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotEqualTo(String value) {
            addCriterion("dname <>", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameGreaterThan(String value) {
            addCriterion("dname >", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameGreaterThanOrEqualTo(String value) {
            addCriterion("dname >=", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameLessThan(String value) {
            addCriterion("dname <", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameLessThanOrEqualTo(String value) {
            addCriterion("dname <=", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameLike(String value) {
            addCriterion("dname like", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotLike(String value) {
            addCriterion("dname not like", value, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameIn(List<String> values) {
            addCriterion("dname in", values, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotIn(List<String> values) {
            addCriterion("dname not in", values, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameBetween(String value1, String value2) {
            addCriterion("dname between", value1, value2, "dname");
            return (Criteria) this;
        }

        public Criteria andDnameNotBetween(String value1, String value2) {
            addCriterion("dname not between", value1, value2, "dname");
            return (Criteria) this;
        }

        public Criteria andDaddressIsNull() {
            addCriterion("daddress is null");
            return (Criteria) this;
        }

        public Criteria andDaddressIsNotNull() {
            addCriterion("daddress is not null");
            return (Criteria) this;
        }

        public Criteria andDaddressEqualTo(String value) {
            addCriterion("daddress =", value, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressNotEqualTo(String value) {
            addCriterion("daddress <>", value, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressGreaterThan(String value) {
            addCriterion("daddress >", value, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressGreaterThanOrEqualTo(String value) {
            addCriterion("daddress >=", value, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressLessThan(String value) {
            addCriterion("daddress <", value, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressLessThanOrEqualTo(String value) {
            addCriterion("daddress <=", value, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressLike(String value) {
            addCriterion("daddress like", value, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressNotLike(String value) {
            addCriterion("daddress not like", value, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressIn(List<String> values) {
            addCriterion("daddress in", values, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressNotIn(List<String> values) {
            addCriterion("daddress not in", values, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressBetween(String value1, String value2) {
            addCriterion("daddress between", value1, value2, "daddress");
            return (Criteria) this;
        }

        public Criteria andDaddressNotBetween(String value1, String value2) {
            addCriterion("daddress not between", value1, value2, "daddress");
            return (Criteria) this;
        }

        public Criteria andDphonenumIsNull() {
            addCriterion("dphonenum is null");
            return (Criteria) this;
        }

        public Criteria andDphonenumIsNotNull() {
            addCriterion("dphonenum is not null");
            return (Criteria) this;
        }

        public Criteria andDphonenumEqualTo(String value) {
            addCriterion("dphonenum =", value, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumNotEqualTo(String value) {
            addCriterion("dphonenum <>", value, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumGreaterThan(String value) {
            addCriterion("dphonenum >", value, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumGreaterThanOrEqualTo(String value) {
            addCriterion("dphonenum >=", value, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumLessThan(String value) {
            addCriterion("dphonenum <", value, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumLessThanOrEqualTo(String value) {
            addCriterion("dphonenum <=", value, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumLike(String value) {
            addCriterion("dphonenum like", value, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumNotLike(String value) {
            addCriterion("dphonenum not like", value, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumIn(List<String> values) {
            addCriterion("dphonenum in", values, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumNotIn(List<String> values) {
            addCriterion("dphonenum not in", values, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumBetween(String value1, String value2) {
            addCriterion("dphonenum between", value1, value2, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDphonenumNotBetween(String value1, String value2) {
            addCriterion("dphonenum not between", value1, value2, "dphonenum");
            return (Criteria) this;
        }

        public Criteria andDusernameIsNull() {
            addCriterion("dusername is null");
            return (Criteria) this;
        }

        public Criteria andDusernameIsNotNull() {
            addCriterion("dusername is not null");
            return (Criteria) this;
        }

        public Criteria andDusernameEqualTo(String value) {
            addCriterion("dusername =", value, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameNotEqualTo(String value) {
            addCriterion("dusername <>", value, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameGreaterThan(String value) {
            addCriterion("dusername >", value, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameGreaterThanOrEqualTo(String value) {
            addCriterion("dusername >=", value, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameLessThan(String value) {
            addCriterion("dusername <", value, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameLessThanOrEqualTo(String value) {
            addCriterion("dusername <=", value, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameLike(String value) {
            addCriterion("dusername like", value, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameNotLike(String value) {
            addCriterion("dusername not like", value, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameIn(List<String> values) {
            addCriterion("dusername in", values, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameNotIn(List<String> values) {
            addCriterion("dusername not in", values, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameBetween(String value1, String value2) {
            addCriterion("dusername between", value1, value2, "dusername");
            return (Criteria) this;
        }

        public Criteria andDusernameNotBetween(String value1, String value2) {
            addCriterion("dusername not between", value1, value2, "dusername");
            return (Criteria) this;
        }

        public Criteria andDpasswordIsNull() {
            addCriterion("dpassword is null");
            return (Criteria) this;
        }

        public Criteria andDpasswordIsNotNull() {
            addCriterion("dpassword is not null");
            return (Criteria) this;
        }

        public Criteria andDpasswordEqualTo(String value) {
            addCriterion("dpassword =", value, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordNotEqualTo(String value) {
            addCriterion("dpassword <>", value, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordGreaterThan(String value) {
            addCriterion("dpassword >", value, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordGreaterThanOrEqualTo(String value) {
            addCriterion("dpassword >=", value, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordLessThan(String value) {
            addCriterion("dpassword <", value, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordLessThanOrEqualTo(String value) {
            addCriterion("dpassword <=", value, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordLike(String value) {
            addCriterion("dpassword like", value, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordNotLike(String value) {
            addCriterion("dpassword not like", value, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordIn(List<String> values) {
            addCriterion("dpassword in", values, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordNotIn(List<String> values) {
            addCriterion("dpassword not in", values, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordBetween(String value1, String value2) {
            addCriterion("dpassword between", value1, value2, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpasswordNotBetween(String value1, String value2) {
            addCriterion("dpassword not between", value1, value2, "dpassword");
            return (Criteria) this;
        }

        public Criteria andDpowerIsNull() {
            addCriterion("dpower is null");
            return (Criteria) this;
        }

        public Criteria andDpowerIsNotNull() {
            addCriterion("dpower is not null");
            return (Criteria) this;
        }

        public Criteria andDpowerEqualTo(String value) {
            addCriterion("dpower =", value, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerNotEqualTo(String value) {
            addCriterion("dpower <>", value, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerGreaterThan(String value) {
            addCriterion("dpower >", value, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerGreaterThanOrEqualTo(String value) {
            addCriterion("dpower >=", value, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerLessThan(String value) {
            addCriterion("dpower <", value, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerLessThanOrEqualTo(String value) {
            addCriterion("dpower <=", value, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerLike(String value) {
            addCriterion("dpower like", value, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerNotLike(String value) {
            addCriterion("dpower not like", value, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerIn(List<String> values) {
            addCriterion("dpower in", values, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerNotIn(List<String> values) {
            addCriterion("dpower not in", values, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerBetween(String value1, String value2) {
            addCriterion("dpower between", value1, value2, "dpower");
            return (Criteria) this;
        }

        public Criteria andDpowerNotBetween(String value1, String value2) {
            addCriterion("dpower not between", value1, value2, "dpower");
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