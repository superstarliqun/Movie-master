package com.mapper;

import com.entity.Cinema;import java.util.List;

public interface CinemaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cinema record);

    int insertSelective(Cinema record);

    Cinema selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cinema record);

    int updateByPrimaryKey(Cinema record);

    List<Cinema> getAllCinema(Cinema record);

    List<Cinema> findDropDownCinema();

    List<Cinema> findMovieByCinema(Integer movieId, String region);

}