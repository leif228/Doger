package com.dog.doger.app.business.entity;

import java.io.Serializable;
import java.util.Date;

public class Cargo implements Serializable {
    //
    private Long id;

    //
    private String cargoName;

    // 商品条码号
    private String cargoNo;

    // 进价
    private Float oriPrice;

    // 卖价
    private Float salPrice;

    //
    private Date creatTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName == null ? null : cargoName.trim();
    }

    public String getCargoNo() {
        return cargoNo;
    }

    public void setCargoNo(String cargoNo) {
        this.cargoNo = cargoNo == null ? null : cargoNo.trim();
    }

    public Float getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(Float oriPrice) {
        this.oriPrice = oriPrice;
    }

    public Float getSalPrice() {
        return salPrice;
    }

    public void setSalPrice(Float salPrice) {
        this.salPrice = salPrice;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}