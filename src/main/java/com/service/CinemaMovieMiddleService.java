package com.service;

import com.entity.CinemaMovieMiddle;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CinemaMovieMiddleService{


    int deleteByPrimaryKey(Integer id);

    int editCinemaMovieMiddle(CinemaMovieMiddle record);

    CinemaMovieMiddle selectByPrimaryKey(Integer id);

    PageInfo findCinemaMovieMiddlePage(CinemaMovieMiddle record, PageInfo pageInfo);

    HashMap<String,Object> DropDown();

}
