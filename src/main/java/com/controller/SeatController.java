package com.controller;

import com.service.MovieSeatService;
import com.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 电影座位表模块管理
 */
@RestController
@RequestMapping(value = "/seat")
public class SeatController {

    @Autowired
    MovieSeatService movieSeatService;

    /**
     * 入参：
     *      是场次的id
     *返回参数:
     *      选座位的时候需要显示座位的序列   数组格式
     *      该有已经选中的座位号
     * @param id
     * @return
     */
    @RequestMapping(value = "/findMovieSeat")
    public RestResult findMovieSeat(Integer id){
        return RestResult.ok(movieSeatService.findMovieSeat(id));
    }



}
