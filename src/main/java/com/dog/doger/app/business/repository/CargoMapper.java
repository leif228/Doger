package com.dog.doger.app.business.repository;


import com.dog.doger.app.business.entity.Cargo;

import java.util.List;

public interface CargoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cargo record);

    int insertSelective(Cargo record);

    Cargo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cargo record);

    int updateByPrimaryKey(Cargo record);

    Cargo findByCargoNo(String cargoNo);

    List<Cargo> findAll();

}