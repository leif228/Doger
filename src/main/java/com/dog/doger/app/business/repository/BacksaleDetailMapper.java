package com.dog.doger.app.business.repository;


import com.dog.doger.app.business.entity.BacksaleDetail;

public interface BacksaleDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BacksaleDetail record);

    int insertSelective(BacksaleDetail record);

    BacksaleDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BacksaleDetail record);

    int updateByPrimaryKey(BacksaleDetail record);
}