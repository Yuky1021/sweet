package com.aaa.entity;

public class admins {
    private Integer adid;
    private String adname;
    private String pwd;
    private Integer state;

    public Integer getAdid() {
        return adid;
    }

    public void setAdid(Integer adid) {
        this.adid = adid;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "admins{" +
                "adid=" + adid +
                ", adname='" + adname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", state=" + state +
                '}';
    }
}
