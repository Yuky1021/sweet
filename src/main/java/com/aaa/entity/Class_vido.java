package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Class_vido {
    @Id
    @Column
    private Integer cvid;
    @Column
    private String cvname;
    @Column
    private String voids;

    public Integer getCvid() {
        return cvid;
    }

    public void setCvid(Integer cvid) {
        this.cvid = cvid;
    }

    public String getCvname() {
        return cvname;
    }

    public void setCvname(String cvname) {
        this.cvname = cvname;
    }

    public String getVoids() {
        return voids;
    }

    public void setVoids(String voids) {
        this.voids = voids;
    }

    @Override
    public String toString() {
        return "Class_vido{" +
                "cvid=" + cvid +
                ", cvname='" + cvname + '\'' +
                ", voids='" + voids + '\'' +
                '}';
    }
}
