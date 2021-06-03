package com.dog.doger.app.business.repository;


import com.dog.doger.app.business.entity.SaleDetail;

public interface SaleDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SaleDetail record);

    int insertSelective(SaleDetail record);

    SaleDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SaleDetail record);

    int updateByPrimaryKey(SaleDetail record);
}