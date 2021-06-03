package com.dog.doger.app.business.app.service.system;


import com.dog.doger.app.business.dto.CargoInStockpileDto;
import com.dog.doger.app.business.entity.Cargo;
import com.dog.doger.app.business.util.data.ApiResult;

public interface CargoService {



    ApiResult addCargo(CargoInStockpileDto cargo);

    ApiResult updateCargo(Cargo cargo);

    ApiResult cargo(Cargo cargo);

    ApiResult cargos();


}
