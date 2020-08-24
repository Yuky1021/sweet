package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class life_message {
    @Id
    @Column
    private Integer lmid;
    @Column
    private Integer ptid;
    @Column
    private Integer buyhouse;
    @Column
    private Integer buycar;
    @Column
    private Integer smoking;
    @Column
    private Integer drink;
    @Column
    private String city;
    @Column
    private String book;
    @Column
    private String hobby;
    @Column
    private Integer bmid;

    public Integer getLmid() {
        return lmid;
    }

    public void setLmid(Integer lmid) {
        this.lmid = lmid;
    }

    public Integer getPtid() {
        return ptid;
    }

    public void setPtid(Integer ptid) {
        this.ptid = ptid;
    }

    public Integer getBuyhouse() {
        return buyhouse;
    }

    public void setBuyhouse(Integer buyhouse) {
        this.buyhouse = buyhouse;
    }

    public Integer getBuycar() {
        return buycar;
    }

    public void setBuycar(Integer buycar) {
        this.buycar = buycar;
    }

    public Integer getSmoking() {
        return smoking;
    }

    public void setSmoking(Integer smoking) {
        this.smoking = smoking;
    }

    public Integer getDrink() {
        return drink;
    }

    public void setDrink(Integer drink) {
        this.drink = drink;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getBmid() {
        return bmid;
    }

    public void setBmid(Integer bmid) {
        this.bmid = bmid;
    }

    @Override
    public String toString() {
        return "life_message{" +
                "lmid=" + lmid +
                ", ptid=" + ptid +
                ", buyhouse=" + buyhouse +
                ", buycar=" + buycar +
                ", smoking=" + smoking +
                ", drink=" + drink +
                ", city='" + city + '\'' +
                ", book='" + book + '\'' +
                ", hobby='" + hobby + '\'' +
                ", bmid=" + bmid +
                '}';
    }
}
