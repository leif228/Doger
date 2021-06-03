package com.dog.doger.app.business.entity;

import java.util.Date;

public class Stockpile {
    //
    private Long id;

    //
    private Long cargoId;

    // 所存数量
    private Integer num;

    // 此种商品第一次入库时间
    private Date firstEnterDate;

    // 此种商品最后一次出库时间
    private Date lastLeaveDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getFirstEnterDate() {
        return firstEnterDate;
    }

    public void setFirstEnterDate(Date firstEnterDate) {
        this.firstEnterDate = firstEnterDate;
    }

    public Date getLastLeaveDate() {
        return lastLeaveDate;
    }

    public void setLastLeaveDate(Date lastLeaveDate) {
        this.lastLeaveDate = lastLeaveDate;
    }
}