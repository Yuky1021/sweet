package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Dispose {
    @Id
    @Column
    private Integer dsid;
    @Column
    private Integer bid;
    @Column
    private Integer types;
    @Column
    private String reason;
    @Column
    private Integer bmid;
    @Column
    private Integer state;
    @Column
    private Integer way;
    @Column
    private String dtime;
    @Column
    private Integer emid;


    public Integer getDsid() {
        return dsid;
    }

    public void setDsid(Integer dsid) {
        this.dsid = dsid;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }



    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getWay() {
        return way;
    }

    public void setWay(Integer way) {
        this.way = way;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public Integer getEmid() {
        return emid;
    }

    public void setEmid(Integer emid) {
        this.emid = emid;
    }

    @Override
    public String toString() {
        return "Dispose{" +
                "dsid=" + dsid +
                ", bid=" + bid +
                ", types=" + types +
                ", reason='" + reason + '\'' +
                ", bmid=" + bmid +
                ", state=" + state +
                ", way=" + way +
                ", dtime='" + dtime + '\'' +
                ", emid=" + emid +
                '}';
    }
}
