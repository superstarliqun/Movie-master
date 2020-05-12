package com.service.Impl;

import com.entity.Performer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PerformerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.entity.MovieInfo;
import com.mapper.MovieInfoMapper;
import com.service.MovieInfoService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

    @Resource
    private MovieInfoMapper movieInfoMapper;

    @Autowired
    PerformerMapper performerMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return movieInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MovieInfo record) {
        return movieInfoMapper.insert(record);
    }

    @Override
    public int editMovie(MovieInfo record) {
        int number = 0;
        if(record.getId()==null){
            record.setCreateTime(new Date());
            number = movieInfoMapper.insertSelective(record);
        }else{
            number = movieInfoMapper.updateByPrimaryKeySelective(record);
        }
        return number;
    }
    @Override
    public HashMap<String,Object> selectByPrimaryKey(MovieInfo movieInfo) {
        HashMap<String,Object> map = new HashMap<>();
        //查询电影详情
        MovieInfo movieInfo1 = movieInfoMapper.selectByPrimaryKey(movieInfo);
        //查询演员列表
        if(movieInfo1!=null){
            List<Performer> performers = performerMapper.selectByPerformer(movieInfo1.getId());
            map.put("performers",performers);
        }
        map.put("movieInfo",movieInfo1);
        return map;
    }

    @Override
    public int updateByPrimaryKeySelective(MovieInfo record) {
        return movieInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MovieInfo record) {
        return movieInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<MovieInfo> pageMainMovie() {
        return movieInfoMapper.pageMainMovie();
    }

    @Override
    public List<MovieInfo> Highest() {
        return movieInfoMapper.Highest();
    }

    @Override
    public List<MovieInfo> recommend() {
        return movieInfoMapper.recommend();
    }

    @Override
    public PageInfo findMoviePage(MovieInfo movieInfo, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<MovieInfo> list = movieInfoMapper.findMoviePage(movieInfo);
        return new PageInfo(list);
    }

    @Override
    public List<MovieInfo> findTypeMovie(String type,String stauts) {
        return movieInfoMapper.findTypeMovie(type,stauts);
    }
}


