package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Basic_message {
    @Id
    @Column
    private Integer bmid;
    @Column
    private String number;
    @Column
    private String bmname;
    @Column
    private Integer age;
    @Column
    private Integer weight;
    @Column
    private Integer height;
    @Column
    private Integer sex;
    @Column
    private String phone;
    @Column
    private String pwd;
    @Column
    private String address;
    @Column
    private String birthday;
    @Column
    private Integer marriage;
    @Column
    private Integer vip;
    @Column
    private Integer state;

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBmname() {
        return bmname;
    }

    public void setBmname(String bmname) {
        this.bmname = bmname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Basic_message{" +
                "bmid=" + bmid +
                ", number='" + number + '\'' +
                ", bmname='" + bmname + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                ", birthday='" + birthday + '\'' +
                ", marriage=" + marriage +
                ", vip=" + vip +
                ", state=" + state +
                '}';
    }
}
