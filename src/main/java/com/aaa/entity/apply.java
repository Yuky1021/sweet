package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class apply {
    @Id
    @Column
    private Integer apid;
    @Column
    private String name;
    @Column
    private Integer part;
    @Column
    private String phone;
    @Column
    private String wechat;
    @Column
    private Integer acid;
    @Column
    private Integer bmid;


    public Integer getApid() {
        return apid;
    }

    public void setApid(Integer apid) {
        this.apid = apid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPart() {
        return part;
    }

    public void setPart(Integer part) {
        this.part = part;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    @Override
    public String toString() {
        return "apply{" +
                "apid=" + apid +
                ", name='" + name + '\'' +
                ", part=" + part +
                ", phone='" + phone + '\'' +
                ", wechat='" + wechat + '\'' +
                ", acid=" + acid +
                ", bmid=" + bmid +
                '}';
    }
}
