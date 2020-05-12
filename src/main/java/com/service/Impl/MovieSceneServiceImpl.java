package com.service.Impl;

import com.entity.Cinema;
import com.entity.MovieInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.CinemaMapper;
import com.mapper.MovieInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.MovieScene;
import com.mapper.MovieSceneMapper;
import com.service.MovieSceneService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieSceneServiceImpl implements MovieSceneService{

    @Autowired
    private MovieSceneMapper movieSceneMapper;

    @Autowired
    private MovieInfoMapper movieInfoMapper;

    @Autowired
    private CinemaMapper cinemaMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return movieSceneMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MovieScene record) {
        return movieSceneMapper.insert(record);
    }

    @Override
    public int insertSelective(MovieScene record) {
        return movieSceneMapper.insertSelective(record);
    }

    @Override
    public MovieScene selectByPrimaryKey(Integer id) {
        return movieSceneMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(MovieScene record) {
        return movieSceneMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MovieScene record) {
        return movieSceneMapper.updateByPrimaryKey(record);
    }

    /**
     * 根据id查询影院的基本信息
     * 根据电影id查询该电影的基本信息
     * 查询该电影院与该电影的播放时间
     * @param movie_id
     * @param cinema
     * @return
     */
    @Override
    @Transactional
    public HashMap<String, Object> findScene(Integer movie_id,Integer cinema) {
        HashMap<String,Object> map = new HashMap<String,Object>();
        //放映时间   查询的是中间表的id
        List<MovieScene> scene = movieSceneMapper.findScene(movie_id,cinema);

        //电影院基本信息
        Cinema andCinema = cinemaMapper.selectByPrimaryKey(cinema);

        //电影基本信息
        MovieInfo movieInfo = new MovieInfo();
        movieInfo.setId(movie_id);
        MovieInfo andScene = movieInfoMapper.selectByPrimaryKey(movieInfo);
        map.put("scene",scene);
        map.put("cinema",andCinema);
        map.put("movieInfo",andScene);
        return map;
    }

    @Override
    public Map<Integer, String> findSceneByMovie(Integer id) {
        return movieSceneMapper.findSceneByMovie(id);
    }

    @Override
    public Integer editScene(MovieScene record) {
        try {
            int stauts = 0;
            if(record.getId()==null){
                //新增功能
                record.setCreateTime(new Date());
                stauts = movieSceneMapper.insertSelective(record);
            }else{
                //修改功能
                stauts = movieSceneMapper.updateByPrimaryKeySelective(record);
            }
            return stauts;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    public PageInfo findScenePage(MovieScene movieScene, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<HashMap<String, Object>> scenePage = movieSceneMapper.findScenePage(movieScene);
        return new PageInfo(scenePage);
    }

    @Override
    public List<HashMap<String, Object>> middleDropDown() {
        return movieSceneMapper.middleDropDown();
    }
}
