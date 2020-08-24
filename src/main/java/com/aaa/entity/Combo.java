package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Combo {

    @Id
    @Column
    private Integer coid;
    @Column
    private String coname;
    @Column
    private Integer price;
    @Column
    private double days;
    @Column
    private String benefit;
    @Column
    private Integer state;

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public double getDays() {
        return days;
    }

    public void setDays(double days) {
        this.days = days;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Combo{" +
                "coid=" + coid +
                ", coname='" + coname + '\'' +
                ", price=" + price +
                ", days=" + days +
                ", benefit='" + benefit + '\'' +
                ", state=" + state +
                '}';
    }
}
