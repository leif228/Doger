package com.dog.doger.app.business.enums;

public enum WashNocodeType {

    WASH("111111", "洗护编码"),
    NO_CODE("000000", "没有条码商品编码");

    private String code;

    private String remark;

    WashNocodeType(String code, String remark) {
        this.code = code;
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public String getRemark() {
        return remark;
    }
}
