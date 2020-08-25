package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Attention {
    @Id
    @Column
    private Integer attid;
    @Column
    private Integer baid;
    @Column
    private Integer aid;

    public Integer getAttid() {
        return attid;
    }

    public void setAttid(Integer attid) {
        this.attid = attid;
    }

    public Integer getBaid() {
        return baid;
    }

    public void setBaid(Integer baid) {
        this.baid = baid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    @Override
    public String toString() {
        return "Attention{" +
                "attid=" + attid +
                ", baid=" + baid +
                ", aid=" + aid +
                '}';
    }
}
