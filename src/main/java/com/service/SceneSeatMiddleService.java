package com.service;

import com.entity.SceneSeatMiddle;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;

public interface SceneSeatMiddleService {

    int deleteByPrimaryKey(Integer id);

    SceneSeatMiddle selectByPrimaryKey(Integer id);

    int editSceneSeatMiddle(SceneSeatMiddle sceneSeatMiddle);

    PageInfo findSceneSeatMiddlePage(SceneSeatMiddle sceneSeatMiddle, PageInfo pageInfo);

    HashMap<String,Object> DropDown();
}

