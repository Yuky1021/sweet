package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Emp {

    @Id
    @Column
    private Integer emid;
    @Column
    private String ename;
    @Column
    private String epwd;
    @Column
    private String truename;
    @Column
    private Integer sex;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private Integer state;

    @Override
    public String toString() {
        return "Emp{" +
                "emid=" + emid +
                ", ename='" + ename + '\'' +
                ", epwd='" + epwd + '\'' +
                ", truename='" + truename + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                '}';
    }

    public Integer getEmid() {
        return emid;
    }

    public void setEmid(Integer emid) {
        this.emid = emid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEpwd() {
        return epwd;
    }

    public void setEpwd(String epwd) {
        this.epwd = epwd;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
