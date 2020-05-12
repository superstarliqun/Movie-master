package com.controller;

import com.entity.MovieScene;
import com.github.pagehelper.PageInfo;
import com.service.MovieSceneService;
import com.util.RestResult;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 场次管理魔模块
 */
@RestController
@RequestMapping(value = "/scene")
public class SceneController {

    @Autowired
    MovieSceneService movieSceneService;


    /**
     * 根据id查询影院的基本信息
     *根据电影id查询该电影的基本信息
     *查询该电影院与该电影的播放时间
     */
    @GetMapping(value = "/findScene")
    public RestResult findScene(Integer movie_id,Integer cinema){
        return  RestResult.ok(movieSceneService.findScene(movie_id,cinema));
    }


    /**
     * 根据场次id查询电影详细信息
     */
    @RequestMapping(value = "/findSceneByMovie")
    public RestResult findSceneByMovie(Integer id){
        return RestResult.ok( movieSceneService.findSceneByMovie(id));
    }

    /**
     * 查询场次信息
     * @param movieScene
     * @param pageInfo
     * @return
     */
    @GetMapping(value = "/findScenePage")
    public RestResult findScenePage(MovieScene movieScene, PageInfo pageInfo){
        return RestResult.ok(movieSceneService.findScenePage(movieScene,pageInfo));
    }

    /**
     * 删除场次信息
     */
    @GetMapping(value = "/delScene")
    public RestResult delScene(Integer id){
        if(movieSceneService.deleteByPrimaryKey(id)>0){
            return RestResult.ok();
        }else{
            return RestResult.build(404,"未找到该场次信息");
        }
    }


    /**
     * 修改场次信息  /  新增场次信息
     */
    @PostMapping(value = "/editScene")
    public RestResult editScene(MovieScene movieScene){
        if(movieSceneService.editScene(movieScene)>0){
            return RestResult.ok();
        } else{
            return RestResult.build(404,"添加或修改未成功！");
        }
    }


    /**
     * 查询电影与影院的新增
     */
    @GetMapping(value = "/middleDropDown")
    public RestResult middleDropDown(){
        return RestResult.ok(movieSceneService.middleDropDown());
    }

    /**
     * 查询单个电影
     * @param id
     * @return
     */
    @GetMapping(value = "/findOnescene")
    public RestResult findOnescene(Integer id){
        return RestResult.ok(movieSceneService.selectByPrimaryKey(id));
    }









}
