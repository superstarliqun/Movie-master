package com.service;

import com.entity.Performer;
public interface PerformerService{


    int deleteByPrimaryKey(Integer id);

    int insert(Performer record);

    int insertSelective(Performer record);

    Performer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Performer record);

    int updateByPrimaryKey(Performer record);

}
