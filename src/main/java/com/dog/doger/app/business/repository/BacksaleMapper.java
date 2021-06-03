package com.dog.doger.app.business.repository;


import com.dog.doger.app.business.entity.Backsale;

public interface BacksaleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Backsale record);

    int insertSelective(Backsale record);

    Backsale selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Backsale record);

    int updateByPrimaryKey(Backsale record);
}