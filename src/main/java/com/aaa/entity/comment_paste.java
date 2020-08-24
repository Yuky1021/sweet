package com.aaa.entity;

public class comment_paste {
    private Integer cpid;
    private String title;
    private String context;
    private String commention;
    private Integer spid;
    private Integer bmid;

    public Integer getCpid() {
        return cpid;
    }

    public void setCpid(Integer cpid) {
        this.cpid = cpid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getCommention() {
        return commention;
    }

    public void setCommention(String commention) {
        this.commention = commention;
    }

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    @Override
    public String toString() {
        return "comment_paste{" +
                "cpid=" + cpid +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", commention='" + commention + '\'' +
                ", spid=" + spid +
                ", bmid=" + bmid +
                '}';
    }
}
