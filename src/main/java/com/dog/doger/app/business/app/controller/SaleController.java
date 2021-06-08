package com.dog.doger.app.business.app.controller;

import com.dog.doger.app.business.app.service.system.SaleService;
import com.dog.doger.app.business.app.service.system.StockpileService;
import com.dog.doger.app.business.util.data.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {

    @Autowired
    private SaleService saleService;


    @PostMapping("/sale")
    public ApiResult sale(@RequestParam(value = "cargosJson") String cargosJson,
                                     @RequestParam(value = "washPrice") String washPrice,
                                     @RequestParam(value = "noCodePrice") String noCodePrice,
                                     @RequestParam(value = "totalPrice") String totalPrice) {
        return saleService.sale(cargosJson, washPrice, noCodePrice, totalPrice);
    }

}
