package com.dog.doger.app.business.app.service.system.impl;

import com.dog.doger.app.business.app.service.system.CargoService;
import com.dog.doger.app.business.app.service.system.StockpileService;
import com.dog.doger.app.business.dto.CargoInStockpileDto;
import com.dog.doger.app.business.entity.Cargo;
import com.dog.doger.app.business.entity.Stockpile;
import com.dog.doger.app.business.repository.CargoMapper;
import com.dog.doger.app.business.repository.StockpileMapper;
import com.dog.doger.app.business.util.data.ApiResult;
import com.dog.doger.app.business.util.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class StockpileServiceImpl implements StockpileService {

    @Autowired
    private CargoMapper cargoMapper;
    @Autowired
    private StockpileMapper stockpileMapper;

    @Override
    public ApiResult updateStockpile(String cargoNo, Integer num) {
        try {
            Cargo existCargo = cargoMapper.findByCargoNo(cargoNo);
            if (existCargo == null) {
                throw new Exception("该条码商品没有被添加！请添加商品！");
            } else {
                Stockpile stockpile = stockpileMapper.findByCargoId(existCargo.getId());
                stockpile.setNum(stockpile.getNum() + num);

                stockpileMapper.updateByPrimaryKeySelective(stockpile);
            }

            return ApiResult.success();
        } catch (Exception e) {
            return ApiResult.error(e.getMessage());
        }
    }
}
