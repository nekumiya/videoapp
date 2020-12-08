package com.kexie.videoapp.mbg.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttentionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AttentionExample() {
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

        public Criteria andFollowAccountIsNull() {
            addCriterion("follow_account is null");
            return (Criteria) this;
        }

        public Criteria andFollowAccountIsNotNull() {
            addCriterion("follow_account is not null");
            return (Criteria) this;
        }

        public Criteria andFollowAccountEqualTo(String value) {
            addCriterion("follow_account =", value, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountNotEqualTo(String value) {
            addCriterion("follow_account <>", value, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountGreaterThan(String value) {
            addCriterion("follow_account >", value, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountGreaterThanOrEqualTo(String value) {
            addCriterion("follow_account >=", value, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountLessThan(String value) {
            addCriterion("follow_account <", value, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountLessThanOrEqualTo(String value) {
            addCriterion("follow_account <=", value, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountLike(String value) {
            addCriterion("follow_account like", value, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountNotLike(String value) {
            addCriterion("follow_account not like", value, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountIn(List<String> values) {
            addCriterion("follow_account in", values, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountNotIn(List<String> values) {
            addCriterion("follow_account not in", values, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountBetween(String value1, String value2) {
            addCriterion("follow_account between", value1, value2, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFollowAccountNotBetween(String value1, String value2) {
            addCriterion("follow_account not between", value1, value2, "followAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountIsNull() {
            addCriterion("fans_account is null");
            return (Criteria) this;
        }

        public Criteria andFansAccountIsNotNull() {
            addCriterion("fans_account is not null");
            return (Criteria) this;
        }

        public Criteria andFansAccountEqualTo(String value) {
            addCriterion("fans_account =", value, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountNotEqualTo(String value) {
            addCriterion("fans_account <>", value, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountGreaterThan(String value) {
            addCriterion("fans_account >", value, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountGreaterThanOrEqualTo(String value) {
            addCriterion("fans_account >=", value, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountLessThan(String value) {
            addCriterion("fans_account <", value, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountLessThanOrEqualTo(String value) {
            addCriterion("fans_account <=", value, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountLike(String value) {
            addCriterion("fans_account like", value, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountNotLike(String value) {
            addCriterion("fans_account not like", value, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountIn(List<String> values) {
            addCriterion("fans_account in", values, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountNotIn(List<String> values) {
            addCriterion("fans_account not in", values, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountBetween(String value1, String value2) {
            addCriterion("fans_account between", value1, value2, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andFansAccountNotBetween(String value1, String value2) {
            addCriterion("fans_account not between", value1, value2, "fansAccount");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeIsNull() {
            addCriterion("attention_time is null");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeIsNotNull() {
            addCriterion("attention_time is not null");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeEqualTo(Date value) {
            addCriterion("attention_time =", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeNotEqualTo(Date value) {
            addCriterion("attention_time <>", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeGreaterThan(Date value) {
            addCriterion("attention_time >", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("attention_time >=", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeLessThan(Date value) {
            addCriterion("attention_time <", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeLessThanOrEqualTo(Date value) {
            addCriterion("attention_time <=", value, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeIn(List<Date> values) {
            addCriterion("attention_time in", values, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeNotIn(List<Date> values) {
            addCriterion("attention_time not in", values, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeBetween(Date value1, Date value2) {
            addCriterion("attention_time between", value1, value2, "attentionTime");
            return (Criteria) this;
        }

        public Criteria andAttentionTimeNotBetween(Date value1, Date value2) {
            addCriterion("attention_time not between", value1, value2, "attentionTime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
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