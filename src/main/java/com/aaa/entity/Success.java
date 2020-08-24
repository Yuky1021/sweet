package com.aaa.entity;

public class Success {
    private Integer seid;
    private String boyname;
    private String girlname;
    private String info;

    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    public String getBoyname() {
        return boyname;
    }

    public void setBoyname(String boyname) {
        this.boyname = boyname;
    }

    public String getGirlname() {
        return girlname;
    }

    public void setGirlname(String girlname) {
        this.girlname = girlname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Success{" +
                "seid=" + seid +
                ", boyname='" + boyname + '\'' +
                ", girlname='" + girlname + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
