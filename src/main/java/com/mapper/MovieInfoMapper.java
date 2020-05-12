package com.mapper;

import com.entity.MovieInfo;import java.util.List;

public interface MovieInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MovieInfo record);

    int insertSelective(MovieInfo record);

    MovieInfo selectByPrimaryKey(MovieInfo movieInfo);

    int updateByPrimaryKeySelective(MovieInfo record);

    int updateByPrimaryKey(MovieInfo record);

    List<MovieInfo> pageMainMovie();

    List<MovieInfo> Highest();

    List<MovieInfo> recommend();

    List<MovieInfo> findMoviePage(MovieInfo movieInfo);

    List<MovieInfo> findAndScene(Integer id);

    List<MovieInfo> findTypeMovie(String type,String stauts);

}