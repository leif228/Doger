package com.dog.doger.app.business.repository;


import com.dog.doger.app.business.entity.Stockpile;

public interface StockpileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Stockpile record);

    int insertSelective(Stockpile record);

    Stockpile selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Stockpile record);

    int updateByPrimaryKey(Stockpile record);

    Stockpile findByCargoId(Long cargoId);

}