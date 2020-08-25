package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Vip {

    @Id
    @Column
    private Integer vid;
    @Column
    private String project;
    @Column
    private String paytime;
    @Column
    private String vtime;
    @Column
    private Integer bmid;

    @Override
    public String toString() {
        return "Vip{" +
                "vid=" + vid +
                ", project='" + project + '\'' +
                ", paytime='" + paytime + '\'' +
                ", vtime='" + vtime + '\'' +
                ", bmid=" + bmid +
                '}';
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getVtime() {
        return vtime;
    }

    public void setVtime(String vtime) {
        this.vtime = vtime;
    }

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }
}
