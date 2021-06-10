package com.dog.doger.app.business.repository;


import com.dog.doger.app.business.entity.Sale;

import java.util.Date;
import java.util.List;

public interface SaleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sale record);

    int insertSelective(Sale record);

    Sale selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sale record);

    int updateByPrimaryKey(Sale record);

    List<Sale> findByTime(Date stime, Date etime);
}