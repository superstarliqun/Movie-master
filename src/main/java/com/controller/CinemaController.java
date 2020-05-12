package com.controller;

import com.entity.Cinema;
import com.github.pagehelper.PageInfo;
import com.service.CinemaService;
import com.util.RestResult;
import com.util.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 电影院管理
 *
 */
@RestController
@RequestMapping(value = "/Cinema")
public class CinemaController {

    @Autowired
    CinemaService cinemaService;

    /**
     * 查询所有的电影院信息
     * @return
     */
    @RequestMapping(value = "/getAllCinema")
    public RestResult getAllCinema(){
        return RestResult.ok( cinemaService.getAllCinema());
    }


    /**
     * 查询电影院中所有的区域分类显示
     */
    @GetMapping(value = "/findDropDownCinema")
    public RestResult findDropDownCinema(){
        return RestResult.ok(cinemaService.findDropDownCinema());
    }


    /**
     * 根据电影查询存在此电影的所有影院
     * 还可以根据区域划分将数据细化分
     */
    @GetMapping(value = "/findMovieByCinema")
    public RestResult findMovieByCinema(Integer movieId,String region){
        return RestResult.ok( cinemaService.findMovieByCinema(movieId,region));
    }

    /**
     * 分页显示影院信息操作
     * @param cinema
     * @param pageInfo
     * @return
     */
    @GetMapping(value = "/findCinemaPage")
    public RestResult findCinemaPage(Cinema cinema, PageInfo pageInfo){
        return RestResult.ok(cinemaService.findCinemaPage(cinema,pageInfo));
    }


    /**
     * 删除影院接口
     * @param id
     * @return
     */
    @PostMapping(value = "/delCinema")
    public RestResult delCinema(Integer id){
        cinemaService.deleteByPrimaryKey(id);
        return RestResult.ok();
    }


    /**
     * 新增影院功能 / 修改影院功能
     */
    @PostMapping(value = "/editCinema")
    public RestResult editCinema(Cinema cinema, HttpServletRequest request){
        if(cinema.getFile()!=null){
            cinema.setCinemaImgUrl(UploadUtils.getImgUrl(cinema.getFile(),request));
        }
        if(cinemaService.editCinema(cinema)>0){
            return RestResult.ok();
        }else{
            return RestResult.build(500,"操作失败，系统出现异常");
        }
    }


    /**
     * 查询单个影院功能
     */
    @PostMapping(value = "/findOneCinema")
    public RestResult findOneCinema(Integer Id){
        Cinema cinema = cinemaService.selectByPrimaryKey(Id);
        return RestResult.ok(cinema);
    }








}
