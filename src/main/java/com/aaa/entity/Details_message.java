package com.aaa.entity;

public class Details_message {
    private Integer dmid;
    private String natives;
    private String truename;
    private String Idcard;
    private String pic;
    private String constellation;
    private String nation;
    private Integer children;
    private String education;
    private String soliloquy;
    private Integer monthly;
    private Integer bmid;

    public Integer getDmid() {
        return dmid;
    }

    public void setDmid(Integer dmid) {
        this.dmid = dmid;
    }

    public String getNatives() {
        return natives;
    }

    public void setNatives(String natives) {
        this.natives = natives;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getIdcard() {
        return Idcard;
    }

    public void setIdcard(String idcard) {
        Idcard = idcard;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSoliloquy() {
        return soliloquy;
    }

    public void setSoliloquy(String soliloquy) {
        this.soliloquy = soliloquy;
    }

    public Integer getMonthly() {
        return monthly;
    }

    public void setMonthly(Integer monthly) {
        this.monthly = monthly;
    }

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    @Override
    public String toString() {
        return "Details_message{" +
                "dmid=" + dmid +
                ", natives='" + natives + '\'' +
                ", truename='" + truename + '\'' +
                ", Idcard='" + Idcard + '\'' +
                ", pic='" + pic + '\'' +
                ", constellation='" + constellation + '\'' +
                ", nation='" + nation + '\'' +
                ", children=" + children +
                ", education='" + education + '\'' +
                ", soliloquy='" + soliloquy + '\'' +
                ", monthly=" + monthly +
                ", bmid=" + bmid +
                '}';
    }
}
