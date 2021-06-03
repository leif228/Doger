package com.dog.doger.app.business.app.service.system;


import com.dog.doger.app.business.dto.CargoInStockpileDto;
import com.dog.doger.app.business.entity.Cargo;
import com.dog.doger.app.business.util.data.ApiResult;

public interface StockpileService {


    ApiResult updateStockpile(String cargoNo, Integer num);
}
