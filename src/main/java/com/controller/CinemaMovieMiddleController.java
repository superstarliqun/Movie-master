package com.controller;

import com.entity.CinemaMovieMiddle;
import com.github.pagehelper.PageInfo;
import com.service.CinemaMovieMiddleService;
import com.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/CinemaMovieMiddle")
public class CinemaMovieMiddleController {

    @Autowired
    private CinemaMovieMiddleService cinemaMovieMiddleService;

    /**
     * 分页查询电影影院关联信息
     * @return
     */
    @GetMapping(value = "/findCinemaMovieMiddlePage")
    public RestResult findCinemaMovieMiddlePage(CinemaMovieMiddle cinemaMovieMiddle,PageInfo pageInfo){
        return RestResult.ok( cinemaMovieMiddleService.findCinemaMovieMiddlePage(cinemaMovieMiddle,pageInfo));
    }

    /**
     * 添加/ 修改   电影与影院中间表
     * @param cinemaMovieMiddle
     * @return
     */
    @PostMapping(value = "/editCinemaMovieMiddle")
    public RestResult editCinemaMovieMiddle(CinemaMovieMiddle cinemaMovieMiddle){
       int i =  cinemaMovieMiddleService.editCinemaMovieMiddle(cinemaMovieMiddle);
        if(i>0){
            return RestResult.ok();
        }else if(i==-5){
            return RestResult.build(500,"请求失败，数据已经存在！");
        }else{
            return RestResult.build(500,"请求失败，请查看信息后重试！");
        }
    }

    /**
     * 删除电影与影院中间表
     */
    @PostMapping(value = "/delCinemaMovieMiddle")
    public RestResult delCinemaMovieMiddle(Integer id){
        cinemaMovieMiddleService.deleteByPrimaryKey(id);
        return RestResult.ok();
    }


    /**
     * 查询单个信息
     */
    @PostMapping(value = "/findOneCinemaMovieMiddle")
    public RestResult findOneCinemaMovieMiddle(Integer id){
        return RestResult.ok(cinemaMovieMiddleService.selectByPrimaryKey(id));
    }


    @GetMapping(value = "/DropDown")
    public RestResult DropDown(){
        return RestResult.ok(cinemaMovieMiddleService.DropDown());
    }
}
