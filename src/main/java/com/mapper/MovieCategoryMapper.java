package com.mapper;

import com.entity.MovieCategory;

import java.util.List;

public interface MovieCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MovieCategory record);

    int insertSelective(MovieCategory record);

    MovieCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MovieCategory record);

    int updateByPrimaryKey(MovieCategory record);

    List<MovieCategory> findMovieCategory(MovieCategory record);

    int findExitCategory(Integer id);

    List<MovieCategory> MovieCategoryDropDown();
}