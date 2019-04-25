package com.ssm.lab.bean;

import java.util.ArrayList;
import java.util.List;

public class PracticeWorkloadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PracticeWorkloadExample() {
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

        public Criteria andTermIsNull() {
            addCriterion("term is null");
            return (Criteria) this;
        }

        public Criteria andTermIsNotNull() {
            addCriterion("term is not null");
            return (Criteria) this;
        }

        public Criteria andTermEqualTo(String value) {
            addCriterion("term =", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotEqualTo(String value) {
            addCriterion("term <>", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThan(String value) {
            addCriterion("term >", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermGreaterThanOrEqualTo(String value) {
            addCriterion("term >=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThan(String value) {
            addCriterion("term <", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLessThanOrEqualTo(String value) {
            addCriterion("term <=", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermLike(String value) {
            addCriterion("term like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotLike(String value) {
            addCriterion("term not like", value, "term");
            return (Criteria) this;
        }

        public Criteria andTermIn(List<String> values) {
            addCriterion("term in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotIn(List<String> values) {
            addCriterion("term not in", values, "term");
            return (Criteria) this;
        }

        public Criteria andTermBetween(String value1, String value2) {
            addCriterion("term between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andTermNotBetween(String value1, String value2) {
            addCriterion("term not between", value1, value2, "term");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeIsNull() {
            addCriterion("workload_type is null");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeIsNotNull() {
            addCriterion("workload_type is not null");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeEqualTo(String value) {
            addCriterion("workload_type =", value, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeNotEqualTo(String value) {
            addCriterion("workload_type <>", value, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeGreaterThan(String value) {
            addCriterion("workload_type >", value, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeGreaterThanOrEqualTo(String value) {
            addCriterion("workload_type >=", value, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeLessThan(String value) {
            addCriterion("workload_type <", value, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeLessThanOrEqualTo(String value) {
            addCriterion("workload_type <=", value, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeLike(String value) {
            addCriterion("workload_type like", value, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeNotLike(String value) {
            addCriterion("workload_type not like", value, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeIn(List<String> values) {
            addCriterion("workload_type in", values, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeNotIn(List<String> values) {
            addCriterion("workload_type not in", values, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeBetween(String value1, String value2) {
            addCriterion("workload_type between", value1, value2, "workloadType");
            return (Criteria) this;
        }

        public Criteria andWorkloadTypeNotBetween(String value1, String value2) {
            addCriterion("workload_type not between", value1, value2, "workloadType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeIsNull() {
            addCriterion("practice_type is null");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeIsNotNull() {
            addCriterion("practice_type is not null");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeEqualTo(String value) {
            addCriterion("practice_type =", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeNotEqualTo(String value) {
            addCriterion("practice_type <>", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeGreaterThan(String value) {
            addCriterion("practice_type >", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("practice_type >=", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeLessThan(String value) {
            addCriterion("practice_type <", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeLessThanOrEqualTo(String value) {
            addCriterion("practice_type <=", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeLike(String value) {
            addCriterion("practice_type like", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeNotLike(String value) {
            addCriterion("practice_type not like", value, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeIn(List<String> values) {
            addCriterion("practice_type in", values, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeNotIn(List<String> values) {
            addCriterion("practice_type not in", values, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeBetween(String value1, String value2) {
            addCriterion("practice_type between", value1, value2, "practiceType");
            return (Criteria) this;
        }

        public Criteria andPracticeTypeNotBetween(String value1, String value2) {
            addCriterion("practice_type not between", value1, value2, "practiceType");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyIsNull() {
            addCriterion("workload_property is null");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyIsNotNull() {
            addCriterion("workload_property is not null");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyEqualTo(String value) {
            addCriterion("workload_property =", value, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyNotEqualTo(String value) {
            addCriterion("workload_property <>", value, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyGreaterThan(String value) {
            addCriterion("workload_property >", value, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("workload_property >=", value, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyLessThan(String value) {
            addCriterion("workload_property <", value, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyLessThanOrEqualTo(String value) {
            addCriterion("workload_property <=", value, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyLike(String value) {
            addCriterion("workload_property like", value, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyNotLike(String value) {
            addCriterion("workload_property not like", value, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyIn(List<String> values) {
            addCriterion("workload_property in", values, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyNotIn(List<String> values) {
            addCriterion("workload_property not in", values, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyBetween(String value1, String value2) {
            addCriterion("workload_property between", value1, value2, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andWorkloadPropertyNotBetween(String value1, String value2) {
            addCriterion("workload_property not between", value1, value2, "workloadProperty");
            return (Criteria) this;
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersIsNull() {
            addCriterion("week_numbers is null");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersIsNotNull() {
            addCriterion("week_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersEqualTo(Double value) {
            addCriterion("week_numbers =", value, "weekNumbers");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersNotEqualTo(Double value) {
            addCriterion("week_numbers <>", value, "weekNumbers");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersGreaterThan(Double value) {
            addCriterion("week_numbers >", value, "weekNumbers");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersGreaterThanOrEqualTo(Double value) {
            addCriterion("week_numbers >=", value, "weekNumbers");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersLessThan(Double value) {
            addCriterion("week_numbers <", value, "weekNumbers");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersLessThanOrEqualTo(Double value) {
            addCriterion("week_numbers <=", value, "weekNumbers");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersIn(List<Double> values) {
            addCriterion("week_numbers in", values, "weekNumbers");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersNotIn(List<Double> values) {
            addCriterion("week_numbers not in", values, "weekNumbers");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersBetween(Double value1, Double value2) {
            addCriterion("week_numbers between", value1, value2, "weekNumbers");
            return (Criteria) this;
        }

        public Criteria andWeekNumbersNotBetween(Double value1, Double value2) {
            addCriterion("week_numbers not between", value1, value2, "weekNumbers");
            return (Criteria) this;
        }

        public Criteria andStuNumbersIsNull() {
            addCriterion("stu_numbers is null");
            return (Criteria) this;
        }

        public Criteria andStuNumbersIsNotNull() {
            addCriterion("stu_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andStuNumbersEqualTo(Integer value) {
            addCriterion("stu_numbers =", value, "stuNumbers");
            return (Criteria) this;
        }

        public Criteria andStuNumbersNotEqualTo(Integer value) {
            addCriterion("stu_numbers <>", value, "stuNumbers");
            return (Criteria) this;
        }

        public Criteria andStuNumbersGreaterThan(Integer value) {
            addCriterion("stu_numbers >", value, "stuNumbers");
            return (Criteria) this;
        }

        public Criteria andStuNumbersGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_numbers >=", value, "stuNumbers");
            return (Criteria) this;
        }

        public Criteria andStuNumbersLessThan(Integer value) {
            addCriterion("stu_numbers <", value, "stuNumbers");
            return (Criteria) this;
        }

        public Criteria andStuNumbersLessThanOrEqualTo(Integer value) {
            addCriterion("stu_numbers <=", value, "stuNumbers");
            return (Criteria) this;
        }

        public Criteria andStuNumbersIn(List<Integer> values) {
            addCriterion("stu_numbers in", values, "stuNumbers");
            return (Criteria) this;
        }

        public Criteria andStuNumbersNotIn(List<Integer> values) {
            addCriterion("stu_numbers not in", values, "stuNumbers");
            return (Criteria) this;
        }

        public Criteria andStuNumbersBetween(Integer value1, Integer value2) {
            addCriterion("stu_numbers between", value1, value2, "stuNumbers");
            return (Criteria) this;
        }

        public Criteria andStuNumbersNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_numbers not between", value1, value2, "stuNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersIsNull() {
            addCriterion("class_numbers is null");
            return (Criteria) this;
        }

        public Criteria andClassNumbersIsNotNull() {
            addCriterion("class_numbers is not null");
            return (Criteria) this;
        }

        public Criteria andClassNumbersEqualTo(Double value) {
            addCriterion("class_numbers =", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersNotEqualTo(Double value) {
            addCriterion("class_numbers <>", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersGreaterThan(Double value) {
            addCriterion("class_numbers >", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersGreaterThanOrEqualTo(Double value) {
            addCriterion("class_numbers >=", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersLessThan(Double value) {
            addCriterion("class_numbers <", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersLessThanOrEqualTo(Double value) {
            addCriterion("class_numbers <=", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersIn(List<Double> values) {
            addCriterion("class_numbers in", values, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersNotIn(List<Double> values) {
            addCriterion("class_numbers not in", values, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersBetween(Double value1, Double value2) {
            addCriterion("class_numbers between", value1, value2, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersNotBetween(Double value1, Double value2) {
            addCriterion("class_numbers not between", value1, value2, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadIsNull() {
            addCriterion("total_workload is null");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadIsNotNull() {
            addCriterion("total_workload is not null");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadEqualTo(Double value) {
            addCriterion("total_workload =", value, "totalWorkload");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadNotEqualTo(Double value) {
            addCriterion("total_workload <>", value, "totalWorkload");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadGreaterThan(Double value) {
            addCriterion("total_workload >", value, "totalWorkload");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadGreaterThanOrEqualTo(Double value) {
            addCriterion("total_workload >=", value, "totalWorkload");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadLessThan(Double value) {
            addCriterion("total_workload <", value, "totalWorkload");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadLessThanOrEqualTo(Double value) {
            addCriterion("total_workload <=", value, "totalWorkload");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadIn(List<Double> values) {
            addCriterion("total_workload in", values, "totalWorkload");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadNotIn(List<Double> values) {
            addCriterion("total_workload not in", values, "totalWorkload");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadBetween(Double value1, Double value2) {
            addCriterion("total_workload between", value1, value2, "totalWorkload");
            return (Criteria) this;
        }

        public Criteria andTotalWorkloadNotBetween(Double value1, Double value2) {
            addCriterion("total_workload not between", value1, value2, "totalWorkload");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateIsNull() {
            addCriterion("pre_workload_rate is null");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateIsNotNull() {
            addCriterion("pre_workload_rate is not null");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateEqualTo(Byte value) {
            addCriterion("pre_workload_rate =", value, "preWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateNotEqualTo(Byte value) {
            addCriterion("pre_workload_rate <>", value, "preWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateGreaterThan(Byte value) {
            addCriterion("pre_workload_rate >", value, "preWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateGreaterThanOrEqualTo(Byte value) {
            addCriterion("pre_workload_rate >=", value, "preWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateLessThan(Byte value) {
            addCriterion("pre_workload_rate <", value, "preWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateLessThanOrEqualTo(Byte value) {
            addCriterion("pre_workload_rate <=", value, "preWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateIn(List<Byte> values) {
            addCriterion("pre_workload_rate in", values, "preWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateNotIn(List<Byte> values) {
            addCriterion("pre_workload_rate not in", values, "preWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateBetween(Byte value1, Byte value2) {
            addCriterion("pre_workload_rate between", value1, value2, "preWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadRateNotBetween(Byte value1, Byte value2) {
            addCriterion("pre_workload_rate not between", value1, value2, "preWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadIsNull() {
            addCriterion("pre_workload is null");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadIsNotNull() {
            addCriterion("pre_workload is not null");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadEqualTo(Double value) {
            addCriterion("pre_workload =", value, "preWorkload");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadNotEqualTo(Double value) {
            addCriterion("pre_workload <>", value, "preWorkload");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadGreaterThan(Double value) {
            addCriterion("pre_workload >", value, "preWorkload");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadGreaterThanOrEqualTo(Double value) {
            addCriterion("pre_workload >=", value, "preWorkload");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadLessThan(Double value) {
            addCriterion("pre_workload <", value, "preWorkload");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadLessThanOrEqualTo(Double value) {
            addCriterion("pre_workload <=", value, "preWorkload");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadIn(List<Double> values) {
            addCriterion("pre_workload in", values, "preWorkload");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadNotIn(List<Double> values) {
            addCriterion("pre_workload not in", values, "preWorkload");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadBetween(Double value1, Double value2) {
            addCriterion("pre_workload between", value1, value2, "preWorkload");
            return (Criteria) this;
        }

        public Criteria andPreWorkloadNotBetween(Double value1, Double value2) {
            addCriterion("pre_workload not between", value1, value2, "preWorkload");
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