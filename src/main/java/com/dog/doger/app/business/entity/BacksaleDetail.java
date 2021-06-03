package com.dog.doger.app.business.entity;

public class BacksaleDetail {
    //
    private Long id;

    //
    private Long backsaleId;

    //
    private Long cargoId;

    //
    private Integer num;

    //
    private Float price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBacksaleId() {
        return backsaleId;
    }

    public void setBacksaleId(Long backsaleId) {
        this.backsaleId = backsaleId;
    }

    public Long getCargoId() {
        return cargoId;
    }

    public void setCargoId(Long cargoId) {
        this.cargoId = cargoId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}