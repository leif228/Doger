package com.dog.doger.app.business.app.service.system.impl;

import com.dog.doger.app.business.app.service.system.CargoService;
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
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

@Service
@Slf4j
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoMapper cargoMapper;
    @Autowired
    private StockpileMapper stockpileMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ApiResult addCargo(CargoInStockpileDto cargo) {
        try {
            Cargo existCargo = cargoMapper.findByCargoNo(cargo.getCargoNo());
            if (existCargo == null) {
                existCargo = new Cargo();
                BeanUtils.copyProperties(cargo, existCargo);

                existCargo.setId(null);
                existCargo.setCreatTime(DateUtil.getDate());

                cargoMapper.insertSelective(existCargo);

                Stockpile stockpile = stockpileMapper.findByCargoId(existCargo.getId());
                if(stockpile == null){
                    stockpile = new Stockpile();
                    stockpile.setCargoId(existCargo.getId());
                    stockpile.setNum(cargo.getNum());
                    stockpile.setFirstEnterDate(DateUtil.getDate());

                    stockpileMapper.insertSelective(stockpile);
                }
            } else {
                throw new Exception("该条码商品已经添加过了！");
            }

            return ApiResult.success();
        } catch (Exception e) {
            //TODO 设置try catch后事务回滚方法
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ApiResult.error(e.getMessage());
        }
    }

    @Override
    public ApiResult updateCargo(Cargo cargo) {
        try {
            Cargo existCargo = cargoMapper.findByCargoNo(cargo.getCargoNo());
            if (existCargo == null) {
                throw new Exception("该条码商品没有被添加！请添加商品！");
            } else {
                cargo.setId(existCargo.getId());
                cargoMapper.updateByPrimaryKeySelective(cargo);
            }

            return ApiResult.success();
        } catch (Exception e) {
            return ApiResult.error(e.getMessage());
        }
    }

    @Override
    public ApiResult cargo(String cargoNo) {
        try {
            Cargo existCargo = cargoMapper.findByCargoNo(cargoNo);
            if (existCargo == null) {
                throw new Exception("查找该条码商品失败！");
            }

            return ApiResult.success(existCargo);
        } catch (Exception e) {
            return ApiResult.error(e.getMessage());
        }
    }

    @Override
    public ApiResult cargos() {
        try {
            List<Cargo> list = cargoMapper.findAll();
            return ApiResult.success(list);
        } catch (Exception e) {
            return ApiResult.error(e.getMessage());
        }
    }
}
