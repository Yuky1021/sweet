package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Photo {
    @Id
    @Column
    private Integer phid;
    @Column
    private String url;
    @Column
    private Integer bmid;

    @Override
    public String toString() {
        return "Photo{" +
                "phid=" + phid +
                ", url='" + url + '\'' +
                ", bmid=" + bmid +
                '}';
    }

    public Integer getPhid() {
        return phid;
    }

    public void setPhid(Integer phid) {
        this.phid = phid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }
}
