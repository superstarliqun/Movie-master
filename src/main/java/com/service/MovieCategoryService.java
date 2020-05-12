package com.service;

import com.entity.MovieCategory;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface MovieCategoryService{


    int deleteByPrimaryKey(Integer id);

    int insert(MovieCategory record);

    int insertSelective(MovieCategory record);

    MovieCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MovieCategory record);

    int updateByPrimaryKey(MovieCategory record);

    List<MovieCategory> findMovieCategory();

    PageInfo findMovieCategoryPage(MovieCategory movieCategory, PageInfo pageInfo);

    List<MovieCategory> MovieCategoryDropDown();

}
