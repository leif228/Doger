package com.dog.doger.app.business.app.service.system;


import com.dog.doger.app.business.util.data.ApiResult;

public interface SaleService {


    ApiResult sale(String cargosJson, String washPrice, String noCodePrice, String totalPrice);

    ApiResult saleState(String st, String et);
}
