package com.jin321.pl.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UseraddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UseraddressExample() {
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

        public Criteria andUaidIsNull() {
            addCriterion("uaid is null");
            return (Criteria) this;
        }

        public Criteria andUaidIsNotNull() {
            addCriterion("uaid is not null");
            return (Criteria) this;
        }

        public Criteria andUaidEqualTo(Integer value) {
            addCriterion("uaid =", value, "uaid");
            return (Criteria) this;
        }

        public Criteria andUaidNotEqualTo(Integer value) {
            addCriterion("uaid <>", value, "uaid");
            return (Criteria) this;
        }

        public Criteria andUaidGreaterThan(Integer value) {
            addCriterion("uaid >", value, "uaid");
            return (Criteria) this;
        }

        public Criteria andUaidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uaid >=", value, "uaid");
            return (Criteria) this;
        }

        public Criteria andUaidLessThan(Integer value) {
            addCriterion("uaid <", value, "uaid");
            return (Criteria) this;
        }

        public Criteria andUaidLessThanOrEqualTo(Integer value) {
            addCriterion("uaid <=", value, "uaid");
            return (Criteria) this;
        }

        public Criteria andUaidIn(List<Integer> values) {
            addCriterion("uaid in", values, "uaid");
            return (Criteria) this;
        }

        public Criteria andUaidNotIn(List<Integer> values) {
            addCriterion("uaid not in", values, "uaid");
            return (Criteria) this;
        }

        public Criteria andUaidBetween(Integer value1, Integer value2) {
            addCriterion("uaid between", value1, value2, "uaid");
            return (Criteria) this;
        }

        public Criteria andUaidNotBetween(Integer value1, Integer value2) {
            addCriterion("uaid not between", value1, value2, "uaid");
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

        public Criteria andUcountryIsNull() {
            addCriterion("ucountry is null");
            return (Criteria) this;
        }

        public Criteria andUcountryIsNotNull() {
            addCriterion("ucountry is not null");
            return (Criteria) this;
        }

        public Criteria andUcountryEqualTo(String value) {
            addCriterion("ucountry =", value, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryNotEqualTo(String value) {
            addCriterion("ucountry <>", value, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryGreaterThan(String value) {
            addCriterion("ucountry >", value, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryGreaterThanOrEqualTo(String value) {
            addCriterion("ucountry >=", value, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryLessThan(String value) {
            addCriterion("ucountry <", value, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryLessThanOrEqualTo(String value) {
            addCriterion("ucountry <=", value, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryLike(String value) {
            addCriterion("ucountry like", value, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryNotLike(String value) {
            addCriterion("ucountry not like", value, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryIn(List<String> values) {
            addCriterion("ucountry in", values, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryNotIn(List<String> values) {
            addCriterion("ucountry not in", values, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryBetween(String value1, String value2) {
            addCriterion("ucountry between", value1, value2, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUcountryNotBetween(String value1, String value2) {
            addCriterion("ucountry not between", value1, value2, "ucountry");
            return (Criteria) this;
        }

        public Criteria andUprovinceIsNull() {
            addCriterion("uprovince is null");
            return (Criteria) this;
        }

        public Criteria andUprovinceIsNotNull() {
            addCriterion("uprovince is not null");
            return (Criteria) this;
        }

        public Criteria andUprovinceEqualTo(String value) {
            addCriterion("uprovince =", value, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceNotEqualTo(String value) {
            addCriterion("uprovince <>", value, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceGreaterThan(String value) {
            addCriterion("uprovince >", value, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceGreaterThanOrEqualTo(String value) {
            addCriterion("uprovince >=", value, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceLessThan(String value) {
            addCriterion("uprovince <", value, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceLessThanOrEqualTo(String value) {
            addCriterion("uprovince <=", value, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceLike(String value) {
            addCriterion("uprovince like", value, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceNotLike(String value) {
            addCriterion("uprovince not like", value, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceIn(List<String> values) {
            addCriterion("uprovince in", values, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceNotIn(List<String> values) {
            addCriterion("uprovince not in", values, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceBetween(String value1, String value2) {
            addCriterion("uprovince between", value1, value2, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUprovinceNotBetween(String value1, String value2) {
            addCriterion("uprovince not between", value1, value2, "uprovince");
            return (Criteria) this;
        }

        public Criteria andUcityIsNull() {
            addCriterion("ucity is null");
            return (Criteria) this;
        }

        public Criteria andUcityIsNotNull() {
            addCriterion("ucity is not null");
            return (Criteria) this;
        }

        public Criteria andUcityEqualTo(String value) {
            addCriterion("ucity =", value, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityNotEqualTo(String value) {
            addCriterion("ucity <>", value, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityGreaterThan(String value) {
            addCriterion("ucity >", value, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityGreaterThanOrEqualTo(String value) {
            addCriterion("ucity >=", value, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityLessThan(String value) {
            addCriterion("ucity <", value, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityLessThanOrEqualTo(String value) {
            addCriterion("ucity <=", value, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityLike(String value) {
            addCriterion("ucity like", value, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityNotLike(String value) {
            addCriterion("ucity not like", value, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityIn(List<String> values) {
            addCriterion("ucity in", values, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityNotIn(List<String> values) {
            addCriterion("ucity not in", values, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityBetween(String value1, String value2) {
            addCriterion("ucity between", value1, value2, "ucity");
            return (Criteria) this;
        }

        public Criteria andUcityNotBetween(String value1, String value2) {
            addCriterion("ucity not between", value1, value2, "ucity");
            return (Criteria) this;
        }

        public Criteria andUareaIsNull() {
            addCriterion("uarea is null");
            return (Criteria) this;
        }

        public Criteria andUareaIsNotNull() {
            addCriterion("uarea is not null");
            return (Criteria) this;
        }

        public Criteria andUareaEqualTo(String value) {
            addCriterion("uarea =", value, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaNotEqualTo(String value) {
            addCriterion("uarea <>", value, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaGreaterThan(String value) {
            addCriterion("uarea >", value, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaGreaterThanOrEqualTo(String value) {
            addCriterion("uarea >=", value, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaLessThan(String value) {
            addCriterion("uarea <", value, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaLessThanOrEqualTo(String value) {
            addCriterion("uarea <=", value, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaLike(String value) {
            addCriterion("uarea like", value, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaNotLike(String value) {
            addCriterion("uarea not like", value, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaIn(List<String> values) {
            addCriterion("uarea in", values, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaNotIn(List<String> values) {
            addCriterion("uarea not in", values, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaBetween(String value1, String value2) {
            addCriterion("uarea between", value1, value2, "uarea");
            return (Criteria) this;
        }

        public Criteria andUareaNotBetween(String value1, String value2) {
            addCriterion("uarea not between", value1, value2, "uarea");
            return (Criteria) this;
        }

        public Criteria andUaddressIsNull() {
            addCriterion("uaddress is null");
            return (Criteria) this;
        }

        public Criteria andUaddressIsNotNull() {
            addCriterion("uaddress is not null");
            return (Criteria) this;
        }

        public Criteria andUaddressEqualTo(String value) {
            addCriterion("uaddress =", value, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressNotEqualTo(String value) {
            addCriterion("uaddress <>", value, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressGreaterThan(String value) {
            addCriterion("uaddress >", value, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressGreaterThanOrEqualTo(String value) {
            addCriterion("uaddress >=", value, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressLessThan(String value) {
            addCriterion("uaddress <", value, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressLessThanOrEqualTo(String value) {
            addCriterion("uaddress <=", value, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressLike(String value) {
            addCriterion("uaddress like", value, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressNotLike(String value) {
            addCriterion("uaddress not like", value, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressIn(List<String> values) {
            addCriterion("uaddress in", values, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressNotIn(List<String> values) {
            addCriterion("uaddress not in", values, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressBetween(String value1, String value2) {
            addCriterion("uaddress between", value1, value2, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUaddressNotBetween(String value1, String value2) {
            addCriterion("uaddress not between", value1, value2, "uaddress");
            return (Criteria) this;
        }

        public Criteria andUbnameIsNull() {
            addCriterion("ubname is null");
            return (Criteria) this;
        }

        public Criteria andUbnameIsNotNull() {
            addCriterion("ubname is not null");
            return (Criteria) this;
        }

        public Criteria andUbnameEqualTo(String value) {
            addCriterion("ubname =", value, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameNotEqualTo(String value) {
            addCriterion("ubname <>", value, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameGreaterThan(String value) {
            addCriterion("ubname >", value, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameGreaterThanOrEqualTo(String value) {
            addCriterion("ubname >=", value, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameLessThan(String value) {
            addCriterion("ubname <", value, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameLessThanOrEqualTo(String value) {
            addCriterion("ubname <=", value, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameLike(String value) {
            addCriterion("ubname like", value, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameNotLike(String value) {
            addCriterion("ubname not like", value, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameIn(List<String> values) {
            addCriterion("ubname in", values, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameNotIn(List<String> values) {
            addCriterion("ubname not in", values, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameBetween(String value1, String value2) {
            addCriterion("ubname between", value1, value2, "ubname");
            return (Criteria) this;
        }

        public Criteria andUbnameNotBetween(String value1, String value2) {
            addCriterion("ubname not between", value1, value2, "ubname");
            return (Criteria) this;
        }

        public Criteria andUphonenumIsNull() {
            addCriterion("uphonenum is null");
            return (Criteria) this;
        }

        public Criteria andUphonenumIsNotNull() {
            addCriterion("uphonenum is not null");
            return (Criteria) this;
        }

        public Criteria andUphonenumEqualTo(String value) {
            addCriterion("uphonenum =", value, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumNotEqualTo(String value) {
            addCriterion("uphonenum <>", value, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumGreaterThan(String value) {
            addCriterion("uphonenum >", value, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumGreaterThanOrEqualTo(String value) {
            addCriterion("uphonenum >=", value, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumLessThan(String value) {
            addCriterion("uphonenum <", value, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumLessThanOrEqualTo(String value) {
            addCriterion("uphonenum <=", value, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumLike(String value) {
            addCriterion("uphonenum like", value, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumNotLike(String value) {
            addCriterion("uphonenum not like", value, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumIn(List<String> values) {
            addCriterion("uphonenum in", values, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumNotIn(List<String> values) {
            addCriterion("uphonenum not in", values, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumBetween(String value1, String value2) {
            addCriterion("uphonenum between", value1, value2, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUphonenumNotBetween(String value1, String value2) {
            addCriterion("uphonenum not between", value1, value2, "uphonenum");
            return (Criteria) this;
        }

        public Criteria andUmailIsNull() {
            addCriterion("umail is null");
            return (Criteria) this;
        }

        public Criteria andUmailIsNotNull() {
            addCriterion("umail is not null");
            return (Criteria) this;
        }

        public Criteria andUmailEqualTo(String value) {
            addCriterion("umail =", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotEqualTo(String value) {
            addCriterion("umail <>", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailGreaterThan(String value) {
            addCriterion("umail >", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailGreaterThanOrEqualTo(String value) {
            addCriterion("umail >=", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailLessThan(String value) {
            addCriterion("umail <", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailLessThanOrEqualTo(String value) {
            addCriterion("umail <=", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailLike(String value) {
            addCriterion("umail like", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotLike(String value) {
            addCriterion("umail not like", value, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailIn(List<String> values) {
            addCriterion("umail in", values, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotIn(List<String> values) {
            addCriterion("umail not in", values, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailBetween(String value1, String value2) {
            addCriterion("umail between", value1, value2, "umail");
            return (Criteria) this;
        }

        public Criteria andUmailNotBetween(String value1, String value2) {
            addCriterion("umail not between", value1, value2, "umail");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterionForJDBCDate("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterionForJDBCDate("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterionForJDBCDate("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAdddefaultIsNull() {
            addCriterion("adddefault is null");
            return (Criteria) this;
        }

        public Criteria andAdddefaultIsNotNull() {
            addCriterion("adddefault is not null");
            return (Criteria) this;
        }

        public Criteria andAdddefaultEqualTo(Boolean value) {
            addCriterion("adddefault =", value, "adddefault");
            return (Criteria) this;
        }

        public Criteria andAdddefaultNotEqualTo(Boolean value) {
            addCriterion("adddefault <>", value, "adddefault");
            return (Criteria) this;
        }

        public Criteria andAdddefaultGreaterThan(Boolean value) {
            addCriterion("adddefault >", value, "adddefault");
            return (Criteria) this;
        }

        public Criteria andAdddefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("adddefault >=", value, "adddefault");
            return (Criteria) this;
        }

        public Criteria andAdddefaultLessThan(Boolean value) {
            addCriterion("adddefault <", value, "adddefault");
            return (Criteria) this;
        }

        public Criteria andAdddefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("adddefault <=", value, "adddefault");
            return (Criteria) this;
        }

        public Criteria andAdddefaultIn(List<Boolean> values) {
            addCriterion("adddefault in", values, "adddefault");
            return (Criteria) this;
        }

        public Criteria andAdddefaultNotIn(List<Boolean> values) {
            addCriterion("adddefault not in", values, "adddefault");
            return (Criteria) this;
        }

        public Criteria andAdddefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("adddefault between", value1, value2, "adddefault");
            return (Criteria) this;
        }

        public Criteria andAdddefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("adddefault not between", value1, value2, "adddefault");
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