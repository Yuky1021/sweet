package com.aaa.entity;

public class activity {
    private Integer acid;
    private String title;
    private String achost;
    private String actime;
    private String acaddress;
    private Integer acpeople;
    private String actype;
    private String acrequest;
    private String flow;
    private String remark;

    public Integer getAcid() {
        return acid;
    }

    public void setAcid(Integer acid) {
        this.acid = acid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAchost() {
        return achost;
    }

    public void setAchost(String achost) {
        this.achost = achost;
    }

    public String getActime() {
        return actime;
    }

    public void setActime(String actime) {
        this.actime = actime;
    }

    public String getAcaddress() {
        return acaddress;
    }

    public void setAcaddress(String acaddress) {
        this.acaddress = acaddress;
    }

    public Integer getAcpeople() {
        return acpeople;
    }

    public void setAcpeople(Integer acpeople) {
        this.acpeople = acpeople;
    }

    public String getActype() {
        return actype;
    }

    public void setActype(String actype) {
        this.actype = actype;
    }

    public String getAcrequest() {
        return acrequest;
    }

    public void setAcrequest(String acrequest) {
        this.acrequest = acrequest;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "activity{" +
                "acid=" + acid +
                ", title='" + title + '\'' +
                ", achost='" + achost + '\'' +
                ", actime='" + actime + '\'' +
                ", acaddress='" + acaddress + '\'' +
                ", acpeople=" + acpeople +
                ", actype='" + actype + '\'' +
                ", acrequest='" + acrequest + '\'' +
                ", flow='" + flow + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
