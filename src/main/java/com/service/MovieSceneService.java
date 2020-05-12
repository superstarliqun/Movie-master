package com.service;

import com.entity.MovieInfo;
import com.entity.MovieScene;
import com.github.pagehelper.PageInfo;
import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MovieSceneService{


    int deleteByPrimaryKey(Integer id);

    int insert(MovieScene record);

    int insertSelective(MovieScene record);

    MovieScene selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MovieScene record);

    int updateByPrimaryKey(MovieScene record);

    HashMap<String, Object> findScene(Integer movie_id,Integer cinema);

    Map<Integer, String> findSceneByMovie(Integer id);

    Integer editScene(MovieScene record);

    PageInfo findScenePage(MovieScene movieScene, PageInfo pageInfo);

    List<HashMap<String, Object>> middleDropDown();
}
