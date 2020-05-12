package com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mapper.MovieCategoryMapper;
import com.entity.MovieCategory;
import com.service.MovieCategoryService;

import java.util.Date;
import java.util.List;

@Service
public class MovieCategoryServiceImpl implements MovieCategoryService{

    @Resource
    private MovieCategoryMapper movieCategoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        if(movieCategoryMapper.findExitCategory(id)>0){
            return -5;
        }else{
            return movieCategoryMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int insert(MovieCategory record) {
        return movieCategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(MovieCategory record) {
        record.setCreateTime(new Date());
        return movieCategoryMapper.insertSelective(record);
    }

    @Override
    public MovieCategory selectByPrimaryKey(Integer id) {
        return movieCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MovieCategory record) {
        return movieCategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MovieCategory record) {
        return movieCategoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MovieCategory> findMovieCategory() {
        MovieCategory movieCategory = new MovieCategory();
        return movieCategoryMapper.findMovieCategory(movieCategory);
    }

    @Override
    public PageInfo findMovieCategoryPage(MovieCategory movieCategory, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<MovieCategory> movieCategory1 = movieCategoryMapper.findMovieCategory(movieCategory);
        return new PageInfo(movieCategory1);
    }

    @Override
    public List<MovieCategory> MovieCategoryDropDown() {
        return movieCategoryMapper.MovieCategoryDropDown();
    }

}
