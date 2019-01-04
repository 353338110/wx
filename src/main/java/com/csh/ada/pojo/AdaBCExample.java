package com.csh.ada.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdaBCExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    public AdaBCExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
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

        public Criteria andAdaidIsNull() {
            addCriterion("adaId is null");
            return (Criteria) this;
        }

        public Criteria andAdaidIsNotNull() {
            addCriterion("adaId is not null");
            return (Criteria) this;
        }

        public Criteria andAdaidEqualTo(String value) {
            addCriterion("adaId =", value, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidNotEqualTo(String value) {
            addCriterion("adaId <>", value, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidGreaterThan(String value) {
            addCriterion("adaId >", value, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidGreaterThanOrEqualTo(String value) {
            addCriterion("adaId >=", value, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidLessThan(String value) {
            addCriterion("adaId <", value, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidLessThanOrEqualTo(String value) {
            addCriterion("adaId <=", value, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidLike(String value) {
            addCriterion("adaId like", value, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidNotLike(String value) {
            addCriterion("adaId not like", value, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidIn(List<String> values) {
            addCriterion("adaId in", values, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidNotIn(List<String> values) {
            addCriterion("adaId not in", values, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidBetween(String value1, String value2) {
            addCriterion("adaId between", value1, value2, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdaidNotBetween(String value1, String value2) {
            addCriterion("adaId not between", value1, value2, "adaid");
            return (Criteria) this;
        }

        public Criteria andAdacodeIsNull() {
            addCriterion("adaCode is null");
            return (Criteria) this;
        }

        public Criteria andAdacodeIsNotNull() {
            addCriterion("adaCode is not null");
            return (Criteria) this;
        }

        public Criteria andAdacodeEqualTo(Integer value) {
            addCriterion("adaCode =", value, "adacode");
            return (Criteria) this;
        }

        public Criteria andAdacodeNotEqualTo(Integer value) {
            addCriterion("adaCode <>", value, "adacode");
            return (Criteria) this;
        }

        public Criteria andAdacodeGreaterThan(Integer value) {
            addCriterion("adaCode >", value, "adacode");
            return (Criteria) this;
        }

        public Criteria andAdacodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("adaCode >=", value, "adacode");
            return (Criteria) this;
        }

        public Criteria andAdacodeLessThan(Integer value) {
            addCriterion("adaCode <", value, "adacode");
            return (Criteria) this;
        }

        public Criteria andAdacodeLessThanOrEqualTo(Integer value) {
            addCriterion("adaCode <=", value, "adacode");
            return (Criteria) this;
        }

        public Criteria andAdacodeIn(List<Integer> values) {
            addCriterion("adaCode in", values, "adacode");
            return (Criteria) this;
        }

        public Criteria andAdacodeNotIn(List<Integer> values) {
            addCriterion("adaCode not in", values, "adacode");
            return (Criteria) this;
        }

        public Criteria andAdacodeBetween(Integer value1, Integer value2) {
            addCriterion("adaCode between", value1, value2, "adacode");
            return (Criteria) this;
        }

        public Criteria andAdacodeNotBetween(Integer value1, Integer value2) {
            addCriterion("adaCode not between", value1, value2, "adacode");
            return (Criteria) this;
        }

        public Criteria andAdauidIsNull() {
            addCriterion("adaUid is null");
            return (Criteria) this;
        }

        public Criteria andAdauidIsNotNull() {
            addCriterion("adaUid is not null");
            return (Criteria) this;
        }

        public Criteria andAdauidEqualTo(String value) {
            addCriterion("adaUid =", value, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidNotEqualTo(String value) {
            addCriterion("adaUid <>", value, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidGreaterThan(String value) {
            addCriterion("adaUid >", value, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidGreaterThanOrEqualTo(String value) {
            addCriterion("adaUid >=", value, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidLessThan(String value) {
            addCriterion("adaUid <", value, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidLessThanOrEqualTo(String value) {
            addCriterion("adaUid <=", value, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidLike(String value) {
            addCriterion("adaUid like", value, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidNotLike(String value) {
            addCriterion("adaUid not like", value, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidIn(List<String> values) {
            addCriterion("adaUid in", values, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidNotIn(List<String> values) {
            addCriterion("adaUid not in", values, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidBetween(String value1, String value2) {
            addCriterion("adaUid between", value1, value2, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdauidNotBetween(String value1, String value2) {
            addCriterion("adaUid not between", value1, value2, "adauid");
            return (Criteria) this;
        }

        public Criteria andAdanameIsNull() {
            addCriterion("adaName is null");
            return (Criteria) this;
        }

        public Criteria andAdanameIsNotNull() {
            addCriterion("adaName is not null");
            return (Criteria) this;
        }

        public Criteria andAdanameEqualTo(String value) {
            addCriterion("adaName =", value, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameNotEqualTo(String value) {
            addCriterion("adaName <>", value, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameGreaterThan(String value) {
            addCriterion("adaName >", value, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameGreaterThanOrEqualTo(String value) {
            addCriterion("adaName >=", value, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameLessThan(String value) {
            addCriterion("adaName <", value, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameLessThanOrEqualTo(String value) {
            addCriterion("adaName <=", value, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameLike(String value) {
            addCriterion("adaName like", value, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameNotLike(String value) {
            addCriterion("adaName not like", value, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameIn(List<String> values) {
            addCriterion("adaName in", values, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameNotIn(List<String> values) {
            addCriterion("adaName not in", values, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameBetween(String value1, String value2) {
            addCriterion("adaName between", value1, value2, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdanameNotBetween(String value1, String value2) {
            addCriterion("adaName not between", value1, value2, "adaname");
            return (Criteria) this;
        }

        public Criteria andAdaipIsNull() {
            addCriterion("adaIP is null");
            return (Criteria) this;
        }

        public Criteria andAdaipIsNotNull() {
            addCriterion("adaIP is not null");
            return (Criteria) this;
        }

        public Criteria andAdaipEqualTo(String value) {
            addCriterion("adaIP =", value, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipNotEqualTo(String value) {
            addCriterion("adaIP <>", value, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipGreaterThan(String value) {
            addCriterion("adaIP >", value, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipGreaterThanOrEqualTo(String value) {
            addCriterion("adaIP >=", value, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipLessThan(String value) {
            addCriterion("adaIP <", value, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipLessThanOrEqualTo(String value) {
            addCriterion("adaIP <=", value, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipLike(String value) {
            addCriterion("adaIP like", value, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipNotLike(String value) {
            addCriterion("adaIP not like", value, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipIn(List<String> values) {
            addCriterion("adaIP in", values, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipNotIn(List<String> values) {
            addCriterion("adaIP not in", values, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipBetween(String value1, String value2) {
            addCriterion("adaIP between", value1, value2, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaipNotBetween(String value1, String value2) {
            addCriterion("adaIP not between", value1, value2, "adaip");
            return (Criteria) this;
        }

        public Criteria andAdaportIsNull() {
            addCriterion("adaPort is null");
            return (Criteria) this;
        }

        public Criteria andAdaportIsNotNull() {
            addCriterion("adaPort is not null");
            return (Criteria) this;
        }

        public Criteria andAdaportEqualTo(String value) {
            addCriterion("adaPort =", value, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportNotEqualTo(String value) {
            addCriterion("adaPort <>", value, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportGreaterThan(String value) {
            addCriterion("adaPort >", value, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportGreaterThanOrEqualTo(String value) {
            addCriterion("adaPort >=", value, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportLessThan(String value) {
            addCriterion("adaPort <", value, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportLessThanOrEqualTo(String value) {
            addCriterion("adaPort <=", value, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportLike(String value) {
            addCriterion("adaPort like", value, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportNotLike(String value) {
            addCriterion("adaPort not like", value, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportIn(List<String> values) {
            addCriterion("adaPort in", values, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportNotIn(List<String> values) {
            addCriterion("adaPort not in", values, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportBetween(String value1, String value2) {
            addCriterion("adaPort between", value1, value2, "adaport");
            return (Criteria) this;
        }

        public Criteria andAdaportNotBetween(String value1, String value2) {
            addCriterion("adaPort not between", value1, value2, "adaport");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ada
     *
     * @mbggenerated do_not_delete_during_merge Fri Jan 04 22:43:50 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ada
     *
     * @mbggenerated Fri Jan 04 22:43:50 CST 2019
     */
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