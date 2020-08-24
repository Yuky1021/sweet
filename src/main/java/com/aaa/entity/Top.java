package com.aaa.entity;

public class Top {
    private Integer topid;
    private String tname;
    private Integer price;
    private String benefit;
    private Integer state;

    public Integer getTopid() {
        return topid;
    }

    public void setTopid(Integer topid) {
        this.topid = topid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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
        return "Top{" +
                "topid=" + topid +
                ", tname='" + tname + '\'' +
                ", price=" + price +
                ", benefit='" + benefit + '\'' +
                ", state=" + state +
                '}';
    }
}
