package com.dog.doger.app.business.entity;

import java.util.Date;

public class Backsale {
    //
    private Long id;

    //
    private Date creatTime;

    // 退货原因：赵拿、朋友拿等
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}