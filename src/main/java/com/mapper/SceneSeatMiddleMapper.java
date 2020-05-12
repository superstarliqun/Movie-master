package com.mapper;

import com.entity.SceneSeatMiddle;import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface SceneSeatMiddleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SceneSeatMiddle record);

    int insertSelective(SceneSeatMiddle record);

    SceneSeatMiddle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SceneSeatMiddle record);

    int updateByPrimaryKey(SceneSeatMiddle record);

    int exit(SceneSeatMiddle record);

    List<HashMap<String,Object>>  findSceneSeatMiddlePage(SceneSeatMiddle record);

    List<HashMap<String,Object>> scene();

    List<HashMap<String,Object>> seat();



}