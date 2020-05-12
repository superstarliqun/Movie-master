package com.controller;

import com.entity.Footprint;
import com.service.FootprintService;
import com.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 电影足迹管理模块
 */
@RestController
@RequestMapping(value = "/foorPrint")
public class FootprintControllrt {

    @Autowired
    FootprintService footprintService;


    /**
     * 添加用户足迹方法
     * @param footprint
     * @return
     */
    @PostMapping(value = "/addFootPrint")
    public RestResult addFootPrint(Footprint footprint){
        footprintService.insertSelective(footprint);
        return RestResult.ok();
    }
}
