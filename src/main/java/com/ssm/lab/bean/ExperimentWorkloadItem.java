package com.ssm.lab.bean;

public class ExperimentWorkloadItem {
    private Integer id;

    private Integer experimentWorkloadId;

    private String teacherSn;

    private Byte teacherWorkloadRate;

    private Double teacherWorkload;

    private User teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getExperimentWorkloadId() {
        return experimentWorkloadId;
    }

    public void setExperimentWorkloadId(Integer experimentWorkloadId) {
        this.experimentWorkloadId = experimentWorkloadId;
    }

    public String getTeacherSn() {
        return teacherSn;
    }

    public void setTeacherSn(String teacherSn) {
        this.teacherSn = teacherSn == null ? null : teacherSn.trim();
    }

    public Byte getTeacherWorkloadRate() {
        return teacherWorkloadRate;
    }

    public void setTeacherWorkloadRate(Byte teacherWorkloadRate) {
        this.teacherWorkloadRate = teacherWorkloadRate;
    }

    public Double getTeacherWorkload() {
        return teacherWorkload;
    }

    public void setTeacherWorkload(Double teacherWorkload) {
        this.teacherWorkload = teacherWorkload;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}