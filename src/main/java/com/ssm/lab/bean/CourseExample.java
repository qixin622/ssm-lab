package com.ssm.lab.bean;

import java.util.ArrayList;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCnoIsNull() {
            addCriterion("cno is null");
            return (Criteria) this;
        }

        public Criteria andCnoIsNotNull() {
            addCriterion("cno is not null");
            return (Criteria) this;
        }

        public Criteria andCnoEqualTo(String value) {
            addCriterion("cno =", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotEqualTo(String value) {
            addCriterion("cno <>", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThan(String value) {
            addCriterion("cno >", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoGreaterThanOrEqualTo(String value) {
            addCriterion("cno >=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThan(String value) {
            addCriterion("cno <", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLessThanOrEqualTo(String value) {
            addCriterion("cno <=", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoLike(String value) {
            addCriterion("cno like", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotLike(String value) {
            addCriterion("cno not like", value, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoIn(List<String> values) {
            addCriterion("cno in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotIn(List<String> values) {
            addCriterion("cno not in", values, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoBetween(String value1, String value2) {
            addCriterion("cno between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andCnoNotBetween(String value1, String value2) {
            addCriterion("cno not between", value1, value2, "cno");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNull() {
            addCriterion("property is null");
            return (Criteria) this;
        }

        public Criteria andPropertyIsNotNull() {
            addCriterion("property is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyEqualTo(String value) {
            addCriterion("property =", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotEqualTo(String value) {
            addCriterion("property <>", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThan(String value) {
            addCriterion("property >", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyGreaterThanOrEqualTo(String value) {
            addCriterion("property >=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThan(String value) {
            addCriterion("property <", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLessThanOrEqualTo(String value) {
            addCriterion("property <=", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyLike(String value) {
            addCriterion("property like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotLike(String value) {
            addCriterion("property not like", value, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyIn(List<String> values) {
            addCriterion("property in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotIn(List<String> values) {
            addCriterion("property not in", values, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyBetween(String value1, String value2) {
            addCriterion("property between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPropertyNotBetween(String value1, String value2) {
            addCriterion("property not between", value1, value2, "property");
            return (Criteria) this;
        }

        public Criteria andPrecourseIsNull() {
            addCriterion("precourse is null");
            return (Criteria) this;
        }

        public Criteria andPrecourseIsNotNull() {
            addCriterion("precourse is not null");
            return (Criteria) this;
        }

        public Criteria andPrecourseEqualTo(String value) {
            addCriterion("precourse =", value, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseNotEqualTo(String value) {
            addCriterion("precourse <>", value, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseGreaterThan(String value) {
            addCriterion("precourse >", value, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseGreaterThanOrEqualTo(String value) {
            addCriterion("precourse >=", value, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseLessThan(String value) {
            addCriterion("precourse <", value, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseLessThanOrEqualTo(String value) {
            addCriterion("precourse <=", value, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseLike(String value) {
            addCriterion("precourse like", value, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseNotLike(String value) {
            addCriterion("precourse not like", value, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseIn(List<String> values) {
            addCriterion("precourse in", values, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseNotIn(List<String> values) {
            addCriterion("precourse not in", values, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseBetween(String value1, String value2) {
            addCriterion("precourse between", value1, value2, "precourse");
            return (Criteria) this;
        }

        public Criteria andPrecourseNotBetween(String value1, String value2) {
            addCriterion("precourse not between", value1, value2, "precourse");
            return (Criteria) this;
        }

        public Criteria andTotalperiodIsNull() {
            addCriterion("totalperiod is null");
            return (Criteria) this;
        }

        public Criteria andTotalperiodIsNotNull() {
            addCriterion("totalperiod is not null");
            return (Criteria) this;
        }

        public Criteria andTotalperiodEqualTo(Byte value) {
            addCriterion("totalperiod =", value, "totalperiod");
            return (Criteria) this;
        }

        public Criteria andTotalperiodNotEqualTo(Byte value) {
            addCriterion("totalperiod <>", value, "totalperiod");
            return (Criteria) this;
        }

        public Criteria andTotalperiodGreaterThan(Byte value) {
            addCriterion("totalperiod >", value, "totalperiod");
            return (Criteria) this;
        }

        public Criteria andTotalperiodGreaterThanOrEqualTo(Byte value) {
            addCriterion("totalperiod >=", value, "totalperiod");
            return (Criteria) this;
        }

        public Criteria andTotalperiodLessThan(Byte value) {
            addCriterion("totalperiod <", value, "totalperiod");
            return (Criteria) this;
        }

        public Criteria andTotalperiodLessThanOrEqualTo(Byte value) {
            addCriterion("totalperiod <=", value, "totalperiod");
            return (Criteria) this;
        }

        public Criteria andTotalperiodIn(List<Byte> values) {
            addCriterion("totalperiod in", values, "totalperiod");
            return (Criteria) this;
        }

        public Criteria andTotalperiodNotIn(List<Byte> values) {
            addCriterion("totalperiod not in", values, "totalperiod");
            return (Criteria) this;
        }

        public Criteria andTotalperiodBetween(Byte value1, Byte value2) {
            addCriterion("totalperiod between", value1, value2, "totalperiod");
            return (Criteria) this;
        }

        public Criteria andTotalperiodNotBetween(Byte value1, Byte value2) {
            addCriterion("totalperiod not between", value1, value2, "totalperiod");
            return (Criteria) this;
        }

        public Criteria andCreditIsNull() {
            addCriterion("credit is null");
            return (Criteria) this;
        }

        public Criteria andCreditIsNotNull() {
            addCriterion("credit is not null");
            return (Criteria) this;
        }

        public Criteria andCreditEqualTo(Float value) {
            addCriterion("credit =", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotEqualTo(Float value) {
            addCriterion("credit <>", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThan(Float value) {
            addCriterion("credit >", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditGreaterThanOrEqualTo(Float value) {
            addCriterion("credit >=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThan(Float value) {
            addCriterion("credit <", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditLessThanOrEqualTo(Float value) {
            addCriterion("credit <=", value, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditIn(List<Float> values) {
            addCriterion("credit in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotIn(List<Float> values) {
            addCriterion("credit not in", values, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditBetween(Float value1, Float value2) {
            addCriterion("credit between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andCreditNotBetween(Float value1, Float value2) {
            addCriterion("credit not between", value1, value2, "credit");
            return (Criteria) this;
        }

        public Criteria andTheperiodIsNull() {
            addCriterion("theperiod is null");
            return (Criteria) this;
        }

        public Criteria andTheperiodIsNotNull() {
            addCriterion("theperiod is not null");
            return (Criteria) this;
        }

        public Criteria andTheperiodEqualTo(Byte value) {
            addCriterion("theperiod =", value, "theperiod");
            return (Criteria) this;
        }

        public Criteria andTheperiodNotEqualTo(Byte value) {
            addCriterion("theperiod <>", value, "theperiod");
            return (Criteria) this;
        }

        public Criteria andTheperiodGreaterThan(Byte value) {
            addCriterion("theperiod >", value, "theperiod");
            return (Criteria) this;
        }

        public Criteria andTheperiodGreaterThanOrEqualTo(Byte value) {
            addCriterion("theperiod >=", value, "theperiod");
            return (Criteria) this;
        }

        public Criteria andTheperiodLessThan(Byte value) {
            addCriterion("theperiod <", value, "theperiod");
            return (Criteria) this;
        }

        public Criteria andTheperiodLessThanOrEqualTo(Byte value) {
            addCriterion("theperiod <=", value, "theperiod");
            return (Criteria) this;
        }

        public Criteria andTheperiodIn(List<Byte> values) {
            addCriterion("theperiod in", values, "theperiod");
            return (Criteria) this;
        }

        public Criteria andTheperiodNotIn(List<Byte> values) {
            addCriterion("theperiod not in", values, "theperiod");
            return (Criteria) this;
        }

        public Criteria andTheperiodBetween(Byte value1, Byte value2) {
            addCriterion("theperiod between", value1, value2, "theperiod");
            return (Criteria) this;
        }

        public Criteria andTheperiodNotBetween(Byte value1, Byte value2) {
            addCriterion("theperiod not between", value1, value2, "theperiod");
            return (Criteria) this;
        }

        public Criteria andExpperiodIsNull() {
            addCriterion("expperiod is null");
            return (Criteria) this;
        }

        public Criteria andExpperiodIsNotNull() {
            addCriterion("expperiod is not null");
            return (Criteria) this;
        }

        public Criteria andExpperiodEqualTo(Byte value) {
            addCriterion("expperiod =", value, "expperiod");
            return (Criteria) this;
        }

        public Criteria andExpperiodNotEqualTo(Byte value) {
            addCriterion("expperiod <>", value, "expperiod");
            return (Criteria) this;
        }

        public Criteria andExpperiodGreaterThan(Byte value) {
            addCriterion("expperiod >", value, "expperiod");
            return (Criteria) this;
        }

        public Criteria andExpperiodGreaterThanOrEqualTo(Byte value) {
            addCriterion("expperiod >=", value, "expperiod");
            return (Criteria) this;
        }

        public Criteria andExpperiodLessThan(Byte value) {
            addCriterion("expperiod <", value, "expperiod");
            return (Criteria) this;
        }

        public Criteria andExpperiodLessThanOrEqualTo(Byte value) {
            addCriterion("expperiod <=", value, "expperiod");
            return (Criteria) this;
        }

        public Criteria andExpperiodIn(List<Byte> values) {
            addCriterion("expperiod in", values, "expperiod");
            return (Criteria) this;
        }

        public Criteria andExpperiodNotIn(List<Byte> values) {
            addCriterion("expperiod not in", values, "expperiod");
            return (Criteria) this;
        }

        public Criteria andExpperiodBetween(Byte value1, Byte value2) {
            addCriterion("expperiod between", value1, value2, "expperiod");
            return (Criteria) this;
        }

        public Criteria andExpperiodNotBetween(Byte value1, Byte value2) {
            addCriterion("expperiod not between", value1, value2, "expperiod");
            return (Criteria) this;
        }

        public Criteria andLevelIsNull() {
            addCriterion("level is null");
            return (Criteria) this;
        }

        public Criteria andLevelIsNotNull() {
            addCriterion("level is not null");
            return (Criteria) this;
        }

        public Criteria andLevelEqualTo(String value) {
            addCriterion("level =", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotEqualTo(String value) {
            addCriterion("level <>", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThan(String value) {
            addCriterion("level >", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelGreaterThanOrEqualTo(String value) {
            addCriterion("level >=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThan(String value) {
            addCriterion("level <", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLessThanOrEqualTo(String value) {
            addCriterion("level <=", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelLike(String value) {
            addCriterion("level like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotLike(String value) {
            addCriterion("level not like", value, "level");
            return (Criteria) this;
        }

        public Criteria andLevelIn(List<String> values) {
            addCriterion("level in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotIn(List<String> values) {
            addCriterion("level not in", values, "level");
            return (Criteria) this;
        }

        public Criteria andLevelBetween(String value1, String value2) {
            addCriterion("level between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andLevelNotBetween(String value1, String value2) {
            addCriterion("level not between", value1, value2, "level");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNull() {
            addCriterion("specialty is null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNotNull() {
            addCriterion("specialty is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyEqualTo(String value) {
            addCriterion("specialty =", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotEqualTo(String value) {
            addCriterion("specialty <>", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThan(String value) {
            addCriterion("specialty >", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("specialty >=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThan(String value) {
            addCriterion("specialty <", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("specialty <=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLike(String value) {
            addCriterion("specialty like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotLike(String value) {
            addCriterion("specialty not like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIn(List<String> values) {
            addCriterion("specialty in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotIn(List<String> values) {
            addCriterion("specialty not in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyBetween(String value1, String value2) {
            addCriterion("specialty between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotBetween(String value1, String value2) {
            addCriterion("specialty not between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andDlurlIsNull() {
            addCriterion("dlurl is null");
            return (Criteria) this;
        }

        public Criteria andDlurlIsNotNull() {
            addCriterion("dlurl is not null");
            return (Criteria) this;
        }

        public Criteria andDlurlEqualTo(String value) {
            addCriterion("dlurl =", value, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlNotEqualTo(String value) {
            addCriterion("dlurl <>", value, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlGreaterThan(String value) {
            addCriterion("dlurl >", value, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlGreaterThanOrEqualTo(String value) {
            addCriterion("dlurl >=", value, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlLessThan(String value) {
            addCriterion("dlurl <", value, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlLessThanOrEqualTo(String value) {
            addCriterion("dlurl <=", value, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlLike(String value) {
            addCriterion("dlurl like", value, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlNotLike(String value) {
            addCriterion("dlurl not like", value, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlIn(List<String> values) {
            addCriterion("dlurl in", values, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlNotIn(List<String> values) {
            addCriterion("dlurl not in", values, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlBetween(String value1, String value2) {
            addCriterion("dlurl between", value1, value2, "dlurl");
            return (Criteria) this;
        }

        public Criteria andDlurlNotBetween(String value1, String value2) {
            addCriterion("dlurl not between", value1, value2, "dlurl");
            return (Criteria) this;
        }

        public Criteria andBookurlIsNull() {
            addCriterion("bookurl is null");
            return (Criteria) this;
        }

        public Criteria andBookurlIsNotNull() {
            addCriterion("bookurl is not null");
            return (Criteria) this;
        }

        public Criteria andBookurlEqualTo(String value) {
            addCriterion("bookurl =", value, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlNotEqualTo(String value) {
            addCriterion("bookurl <>", value, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlGreaterThan(String value) {
            addCriterion("bookurl >", value, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlGreaterThanOrEqualTo(String value) {
            addCriterion("bookurl >=", value, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlLessThan(String value) {
            addCriterion("bookurl <", value, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlLessThanOrEqualTo(String value) {
            addCriterion("bookurl <=", value, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlLike(String value) {
            addCriterion("bookurl like", value, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlNotLike(String value) {
            addCriterion("bookurl not like", value, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlIn(List<String> values) {
            addCriterion("bookurl in", values, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlNotIn(List<String> values) {
            addCriterion("bookurl not in", values, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlBetween(String value1, String value2) {
            addCriterion("bookurl between", value1, value2, "bookurl");
            return (Criteria) this;
        }

        public Criteria andBookurlNotBetween(String value1, String value2) {
            addCriterion("bookurl not between", value1, value2, "bookurl");
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