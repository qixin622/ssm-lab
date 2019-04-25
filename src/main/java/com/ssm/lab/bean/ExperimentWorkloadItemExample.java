package com.ssm.lab.bean;

import java.util.ArrayList;
import java.util.List;

public class ExperimentWorkloadItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExperimentWorkloadItemExample() {
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

        public Criteria andExperimentWorkloadIdIsNull() {
            addCriterion("experiment_workload_id is null");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdIsNotNull() {
            addCriterion("experiment_workload_id is not null");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdEqualTo(Integer value) {
            addCriterion("experiment_workload_id =", value, "experimentWorkloadId");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdNotEqualTo(Integer value) {
            addCriterion("experiment_workload_id <>", value, "experimentWorkloadId");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdGreaterThan(Integer value) {
            addCriterion("experiment_workload_id >", value, "experimentWorkloadId");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("experiment_workload_id >=", value, "experimentWorkloadId");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdLessThan(Integer value) {
            addCriterion("experiment_workload_id <", value, "experimentWorkloadId");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdLessThanOrEqualTo(Integer value) {
            addCriterion("experiment_workload_id <=", value, "experimentWorkloadId");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdIn(List<Integer> values) {
            addCriterion("experiment_workload_id in", values, "experimentWorkloadId");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdNotIn(List<Integer> values) {
            addCriterion("experiment_workload_id not in", values, "experimentWorkloadId");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdBetween(Integer value1, Integer value2) {
            addCriterion("experiment_workload_id between", value1, value2, "experimentWorkloadId");
            return (Criteria) this;
        }

        public Criteria andExperimentWorkloadIdNotBetween(Integer value1, Integer value2) {
            addCriterion("experiment_workload_id not between", value1, value2, "experimentWorkloadId");
            return (Criteria) this;
        }

        public Criteria andTeacherSnIsNull() {
            addCriterion("teacher_sn is null");
            return (Criteria) this;
        }

        public Criteria andTeacherSnIsNotNull() {
            addCriterion("teacher_sn is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherSnEqualTo(String value) {
            addCriterion("teacher_sn =", value, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnNotEqualTo(String value) {
            addCriterion("teacher_sn <>", value, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnGreaterThan(String value) {
            addCriterion("teacher_sn >", value, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_sn >=", value, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnLessThan(String value) {
            addCriterion("teacher_sn <", value, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnLessThanOrEqualTo(String value) {
            addCriterion("teacher_sn <=", value, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnLike(String value) {
            addCriterion("teacher_sn like", value, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnNotLike(String value) {
            addCriterion("teacher_sn not like", value, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnIn(List<String> values) {
            addCriterion("teacher_sn in", values, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnNotIn(List<String> values) {
            addCriterion("teacher_sn not in", values, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnBetween(String value1, String value2) {
            addCriterion("teacher_sn between", value1, value2, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherSnNotBetween(String value1, String value2) {
            addCriterion("teacher_sn not between", value1, value2, "teacherSn");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateIsNull() {
            addCriterion("teacher_workload_rate is null");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateIsNotNull() {
            addCriterion("teacher_workload_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateEqualTo(Byte value) {
            addCriterion("teacher_workload_rate =", value, "teacherWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateNotEqualTo(Byte value) {
            addCriterion("teacher_workload_rate <>", value, "teacherWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateGreaterThan(Byte value) {
            addCriterion("teacher_workload_rate >", value, "teacherWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateGreaterThanOrEqualTo(Byte value) {
            addCriterion("teacher_workload_rate >=", value, "teacherWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateLessThan(Byte value) {
            addCriterion("teacher_workload_rate <", value, "teacherWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateLessThanOrEqualTo(Byte value) {
            addCriterion("teacher_workload_rate <=", value, "teacherWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateIn(List<Byte> values) {
            addCriterion("teacher_workload_rate in", values, "teacherWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateNotIn(List<Byte> values) {
            addCriterion("teacher_workload_rate not in", values, "teacherWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateBetween(Byte value1, Byte value2) {
            addCriterion("teacher_workload_rate between", value1, value2, "teacherWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadRateNotBetween(Byte value1, Byte value2) {
            addCriterion("teacher_workload_rate not between", value1, value2, "teacherWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadIsNull() {
            addCriterion("teacher_workload is null");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadIsNotNull() {
            addCriterion("teacher_workload is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadEqualTo(Double value) {
            addCriterion("teacher_workload =", value, "teacherWorkload");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadNotEqualTo(Double value) {
            addCriterion("teacher_workload <>", value, "teacherWorkload");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadGreaterThan(Double value) {
            addCriterion("teacher_workload >", value, "teacherWorkload");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadGreaterThanOrEqualTo(Double value) {
            addCriterion("teacher_workload >=", value, "teacherWorkload");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadLessThan(Double value) {
            addCriterion("teacher_workload <", value, "teacherWorkload");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadLessThanOrEqualTo(Double value) {
            addCriterion("teacher_workload <=", value, "teacherWorkload");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadIn(List<Double> values) {
            addCriterion("teacher_workload in", values, "teacherWorkload");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadNotIn(List<Double> values) {
            addCriterion("teacher_workload not in", values, "teacherWorkload");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadBetween(Double value1, Double value2) {
            addCriterion("teacher_workload between", value1, value2, "teacherWorkload");
            return (Criteria) this;
        }

        public Criteria andTeacherWorkloadNotBetween(Double value1, Double value2) {
            addCriterion("teacher_workload not between", value1, value2, "teacherWorkload");
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