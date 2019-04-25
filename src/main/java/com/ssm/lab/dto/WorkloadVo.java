package com.ssm.lab.dto;

import java.io.Serializable;

public class WorkloadVo implements Serializable {
    private Integer id;
    private String term;
    private String workloadType;
    private String cno;
    private String cname;
    private String teacherSn;
    private String userName;
    private String teacherWorkload;

    public WorkloadVo() {
    }

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
        this.term = term;
    }

    public String getWorkloadType() {
        return workloadType;
    }

    public void setWorkloadType(String workloadType) {
        this.workloadType = workloadType;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTeacherSn() {
        return teacherSn;
    }

    public void setTeacherSn(String teacherSn) {
        this.teacherSn = teacherSn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTeacherWorkload() {
        return teacherWorkload;
    }

    public void setTeacherWorkload(String teacherWorkload) {
        this.teacherWorkload = teacherWorkload;
    }
}
