package com.mapper;

import com.entity.CinemaMovieMiddle;

import java.util.List;
import java.util.Map;

public interface CinemaMovieMiddleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CinemaMovieMiddle record);

    int insertSelective(CinemaMovieMiddle record);

    CinemaMovieMiddle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CinemaMovieMiddle record);

    int updateByPrimaryKey(CinemaMovieMiddle record);

    List<Map<String,Object>> findCinemaMovieMiddlePage(CinemaMovieMiddle record);

    int exit(CinemaMovieMiddle record);

    List<Map<String,Object>> movie();

    List<Map<String,Object>> cinema();

}