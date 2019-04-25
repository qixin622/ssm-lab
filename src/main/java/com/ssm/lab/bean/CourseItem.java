package com.ssm.lab.bean;

public class CourseItem {
    private Integer id;

    private Integer cid;

    private String itemname;

    private String expdemand;

    private Byte expperiod;

    private String exptype;

    private String content;

    private Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getExpdemand() {
        return expdemand;
    }

    public void setExpdemand(String expdemand) {
        this.expdemand = expdemand == null ? null : expdemand.trim();
    }

    public Byte getExpperiod() {
        return expperiod;
    }

    public void setExpperiod(Byte expperiod) {
        this.expperiod = expperiod;
    }

    public String getExptype() {
        return exptype;
    }

    public void setExptype(String exptype) {
        this.exptype = exptype == null ? null : exptype.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}