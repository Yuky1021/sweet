package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Send_paste {
    @Id
    @Column
    private Integer spid;
    @Column
    private  String title;
    @Column
    private  String context;
    @Column
    private String sendtime;
    @Column
    private Integer bmid;

    @Override
    public String toString() {
        return "Send_paste{" +
                "spid=" + spid +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", sendtime='" + sendtime + '\'' +
                ", bmid=" + bmid +
                '}';
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }
}
