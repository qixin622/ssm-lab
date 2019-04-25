package com.ssm.lab.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class WorkRecord {
    private Integer id;

    private String content;

    private String userSn;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUserSn() {
        return userSn;
    }

    public void setUserSn(String userSn) {
        this.userSn = userSn == null ? null : userSn.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}