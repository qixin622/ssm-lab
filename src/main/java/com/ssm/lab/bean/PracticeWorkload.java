package com.ssm.lab.bean;

import java.util.List;

public class PracticeWorkload {
    private Integer id;

    private String term;

    private String workloadType;

    private String practiceType;

    private String workloadProperty;

    private Integer cid;

    private Double weekNumbers;

    private Integer stuNumbers;

    private Double classNumbers;

    private Double totalWorkload;

    private Byte preWorkloadRate;

    private Double preWorkload;

    private PracticeCourse course;

    private List<PracticeWorkloadItem> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term == null ? null : term.trim();
    }

    public String getWorkloadType() {
        return workloadType;
    }

    public void setWorkloadType(String workloadType) {
        this.workloadType = workloadType == null ? null : workloadType.trim();
    }

    public String getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(String practiceType) {
        this.practiceType = practiceType == null ? null : practiceType.trim();
    }

    public String getWorkloadProperty() {
        return workloadProperty;
    }

    public void setWorkloadProperty(String workloadProperty) {
        this.workloadProperty = workloadProperty == null ? null : workloadProperty.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Double getWeekNumbers() {
        return weekNumbers;
    }

    public void setWeekNumbers(Double weekNumbers) {
        this.weekNumbers = weekNumbers;
    }

    public Integer getStuNumbers() {
        return stuNumbers;
    }

    public void setStuNumbers(Integer stuNumbers) {
        this.stuNumbers = stuNumbers;
    }

    public Double getClassNumbers() {
        return classNumbers;
    }

    public void setClassNumbers(Double classNumbers) {
        this.classNumbers = classNumbers;
    }

    public Double getTotalWorkload() {
        return totalWorkload;
    }

    public void setTotalWorkload(Double totalWorkload) {
        this.totalWorkload = totalWorkload;
    }

    public Byte getPreWorkloadRate() {
        return preWorkloadRate;
    }

    public void setPreWorkloadRate(Byte preWorkloadRate) {
        this.preWorkloadRate = preWorkloadRate;
    }

    public Double getPreWorkload() {
        return preWorkload;
    }

    public void setPreWorkload(Double preWorkload) {
        this.preWorkload = preWorkload;
    }

    public PracticeCourse getCourse() {
        return course;
    }

    public void setCourse(PracticeCourse course) {
        this.course = course;
    }

    public List<PracticeWorkloadItem> getItems() {
        return items;
    }

    public void setItems(List<PracticeWorkloadItem> items) {
        this.items = items;
    }
}