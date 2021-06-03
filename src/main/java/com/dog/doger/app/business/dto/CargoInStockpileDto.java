package com.dog.doger.app.business.dto;

import com.dog.doger.app.business.entity.Cargo;

public class CargoInStockpileDto extends Cargo {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
