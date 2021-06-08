package com.dog.doger.app.business.app.service.system.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dog.doger.app.business.app.service.system.SaleService;
import com.dog.doger.app.business.app.service.system.StockpileService;
import com.dog.doger.app.business.dto.CargoInStockpileDto;
import com.dog.doger.app.business.entity.Cargo;
import com.dog.doger.app.business.entity.Sale;
import com.dog.doger.app.business.entity.SaleDetail;
import com.dog.doger.app.business.entity.Stockpile;
import com.dog.doger.app.business.repository.CargoMapper;
import com.dog.doger.app.business.repository.SaleDetailMapper;
import com.dog.doger.app.business.repository.SaleMapper;
import com.dog.doger.app.business.repository.StockpileMapper;
import com.dog.doger.app.business.util.data.ApiResult;
import com.dog.doger.app.business.util.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
@Slf4j
public class SaleServiceImpl implements SaleService {

    @Autowired
    private CargoMapper cargoMapper;
    @Autowired
    private StockpileMapper stockpileMapper;
    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private SaleDetailMapper saleDetailMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ApiResult sale(String cargosJson, String washPrice, String noCodePrice, String totalPrice) {
        try {
            Float tp = Float.valueOf(totalPrice);

            Sale sale = new Sale();
            sale.setCreatTime(DateUtil.getDate());
            sale.setTotalPrice(tp);

            saleMapper.insertSelective(sale);

            List<CargoInStockpileDto> jsonArray = JSONObject.parseArray(cargosJson, CargoInStockpileDto.class);
            for (int i = 0; i < jsonArray.size(); i++) {
                Cargo existCargo = cargoMapper.findByCargoNo(jsonArray.get(i).getCargoNo());
                if (existCargo == null) {
                    continue;
                }else{
                    SaleDetail saleDetail = new SaleDetail();
                    saleDetail.setSaleId(sale.getId());
                    saleDetail.setCargoId(existCargo.getId());
                    saleDetail.setNum(jsonArray.get(i).getNum());
                    saleDetail.setPrice(jsonArray.get(i).getSalPrice());

                    saleDetailMapper.insertSelective(saleDetail);
                }
            }

            Float wp = Float.valueOf(washPrice);
            if(wp != 0f){
                Cargo existCargo = cargoMapper.findByCargoNo("111111");
                if (existCargo != null) {
                    SaleDetail saleDetail = new SaleDetail();
                    saleDetail.setSaleId(sale.getId());
                    saleDetail.setCargoId(existCargo.getId());
                    saleDetail.setNum(1);
                    saleDetail.setPrice(wp);

                    saleDetailMapper.insertSelective(saleDetail);
                }
            }

            Float np = Float.valueOf(noCodePrice);
            if(np != 0f){
                Cargo existCargo = cargoMapper.findByCargoNo("000000");
                if (existCargo != null) {
                    SaleDetail saleDetail = new SaleDetail();
                    saleDetail.setSaleId(sale.getId());
                    saleDetail.setCargoId(existCargo.getId());
                    saleDetail.setNum(1);
                    saleDetail.setPrice(np);

                    saleDetailMapper.insertSelective(saleDetail);
                }
            }

            return ApiResult.success();
        } catch (Exception e) {
            //TODO 设置try catch后事务回滚方法
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ApiResult.error(e.getMessage());
        }
    }
}
