package com.mapper;

import com.entity.AlreadyPurchased;

public interface AlreadyPurchasedMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AlreadyPurchased record);

    int insertSelective(AlreadyPurchased record);

    AlreadyPurchased selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AlreadyPurchased record);

    int updateByPrimaryKey(AlreadyPurchased record);
}