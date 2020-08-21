package com.aaa.entity;

public class Media {
    private Integer meid;
    private String name;
    private String pic;

    public Integer getMeid() {
        return meid;
    }

    public void setMeid(Integer meid) {
        this.meid = meid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Media{" +
                "meid=" + meid +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
