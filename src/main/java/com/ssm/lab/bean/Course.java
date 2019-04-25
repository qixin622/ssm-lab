package com.ssm.lab.bean;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class Course {
    private Integer id;

    private String cno;

    private String cname;

    private String property;

    private String precourse;

    private Byte totalperiod;

    private Float credit;

    private Byte theperiod;

    private Byte expperiod;

    private String level;

    private String specialty;

    private String dlurl;

    private String bookurl;

    private String content;

    private MultipartFile dlurlFile;
    private MultipartFile bookurlFile;

    private List<CourseItem> courseItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno == null ? null : cno.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property == null ? null : property.trim();
    }

    public String getPrecourse() {
        return precourse;
    }

    public void setPrecourse(String precourse) {
        this.precourse = precourse == null ? null : precourse.trim();
    }

    public Byte getTotalperiod() {
        return totalperiod;
    }

    public void setTotalperiod(Byte totalperiod) {
        this.totalperiod = totalperiod;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Byte getTheperiod() {
        return theperiod;
    }

    public void setTheperiod(Byte theperiod) {
        this.theperiod = theperiod;
    }

    public Byte getExpperiod() {
        return expperiod;
    }

    public void setExpperiod(Byte expperiod) {
        this.expperiod = expperiod;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getDlurl() {
        return dlurl;
    }

    public void setDlurl(String dlurl) {
        this.dlurl = dlurl == null ? null : dlurl.trim();
    }

    public String getBookurl() {
        return bookurl;
    }

    public void setBookurl(String bookurl) {
        this.bookurl = bookurl == null ? null : bookurl.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public MultipartFile getDlurlFile() {
        return dlurlFile;
    }

    public void setDlurlFile(MultipartFile dlurlFile) {
        this.dlurlFile = dlurlFile;
    }

    public MultipartFile getBookurlFile() {
        return bookurlFile;
    }

    public void setBookurlFile(MultipartFile bookurlFile) {
        this.bookurlFile = bookurlFile;
    }

    public List<CourseItem> getCourseItems() {
        return courseItems;
    }

    public void setCourseItems(List<CourseItem> courseItems) {
        this.courseItems = courseItems;
    }
}