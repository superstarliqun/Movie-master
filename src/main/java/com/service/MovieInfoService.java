package com.service;

import com.entity.MovieInfo;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

public interface MovieInfoService {


    int deleteByPrimaryKey(Integer id);

    int insert(MovieInfo record);

    int editMovie(MovieInfo record);

    HashMap<String,Object> selectByPrimaryKey(MovieInfo movieInfo);

    int updateByPrimaryKeySelective(MovieInfo record);

    int updateByPrimaryKey(MovieInfo record);

    //查询主页正在热映，以及即将上映的数据
    List<MovieInfo> pageMainMovie();

    List<MovieInfo> Highest();

    List<MovieInfo> recommend();

    PageInfo findMoviePage(MovieInfo movieInfo, PageInfo pageInfo);

    List<MovieInfo> findTypeMovie(String type,String stauts);
}


