package com.controller;

import com.entity.MovieCategory;
import com.github.pagehelper.PageInfo;
import com.service.MovieCategoryService;
import com.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 电影分类管理模块
 */
@RestController
@RequestMapping(value = "/movieCategory")
public class MovieCategoryController {

    @Autowired
    MovieCategoryService movieCategoryService;


    @GetMapping(value = "/findMovieCategory")
    public RestResult findMovieCategory(){
        return RestResult.ok(movieCategoryService.findMovieCategory());
    }


    @GetMapping(value = "/findMovieCategoryPage")
    public RestResult findMovieCategoryPage(MovieCategory movieCategory, PageInfo pageInfo){
        return RestResult.ok(movieCategoryService.findMovieCategoryPage(movieCategory,pageInfo));
    }


    /**
     * 电影分类删除接口
     * @param id
     * @return
     */
    @PostMapping(value = "/delMovieCategory")
    public RestResult delmovieCategory(Integer id){
        if(movieCategoryService.deleteByPrimaryKey(id)>0){
            return RestResult.ok();
        }else{
            return RestResult.build(404,"该电影分类下有电影存在不能删除！");
        }
    }

    /**
     * 电影分类新增  / 修改接口
     * 通用接口
     * @param movieCategory
     * @return
     */
    @PostMapping(value = "/editMovieCategory")
    public RestResult editMovieCategory(MovieCategory movieCategory){
        try {
            if(movieCategory.getId()==null){
                //用户新增方法
                movieCategoryService.insertSelective(movieCategory);
            }else{
                //用户修改方法
                movieCategoryService.updateByPrimaryKeySelective(movieCategory);
            }
            return RestResult.ok();
        }catch (Exception e){
            e.printStackTrace();
            return RestResult.build(500,"系统异常，请稍后重试！");
        }
    }
    /**
     * 查询单个电影详情
     */
    @PostMapping(value = "/findOneMovieCategory")
    public RestResult findOneMovieCategory(Integer id){
        return RestResult.ok(movieCategoryService.selectByPrimaryKey(id));
    }


    /**
     * 查询电影分类列表
     */
    @GetMapping(value = "/MovieCategoryDropDown")
    public RestResult MovieCategoryDropDown(){
        return RestResult.ok( movieCategoryService.MovieCategoryDropDown());
    }



}
