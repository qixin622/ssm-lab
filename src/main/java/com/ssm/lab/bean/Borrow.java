package com.ssm.lab.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Borrow {
    private Integer id;

    private String name;

    private Byte num;

    private String unit;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date borrowTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date returnTime;

    private String borrowSn;

    private String borrowHandleSn;

    private String returnHandleSn;

    private String remarks;

    private String flag;
    private User borrower;
    private User borrowHandler;
    private User returnHanlder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getNum() {
        return num;
    }

    public void setNum(Byte num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getBorrowSn() {
        return borrowSn;
    }

    public void setBorrowSn(String borrowSn) {
        this.borrowSn = borrowSn == null ? null : borrowSn.trim();
    }

    public String getBorrowHandleSn() {
        return borrowHandleSn;
    }

    public void setBorrowHandleSn(String borrowHandleSn) {
        this.borrowHandleSn = borrowHandleSn == null ? null : borrowHandleSn.trim();
    }

    public String getReturnHandleSn() {
        return returnHandleSn;
    }

    public void setReturnHandleSn(String returnHandleSn) {
        this.returnHandleSn = returnHandleSn == null ? null : returnHandleSn.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public User getBorrowHandler() {
        return borrowHandler;
    }

    public void setBorrowHandler(User borrowHandler) {
        this.borrowHandler = borrowHandler;
    }

    public User getReturnHanlder() {
        return returnHanlder;
    }

    public void setReturnHanlder(User returnHanlder) {
        this.returnHanlder = returnHanlder;
    }
}