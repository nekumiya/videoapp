package com.kexie.videoapp.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PraiseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PraiseExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNull() {
            addCriterion("video_id is null");
            return (Criteria) this;
        }

        public Criteria andVideoIdIsNotNull() {
            addCriterion("video_id is not null");
            return (Criteria) this;
        }

        public Criteria andVideoIdEqualTo(Integer value) {
            addCriterion("video_id =", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotEqualTo(Integer value) {
            addCriterion("video_id <>", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThan(Integer value) {
            addCriterion("video_id >", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("video_id >=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThan(Integer value) {
            addCriterion("video_id <", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdLessThanOrEqualTo(Integer value) {
            addCriterion("video_id <=", value, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdIn(List<Integer> values) {
            addCriterion("video_id in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotIn(List<Integer> values) {
            addCriterion("video_id not in", values, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdBetween(Integer value1, Integer value2) {
            addCriterion("video_id between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andVideoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("video_id not between", value1, value2, "videoId");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNull() {
            addCriterion("user_account is null");
            return (Criteria) this;
        }

        public Criteria andUserAccountIsNotNull() {
            addCriterion("user_account is not null");
            return (Criteria) this;
        }

        public Criteria andUserAccountEqualTo(String value) {
            addCriterion("user_account =", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotEqualTo(String value) {
            addCriterion("user_account <>", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThan(String value) {
            addCriterion("user_account >", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
            addCriterion("user_account >=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThan(String value) {
            addCriterion("user_account <", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLessThanOrEqualTo(String value) {
            addCriterion("user_account <=", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountLike(String value) {
            addCriterion("user_account like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotLike(String value) {
            addCriterion("user_account not like", value, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountIn(List<String> values) {
            addCriterion("user_account in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotIn(List<String> values) {
            addCriterion("user_account not in", values, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountBetween(String value1, String value2) {
            addCriterion("user_account between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andUserAccountNotBetween(String value1, String value2) {
            addCriterion("user_account not between", value1, value2, "userAccount");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeIsNull() {
            addCriterion("praise_time is null");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeIsNotNull() {
            addCriterion("praise_time is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeEqualTo(Date value) {
            addCriterion("praise_time =", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeNotEqualTo(Date value) {
            addCriterion("praise_time <>", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeGreaterThan(Date value) {
            addCriterion("praise_time >", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("praise_time >=", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeLessThan(Date value) {
            addCriterion("praise_time <", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeLessThanOrEqualTo(Date value) {
            addCriterion("praise_time <=", value, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeIn(List<Date> values) {
            addCriterion("praise_time in", values, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeNotIn(List<Date> values) {
            addCriterion("praise_time not in", values, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeBetween(Date value1, Date value2) {
            addCriterion("praise_time between", value1, value2, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseTimeNotBetween(Date value1, Date value2) {
            addCriterion("praise_time not between", value1, value2, "praiseTime");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusIsNull() {
            addCriterion("praise_status is null");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusIsNotNull() {
            addCriterion("praise_status is not null");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusEqualTo(String value) {
            addCriterion("praise_status =", value, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusNotEqualTo(String value) {
            addCriterion("praise_status <>", value, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusGreaterThan(String value) {
            addCriterion("praise_status >", value, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("praise_status >=", value, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusLessThan(String value) {
            addCriterion("praise_status <", value, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusLessThanOrEqualTo(String value) {
            addCriterion("praise_status <=", value, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusLike(String value) {
            addCriterion("praise_status like", value, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusNotLike(String value) {
            addCriterion("praise_status not like", value, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusIn(List<String> values) {
            addCriterion("praise_status in", values, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusNotIn(List<String> values) {
            addCriterion("praise_status not in", values, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusBetween(String value1, String value2) {
            addCriterion("praise_status between", value1, value2, "praiseStatus");
            return (Criteria) this;
        }

        public Criteria andPraiseStatusNotBetween(String value1, String value2) {
            addCriterion("praise_status not between", value1, value2, "praiseStatus");
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