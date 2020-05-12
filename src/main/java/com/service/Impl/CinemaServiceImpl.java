package com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.entity.Cinema;
import com.mapper.CinemaMapper;
import com.service.CinemaService;

import java.util.Date;
import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Resource
    private CinemaMapper cinemaMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {

        return cinemaMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Cinema record) {
        return cinemaMapper.insert(record);
    }

    @Override
    public int insertSelective(Cinema record) {
        return cinemaMapper.insertSelective(record);
    }

    @Override
    public Cinema selectByPrimaryKey(Integer id) {
        return cinemaMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Cinema record) {
        return cinemaMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Cinema record) {
        return cinemaMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Cinema> getAllCinema() {
        Cinema cinema = new Cinema();
        return cinemaMapper.getAllCinema(cinema);
    }

    @Override
    public List<Cinema> findDropDownCinema() {
        return cinemaMapper.findDropDownCinema();
    }

    @Override
    public List<Cinema> findMovieByCinema(Integer movieId, String region) {
        return cinemaMapper.findMovieByCinema(movieId, region);
    }

    @Override
    public PageInfo<Cinema> findCinemaPage(Cinema cinema, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        //需要判断是什么角色来查询电影院信息   超级管理员查询全部     影院管理员查询自己的影院
        if(cinema.getManagerUserId()!=null&&cinema.getManagerUserId()==1){
            cinema.setManagerUserId(null);
        }
        List<Cinema> allCinema = cinemaMapper.getAllCinema(cinema);
        return new PageInfo(allCinema);
    }

    @Override
    public int editCinema(Cinema record) {
        try {
            if(record.getId()==null){
                //新增操作
                record.setCreateTime(new Date());
                return cinemaMapper.insertSelective(record);
            }else{
                //修改操作
                return cinemaMapper.updateByPrimaryKeySelective(record);
            }
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}



