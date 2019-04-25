package com.ssm.lab.bean;

import java.util.ArrayList;
import java.util.List;

public class ExperimentWorkloadExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExperimentWorkloadExample() {
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

        public Criteria andClassesIsNull() {
            addCriterion("classes is null");
            return (Criteria) this;
        }

        public Criteria andClassesIsNotNull() {
            addCriterion("classes is not null");
            return (Criteria) this;
        }

        public Criteria andClassesEqualTo(String value) {
            addCriterion("classes =", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesNotEqualTo(String value) {
            addCriterion("classes <>", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesGreaterThan(String value) {
            addCriterion("classes >", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesGreaterThanOrEqualTo(String value) {
            addCriterion("classes >=", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesLessThan(String value) {
            addCriterion("classes <", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesLessThanOrEqualTo(String value) {
            addCriterion("classes <=", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesLike(String value) {
            addCriterion("classes like", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesNotLike(String value) {
            addCriterion("classes not like", value, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesIn(List<String> values) {
            addCriterion("classes in", values, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesNotIn(List<String> values) {
            addCriterion("classes not in", values, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesBetween(String value1, String value2) {
            addCriterion("classes between", value1, value2, "classes");
            return (Criteria) this;
        }

        public Criteria andClassesNotBetween(String value1, String value2) {
            addCriterion("classes not between", value1, value2, "classes");
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

        public Criteria andClassNumbersEqualTo(Byte value) {
            addCriterion("class_numbers =", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersNotEqualTo(Byte value) {
            addCriterion("class_numbers <>", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersGreaterThan(Byte value) {
            addCriterion("class_numbers >", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersGreaterThanOrEqualTo(Byte value) {
            addCriterion("class_numbers >=", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersLessThan(Byte value) {
            addCriterion("class_numbers <", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersLessThanOrEqualTo(Byte value) {
            addCriterion("class_numbers <=", value, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersIn(List<Byte> values) {
            addCriterion("class_numbers in", values, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersNotIn(List<Byte> values) {
            addCriterion("class_numbers not in", values, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersBetween(Byte value1, Byte value2) {
            addCriterion("class_numbers between", value1, value2, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andClassNumbersNotBetween(Byte value1, Byte value2) {
            addCriterion("class_numbers not between", value1, value2, "classNumbers");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadIsNull() {
            addCriterion("lab_workload is null");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadIsNotNull() {
            addCriterion("lab_workload is not null");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadEqualTo(Double value) {
            addCriterion("lab_workload =", value, "labWorkload");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadNotEqualTo(Double value) {
            addCriterion("lab_workload <>", value, "labWorkload");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadGreaterThan(Double value) {
            addCriterion("lab_workload >", value, "labWorkload");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadGreaterThanOrEqualTo(Double value) {
            addCriterion("lab_workload >=", value, "labWorkload");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadLessThan(Double value) {
            addCriterion("lab_workload <", value, "labWorkload");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadLessThanOrEqualTo(Double value) {
            addCriterion("lab_workload <=", value, "labWorkload");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadIn(List<Double> values) {
            addCriterion("lab_workload in", values, "labWorkload");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadNotIn(List<Double> values) {
            addCriterion("lab_workload not in", values, "labWorkload");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadBetween(Double value1, Double value2) {
            addCriterion("lab_workload between", value1, value2, "labWorkload");
            return (Criteria) this;
        }

        public Criteria andLabWorkloadNotBetween(Double value1, Double value2) {
            addCriterion("lab_workload not between", value1, value2, "labWorkload");
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

        public Criteria andDeductPreWorkloadRateIsNull() {
            addCriterion("deduct_pre_workload_rate is null");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateIsNotNull() {
            addCriterion("deduct_pre_workload_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateEqualTo(Byte value) {
            addCriterion("deduct_pre_workload_rate =", value, "deductPreWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateNotEqualTo(Byte value) {
            addCriterion("deduct_pre_workload_rate <>", value, "deductPreWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateGreaterThan(Byte value) {
            addCriterion("deduct_pre_workload_rate >", value, "deductPreWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateGreaterThanOrEqualTo(Byte value) {
            addCriterion("deduct_pre_workload_rate >=", value, "deductPreWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateLessThan(Byte value) {
            addCriterion("deduct_pre_workload_rate <", value, "deductPreWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateLessThanOrEqualTo(Byte value) {
            addCriterion("deduct_pre_workload_rate <=", value, "deductPreWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateIn(List<Byte> values) {
            addCriterion("deduct_pre_workload_rate in", values, "deductPreWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateNotIn(List<Byte> values) {
            addCriterion("deduct_pre_workload_rate not in", values, "deductPreWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateBetween(Byte value1, Byte value2) {
            addCriterion("deduct_pre_workload_rate between", value1, value2, "deductPreWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadRateNotBetween(Byte value1, Byte value2) {
            addCriterion("deduct_pre_workload_rate not between", value1, value2, "deductPreWorkloadRate");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadIsNull() {
            addCriterion("deduct_pre_workload is null");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadIsNotNull() {
            addCriterion("deduct_pre_workload is not null");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadEqualTo(Double value) {
            addCriterion("deduct_pre_workload =", value, "deductPreWorkload");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadNotEqualTo(Double value) {
            addCriterion("deduct_pre_workload <>", value, "deductPreWorkload");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadGreaterThan(Double value) {
            addCriterion("deduct_pre_workload >", value, "deductPreWorkload");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadGreaterThanOrEqualTo(Double value) {
            addCriterion("deduct_pre_workload >=", value, "deductPreWorkload");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadLessThan(Double value) {
            addCriterion("deduct_pre_workload <", value, "deductPreWorkload");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadLessThanOrEqualTo(Double value) {
            addCriterion("deduct_pre_workload <=", value, "deductPreWorkload");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadIn(List<Double> values) {
            addCriterion("deduct_pre_workload in", values, "deductPreWorkload");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadNotIn(List<Double> values) {
            addCriterion("deduct_pre_workload not in", values, "deductPreWorkload");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadBetween(Double value1, Double value2) {
            addCriterion("deduct_pre_workload between", value1, value2, "deductPreWorkload");
            return (Criteria) this;
        }

        public Criteria andDeductPreWorkloadNotBetween(Double value1, Double value2) {
            addCriterion("deduct_pre_workload not between", value1, value2, "deductPreWorkload");
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