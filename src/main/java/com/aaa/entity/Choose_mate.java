package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Choose_mate {
    @Id
    @Column
    private Integer cmid;
    @Column
    private Integer lage;
    @Column
    private Integer bage;
    @Column
    private Integer height;
    @Column
    private String education;
    @Column
    private Integer marriage;
    @Column
    private String nation;
    @Column
    private Integer monthly;
    @Column
    private Integer bmid;

    public Integer getCmid() {
        return cmid;
    }

    public void setCmid(Integer cmid) {
        this.cmid = cmid;
    }

    public Integer getLage() {
        return lage;
    }

    public void setLage(Integer lage) {
        this.lage = lage;
    }

    public Integer getBage() {
        return bage;
    }

    public void setBage(Integer bage) {
        this.bage = bage;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getMonthly() {
        return monthly;
    }

    public void setMonthly(Integer monthly) {
        this.monthly = monthly;
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    @Override
    public String toString() {
        return "Choose_mate{" +
                "cmid=" + cmid +
                ", lage=" + lage +
                ", bage=" + bage +
                ", height=" + height +
                ", education='" + education + '\'' +
                ", marriage=" + marriage +
                ", nation='" + nation + '\'' +
                ", monthly=" + monthly +
                ", bmid=" + bmid +
                '}';
    }
}
