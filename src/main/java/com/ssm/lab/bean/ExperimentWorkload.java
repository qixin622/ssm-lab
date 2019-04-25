package com.ssm.lab.bean;

import java.util.List;

public class ExperimentWorkload {
    private Integer id;

    private String term;

    private String workloadType;

    private Integer cid;

    private String classes;

    private Integer stuNumbers;

    private Double classNumbers;

    private Double labWorkload;

    private Double preWorkload;

    private Double totalWorkload;

    private Byte deductPreWorkloadRate;

    private Double deductPreWorkload;

    private Course course;

    private List<ExperimentWorkloadItem> items;

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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes == null ? null : classes.trim();
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

    public Double getLabWorkload() {
        return labWorkload;
    }

    public void setLabWorkload(Double labWorkload) {
        this.labWorkload = labWorkload;
    }

    public Double getPreWorkload() {
        return preWorkload;
    }

    public void setPreWorkload(Double preWorkload) {
        this.preWorkload = preWorkload;
    }

    public Double getTotalWorkload() {
        return totalWorkload;
    }

    public void setTotalWorkload(Double totalWorkload) {
        this.totalWorkload = totalWorkload;
    }

    public Byte getDeductPreWorkloadRate() {
        return deductPreWorkloadRate;
    }

    public void setDeductPreWorkloadRate(Byte deductPreWorkloadRate) {
        this.deductPreWorkloadRate = deductPreWorkloadRate;
    }

    public Double getDeductPreWorkload() {
        return deductPreWorkload;
    }

    public void setDeductPreWorkload(Double deductPreWorkload) {
        this.deductPreWorkload = deductPreWorkload;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<ExperimentWorkloadItem> getItems() {
        return items;
    }

    public void setItems(List<ExperimentWorkloadItem> items) {
        this.items = items;
    }
}