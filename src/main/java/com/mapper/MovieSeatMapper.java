package com.mapper;

import com.entity.MovieSeat;

public interface MovieSeatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MovieSeat record);

    int insertSelective(MovieSeat record);

    MovieSeat selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MovieSeat record);

    int updateByPrimaryKey(MovieSeat record);
}