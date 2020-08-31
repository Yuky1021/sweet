package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Message {
    @Id
    @Column
    private Integer meid;
    @Column
    private Integer one;

    @Column
    private Integer tow;

    @Column
    private String context;

    @Column
    private Integer mstate;

    @Column
    private String ftime;


    public Integer getMeid() {
        return meid;
    }

    public void setMeid(Integer meid) {
        this.meid = meid;
    }

    public Integer getOne() {
        return one;
    }

    public void setOne(Integer one) {
        this.one = one;
    }

    public Integer getTow() {
        return tow;
    }

    public void setTow(Integer tow) {
        this.tow = tow;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getMstate() {
        return mstate;
    }

    public void setMstate(Integer mstate) {
        this.mstate = mstate;
    }

    public String getFtime() {
        return ftime;
    }

    public void setFtime(String ftime) {
        this.ftime = ftime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "meid=" + meid +
                ", one=" + one +
                ", tow=" + tow +
                ", context='" + context + '\'' +
                ", mstate=" + mstate +
                ", ftime='" + ftime + '\'' +
                '}';
    }
}
