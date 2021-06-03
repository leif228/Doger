package com.dog.doger.app.business.app.controller;

import com.dog.doger.app.business.app.service.system.CargoService;
import com.dog.doger.app.business.app.service.system.StockpileService;
import com.dog.doger.app.business.dto.CargoInStockpileDto;
import com.dog.doger.app.business.entity.Cargo;
import com.dog.doger.app.business.util.data.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockpileController {

    @Autowired
    private StockpileService stockpileService;


    @PostMapping("/updateStockpile")
    public ApiResult updateStockpile(@RequestParam(value = "cargoNo") String cargoNo,
                                     @RequestParam(value = "num") Integer num) {
        return stockpileService.updateStockpile(cargoNo,num);
    }

}
