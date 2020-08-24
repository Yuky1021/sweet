package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Profession_type {

    @Id
    @Column
    private Integer ptid;
    @Column
    private String ptname;

    @Override
    public String toString() {
        return "Profession_type{" +
                "ptid=" + ptid +
                ", ptname='" + ptname + '\'' +
                '}';
    }

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public String getPtname() {
        return ptname;
    }

    public void setPtname(String ptname) {
        this.ptname = ptname;
    }
}
