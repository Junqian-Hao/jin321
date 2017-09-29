package com.jin321.pl.model;

import java.util.ArrayList;
import java.util.List;

public class DistrictExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DistrictExample() {
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

        public Criteria andCIdIsNull() {
            addCriterion("c_id is null");
            return (Criteria) this;
        }

        public Criteria andCIdIsNotNull() {
            addCriterion("c_id is not null");
            return (Criteria) this;
        }

        public Criteria andCIdEqualTo(Integer value) {
            addCriterion("c_id =", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotEqualTo(Integer value) {
            addCriterion("c_id <>", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThan(Integer value) {
            addCriterion("c_id >", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_id >=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThan(Integer value) {
            addCriterion("c_id <", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_id <=", value, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdIn(List<Integer> values) {
            addCriterion("c_id in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotIn(List<Integer> values) {
            addCriterion("c_id not in", values, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdBetween(Integer value1, Integer value2) {
            addCriterion("c_id between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_id not between", value1, value2, "cId");
            return (Criteria) this;
        }

        public Criteria andCPaIdIsNull() {
            addCriterion("c_pa_id is null");
            return (Criteria) this;
        }

        public Criteria andCPaIdIsNotNull() {
            addCriterion("c_pa_id is not null");
            return (Criteria) this;
        }

        public Criteria andCPaIdEqualTo(Integer value) {
            addCriterion("c_pa_id =", value, "cPaId");
            return (Criteria) this;
        }

        public Criteria andCPaIdNotEqualTo(Integer value) {
            addCriterion("c_pa_id <>", value, "cPaId");
            return (Criteria) this;
        }

        public Criteria andCPaIdGreaterThan(Integer value) {
            addCriterion("c_pa_id >", value, "cPaId");
            return (Criteria) this;
        }

        public Criteria andCPaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("c_pa_id >=", value, "cPaId");
            return (Criteria) this;
        }

        public Criteria andCPaIdLessThan(Integer value) {
            addCriterion("c_pa_id <", value, "cPaId");
            return (Criteria) this;
        }

        public Criteria andCPaIdLessThanOrEqualTo(Integer value) {
            addCriterion("c_pa_id <=", value, "cPaId");
            return (Criteria) this;
        }

        public Criteria andCPaIdIn(List<Integer> values) {
            addCriterion("c_pa_id in", values, "cPaId");
            return (Criteria) this;
        }

        public Criteria andCPaIdNotIn(List<Integer> values) {
            addCriterion("c_pa_id not in", values, "cPaId");
            return (Criteria) this;
        }

        public Criteria andCPaIdBetween(Integer value1, Integer value2) {
            addCriterion("c_pa_id between", value1, value2, "cPaId");
            return (Criteria) this;
        }

        public Criteria andCPaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("c_pa_id not between", value1, value2, "cPaId");
            return (Criteria) this;
        }

        public Criteria andCLevelIsNull() {
            addCriterion("c_level is null");
            return (Criteria) this;
        }

        public Criteria andCLevelIsNotNull() {
            addCriterion("c_level is not null");
            return (Criteria) this;
        }

        public Criteria andCLevelEqualTo(Byte value) {
            addCriterion("c_level =", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelNotEqualTo(Byte value) {
            addCriterion("c_level <>", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelGreaterThan(Byte value) {
            addCriterion("c_level >", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelGreaterThanOrEqualTo(Byte value) {
            addCriterion("c_level >=", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelLessThan(Byte value) {
            addCriterion("c_level <", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelLessThanOrEqualTo(Byte value) {
            addCriterion("c_level <=", value, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelIn(List<Byte> values) {
            addCriterion("c_level in", values, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelNotIn(List<Byte> values) {
            addCriterion("c_level not in", values, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelBetween(Byte value1, Byte value2) {
            addCriterion("c_level between", value1, value2, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCLevelNotBetween(Byte value1, Byte value2) {
            addCriterion("c_level not between", value1, value2, "cLevel");
            return (Criteria) this;
        }

        public Criteria andCNameIsNull() {
            addCriterion("c_name is null");
            return (Criteria) this;
        }

        public Criteria andCNameIsNotNull() {
            addCriterion("c_name is not null");
            return (Criteria) this;
        }

        public Criteria andCNameEqualTo(String value) {
            addCriterion("c_name =", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotEqualTo(String value) {
            addCriterion("c_name <>", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThan(String value) {
            addCriterion("c_name >", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_name >=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThan(String value) {
            addCriterion("c_name <", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLessThanOrEqualTo(String value) {
            addCriterion("c_name <=", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameLike(String value) {
            addCriterion("c_name like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotLike(String value) {
            addCriterion("c_name not like", value, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameIn(List<String> values) {
            addCriterion("c_name in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotIn(List<String> values) {
            addCriterion("c_name not in", values, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameBetween(String value1, String value2) {
            addCriterion("c_name between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCNameNotBetween(String value1, String value2) {
            addCriterion("c_name not between", value1, value2, "cName");
            return (Criteria) this;
        }

        public Criteria andCLonIsNull() {
            addCriterion("c_lon is null");
            return (Criteria) this;
        }

        public Criteria andCLonIsNotNull() {
            addCriterion("c_lon is not null");
            return (Criteria) this;
        }

        public Criteria andCLonEqualTo(Double value) {
            addCriterion("c_lon =", value, "cLon");
            return (Criteria) this;
        }

        public Criteria andCLonNotEqualTo(Double value) {
            addCriterion("c_lon <>", value, "cLon");
            return (Criteria) this;
        }

        public Criteria andCLonGreaterThan(Double value) {
            addCriterion("c_lon >", value, "cLon");
            return (Criteria) this;
        }

        public Criteria andCLonGreaterThanOrEqualTo(Double value) {
            addCriterion("c_lon >=", value, "cLon");
            return (Criteria) this;
        }

        public Criteria andCLonLessThan(Double value) {
            addCriterion("c_lon <", value, "cLon");
            return (Criteria) this;
        }

        public Criteria andCLonLessThanOrEqualTo(Double value) {
            addCriterion("c_lon <=", value, "cLon");
            return (Criteria) this;
        }

        public Criteria andCLonIn(List<Double> values) {
            addCriterion("c_lon in", values, "cLon");
            return (Criteria) this;
        }

        public Criteria andCLonNotIn(List<Double> values) {
            addCriterion("c_lon not in", values, "cLon");
            return (Criteria) this;
        }

        public Criteria andCLonBetween(Double value1, Double value2) {
            addCriterion("c_lon between", value1, value2, "cLon");
            return (Criteria) this;
        }

        public Criteria andCLonNotBetween(Double value1, Double value2) {
            addCriterion("c_lon not between", value1, value2, "cLon");
            return (Criteria) this;
        }

        public Criteria andCLatIsNull() {
            addCriterion("c_lat is null");
            return (Criteria) this;
        }

        public Criteria andCLatIsNotNull() {
            addCriterion("c_lat is not null");
            return (Criteria) this;
        }

        public Criteria andCLatEqualTo(Double value) {
            addCriterion("c_lat =", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatNotEqualTo(Double value) {
            addCriterion("c_lat <>", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatGreaterThan(Double value) {
            addCriterion("c_lat >", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatGreaterThanOrEqualTo(Double value) {
            addCriterion("c_lat >=", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatLessThan(Double value) {
            addCriterion("c_lat <", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatLessThanOrEqualTo(Double value) {
            addCriterion("c_lat <=", value, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatIn(List<Double> values) {
            addCriterion("c_lat in", values, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatNotIn(List<Double> values) {
            addCriterion("c_lat not in", values, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatBetween(Double value1, Double value2) {
            addCriterion("c_lat between", value1, value2, "cLat");
            return (Criteria) this;
        }

        public Criteria andCLatNotBetween(Double value1, Double value2) {
            addCriterion("c_lat not between", value1, value2, "cLat");
            return (Criteria) this;
        }

        public Criteria andCAliasIsNull() {
            addCriterion("c_alias is null");
            return (Criteria) this;
        }

        public Criteria andCAliasIsNotNull() {
            addCriterion("c_alias is not null");
            return (Criteria) this;
        }

        public Criteria andCAliasEqualTo(String value) {
            addCriterion("c_alias =", value, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasNotEqualTo(String value) {
            addCriterion("c_alias <>", value, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasGreaterThan(String value) {
            addCriterion("c_alias >", value, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasGreaterThanOrEqualTo(String value) {
            addCriterion("c_alias >=", value, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasLessThan(String value) {
            addCriterion("c_alias <", value, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasLessThanOrEqualTo(String value) {
            addCriterion("c_alias <=", value, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasLike(String value) {
            addCriterion("c_alias like", value, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasNotLike(String value) {
            addCriterion("c_alias not like", value, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasIn(List<String> values) {
            addCriterion("c_alias in", values, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasNotIn(List<String> values) {
            addCriterion("c_alias not in", values, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasBetween(String value1, String value2) {
            addCriterion("c_alias between", value1, value2, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCAliasNotBetween(String value1, String value2) {
            addCriterion("c_alias not between", value1, value2, "cAlias");
            return (Criteria) this;
        }

        public Criteria andCSpellIsNull() {
            addCriterion("c_spell is null");
            return (Criteria) this;
        }

        public Criteria andCSpellIsNotNull() {
            addCriterion("c_spell is not null");
            return (Criteria) this;
        }

        public Criteria andCSpellEqualTo(String value) {
            addCriterion("c_spell =", value, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellNotEqualTo(String value) {
            addCriterion("c_spell <>", value, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellGreaterThan(String value) {
            addCriterion("c_spell >", value, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellGreaterThanOrEqualTo(String value) {
            addCriterion("c_spell >=", value, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellLessThan(String value) {
            addCriterion("c_spell <", value, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellLessThanOrEqualTo(String value) {
            addCriterion("c_spell <=", value, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellLike(String value) {
            addCriterion("c_spell like", value, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellNotLike(String value) {
            addCriterion("c_spell not like", value, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellIn(List<String> values) {
            addCriterion("c_spell in", values, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellNotIn(List<String> values) {
            addCriterion("c_spell not in", values, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellBetween(String value1, String value2) {
            addCriterion("c_spell between", value1, value2, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSpellNotBetween(String value1, String value2) {
            addCriterion("c_spell not between", value1, value2, "cSpell");
            return (Criteria) this;
        }

        public Criteria andCSzmIsNull() {
            addCriterion("c_szm is null");
            return (Criteria) this;
        }

        public Criteria andCSzmIsNotNull() {
            addCriterion("c_szm is not null");
            return (Criteria) this;
        }

        public Criteria andCSzmEqualTo(String value) {
            addCriterion("c_szm =", value, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmNotEqualTo(String value) {
            addCriterion("c_szm <>", value, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmGreaterThan(String value) {
            addCriterion("c_szm >", value, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmGreaterThanOrEqualTo(String value) {
            addCriterion("c_szm >=", value, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmLessThan(String value) {
            addCriterion("c_szm <", value, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmLessThanOrEqualTo(String value) {
            addCriterion("c_szm <=", value, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmLike(String value) {
            addCriterion("c_szm like", value, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmNotLike(String value) {
            addCriterion("c_szm not like", value, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmIn(List<String> values) {
            addCriterion("c_szm in", values, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmNotIn(List<String> values) {
            addCriterion("c_szm not in", values, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmBetween(String value1, String value2) {
            addCriterion("c_szm between", value1, value2, "cSzm");
            return (Criteria) this;
        }

        public Criteria andCSzmNotBetween(String value1, String value2) {
            addCriterion("c_szm not between", value1, value2, "cSzm");
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