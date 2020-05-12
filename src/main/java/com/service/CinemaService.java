package com.service;

import com.entity.Cinema;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CinemaService {


    int deleteByPrimaryKey(Integer id);

    int insert(Cinema record);

    int insertSelective(Cinema record);

    Cinema selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cinema record);

    int updateByPrimaryKey(Cinema record);

    List<Cinema> getAllCinema();

    List<Cinema> findDropDownCinema();

    List<Cinema> findMovieByCinema(Integer movieId, String region);

    PageInfo<Cinema> findCinemaPage(Cinema cinema, PageInfo pageInfo);

    int editCinema(Cinema record);



}



