package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Media {
    @Id
    @Column
    private Integer meid;
    @Column
    private String name;
    @Column
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
