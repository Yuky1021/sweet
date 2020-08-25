package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Pay_fees {
    @Id
    @Column
    private Integer pfid;
    @Column
    private String peoject;
    @Column
    private Integer money;
    @Column
    private String paytime;
    @Column
    private String ptime;
    @Column
    private Integer bmid;

    public Integer getPfid() {
        return pfid;
    }

    public void setPfid(Integer pfid) {
        this.pfid = pfid;
    }

    public String getPeoject() {
        return peoject;
    }

    public void setPeoject(String peoject) {
        this.peoject = peoject;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    @Override
    public String toString() {
        return "Pay_fees{" +
                "pfid=" + pfid +
                ", peoject='" + peoject + '\'' +
                ", money=" + money +
                ", paytime='" + paytime + '\'' +
                ", ptime='" + ptime + '\'' +
                ", bmid=" + bmid +
                '}';
    }
}
