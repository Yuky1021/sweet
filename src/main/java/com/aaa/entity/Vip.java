package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Vip {
    @Id
    @Column
    private Integer vid;
    @Column
    private String vtime;
    @Column
    private String bmid;

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVtime() {
        return vtime;
    }

    public void setVtime(String vtime) {
        this.vtime = vtime;
    }

    public String  getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "vid=" + vid +
                ", vtime='" + vtime + '\'' +
                ", bmid='" + bmid + '\'' +
                '}';
    }
}
