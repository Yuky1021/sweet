package com.aaa.entity;

import javax.persistence.Id;

public class Top_basic {
    @Id
    private String tbid;
    private String bmid;
    private String jstime;

    public String getTbid() {
        return tbid;
    }

    public void setTbid(String tbid) {
        this.tbid = tbid;
    }

    public String getBmid() {
        return bmid;
    }

    public void setBmid(String bmid) {
        this.bmid = bmid;
    }

    public String getJstime() {
        return jstime;
    }

    public void setJstime(String jstime) {
        this.jstime = jstime;
    }

    @Override
    public String toString() {
        return "Top_basic{" +
                "tbid='" + tbid + '\'' +
                ", bmid='" + bmid + '\'' +
                ", jstime='" + jstime + '\'' +
                '}';
    }
}
