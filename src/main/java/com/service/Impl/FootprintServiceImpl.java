package com.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.entity.Footprint;
import com.mapper.FootprintMapper;
import com.service.FootprintService;

import java.util.Date;

@Service
public class FootprintServiceImpl implements FootprintService{

    @Resource
    private FootprintMapper footprintMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return footprintMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Footprint record) {
        return footprintMapper.insert(record);
    }

    @Override
    public int insertSelective(Footprint record) {
        record.setCreateTime(new Date());
        return footprintMapper.insertSelective(record);
    }

    @Override
    public Footprint selectByPrimaryKey(Integer id) {
        return footprintMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Footprint record) {
        return footprintMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Footprint record) {
        return footprintMapper.updateByPrimaryKey(record);
    }

}
