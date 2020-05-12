package com.mapper;

import com.entity.MovieInfo;
import com.entity.MovieScene;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MovieSceneMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MovieScene record);

    int insertSelective(MovieScene record);

    MovieScene selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MovieScene record);

    int updateByPrimaryKey(MovieScene record);

    List<MovieScene> findScene(Integer movie_id,Integer cinema);

    Map<Integer, String> findSceneByMovie(Integer id);

    //根据场次id查询所有已经购买了的座位
    String findSceneList(Integer id);

    List<HashMap<String,Object>> findScenePage(MovieScene movieScene);

    List<HashMap<String, Object>> middleDropDown();
}