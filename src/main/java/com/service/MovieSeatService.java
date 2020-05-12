package com.service;

import com.entity.MovieSeat;

import java.util.HashMap;

public interface MovieSeatService{


    int deleteByPrimaryKey(Integer id);

    int insert(MovieSeat record);

    int insertSelective(MovieSeat record);

    MovieSeat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MovieSeat record);

    int updateByPrimaryKey(MovieSeat record);

    HashMap<String,Object> findMovieSeat(Integer id);

}
