package com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.entity.CinemaMovieMiddle;
import com.mapper.CinemaMovieMiddleMapper;
import com.service.CinemaMovieMiddleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CinemaMovieMiddleServiceImpl implements CinemaMovieMiddleService{

    @Resource
    private CinemaMovieMiddleMapper cinemaMovieMiddleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return cinemaMovieMiddleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int editCinemaMovieMiddle(CinemaMovieMiddle record) {
        if(cinemaMovieMiddleMapper.exit(record)==0){
            int number = 0;
            if(record.getId()==null){
                number = cinemaMovieMiddleMapper.insertSelective(record);
                //添加方法
            }else{
                //修改方法
                number = cinemaMovieMiddleMapper.updateByPrimaryKeySelective(record);
            }
            return number;
        }else{
            return -5;
        }
    }

    @Override
    public CinemaMovieMiddle selectByPrimaryKey(Integer id) {
        return cinemaMovieMiddleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo findCinemaMovieMiddlePage(CinemaMovieMiddle record, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<Map<String, Object>> cinemaMovieMiddlePage = cinemaMovieMiddleMapper.findCinemaMovieMiddlePage(record);
        return new PageInfo(cinemaMovieMiddlePage);
    }

    @Override
    public HashMap<String, Object> DropDown() {
        HashMap<String,Object> map = new HashMap<>();
        List<Map<String, Object>> movie = cinemaMovieMiddleMapper.movie();
        List<Map<String, Object>> cinema = cinemaMovieMiddleMapper.cinema();
        map.put("movie",movie);
        map.put("cinema",cinema);
        return map;
    }

}
