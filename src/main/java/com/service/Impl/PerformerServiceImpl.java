package com.service.Impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.entity.Performer;
import com.mapper.PerformerMapper;
import com.service.PerformerService;
@Service
public class PerformerServiceImpl implements PerformerService{

    @Resource
    private PerformerMapper performerMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return performerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Performer record) {
        return performerMapper.insert(record);
    }

    @Override
    public int insertSelective(Performer record) {
        return performerMapper.insertSelective(record);
    }

    @Override
    public Performer selectByPrimaryKey(Integer id) {
        return performerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Performer record) {
        return performerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Performer record) {
        return performerMapper.updateByPrimaryKey(record);
    }

}
