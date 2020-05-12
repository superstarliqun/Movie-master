package com.controller;

import com.entity.SceneSeatMiddle;
import com.github.pagehelper.PageInfo;
import com.service.SceneSeatMiddleService;
import com.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/SceneSeatMiddle")
public class SceneSeatMiddleControllrt {


    @Autowired
    private SceneSeatMiddleService sceneSeatMiddleService;

    /**
     * 删除场次座位中间表
     * @param id
     * @return
     */
    @PostMapping(value = "/delSceneSeatMiddle")
    public RestResult delSceneSeatMiddle(Integer id){
        sceneSeatMiddleService.deleteByPrimaryKey(id);
        return RestResult.ok();
    }

    /**
     * 编辑 / 修改  次座位中间表
     * @param sceneSeatMiddle
     * @return
     */
    @PostMapping(value = "/editSceneSeatMiddle")
    public RestResult editSceneSeatMiddle(SceneSeatMiddle sceneSeatMiddle){
        int i = sceneSeatMiddleService.editSceneSeatMiddle(sceneSeatMiddle);
        if(i==0){
            return RestResult.build(500,"请求失败请稍等重试！");
        }else if(i==-5){
            return RestResult.build(500,"信息已存在，请稍后重试！");
        }else{
            return RestResult.ok();
        }
    }

    /**
     * 分页查询次座位中间表
     * @param sceneSeatMiddle
     * @param pageInfo
     * @return
     */
    @GetMapping(value = "findSceneSeatMiddlePage")
    public RestResult findSceneSeatMiddlePage(SceneSeatMiddle sceneSeatMiddle, PageInfo pageInfo){
        return RestResult.ok(sceneSeatMiddleService.findSceneSeatMiddlePage(sceneSeatMiddle, pageInfo));
    }


    /**
     * 查询单个场次座位中间表
     */
    @GetMapping(value = "/findOneSceneSeatMiddle")
    public RestResult findOneSceneSeatMiddle(Integer id){
        return RestResult.ok(sceneSeatMiddleService.selectByPrimaryKey(id));
    }

    @GetMapping(value = "/DropDown")
    public RestResult DropDown(){
        return RestResult.ok(sceneSeatMiddleService.DropDown());
    }

}
