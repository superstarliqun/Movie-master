package com.mapper;

import com.entity.Performer;

import java.util.List;

public interface PerformerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Performer record);

    int insertSelective(Performer record);

    Performer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Performer record);

    int updateByPrimaryKey(Performer record);

    List<Performer> selectByPerformer(Integer id);
}