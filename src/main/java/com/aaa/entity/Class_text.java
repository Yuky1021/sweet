package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Class_text {
    @Id
    @Column
    private Integer ctid;
    @Column
    private  String ctname;
    @Column
    private String info;

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public String getCtname() {
        return ctname;
    }

    public void setCtname(String ctname) {
        this.ctname = ctname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "class_text{" +
                "ctid=" + ctid +
                ", ctname='" + ctname + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
