package com.dog.doger.app.business.app.controller;

import com.dog.doger.app.business.app.service.system.CargoService;
import com.dog.doger.app.business.dto.CargoInStockpileDto;
import com.dog.doger.app.business.entity.Cargo;
import com.dog.doger.app.business.util.data.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CargoController {

    @Autowired
    private CargoService cargoService;


    @PostMapping("/addCargo")
    public ApiResult addCargo(CargoInStockpileDto cargo) {
        return cargoService.addCargo(cargo);
    }

    @PostMapping("/updateCargo")
    public ApiResult updateCargo(@RequestBody Cargo cargo) {
        return cargoService.updateCargo(cargo);
    }

    @PostMapping("/cargo")
    public ApiResult cargo(@RequestBody Cargo cargo) {
        return cargoService.cargo(cargo);
    }

    @PostMapping("/cargos")
    public ApiResult cargos() {
        return cargoService.cargos();
    }

}
