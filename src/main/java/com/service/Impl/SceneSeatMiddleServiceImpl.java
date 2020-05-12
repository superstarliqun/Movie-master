package com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mapper.SceneSeatMiddleMapper;
import com.entity.SceneSeatMiddle;
import com.service.SceneSeatMiddleService;

import java.util.HashMap;
import java.util.List;

@Service
public class SceneSeatMiddleServiceImpl implements SceneSeatMiddleService {

    @Resource
    private SceneSeatMiddleMapper sceneSeatMiddleMapper;


    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sceneSeatMiddleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SceneSeatMiddle selectByPrimaryKey(Integer id) {
        return sceneSeatMiddleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int editSceneSeatMiddle(SceneSeatMiddle sceneSeatMiddle) {
        int number = 0;
        if(sceneSeatMiddleMapper.exit(sceneSeatMiddle)==0){
            if(sceneSeatMiddle.getId()==null){
                //新增
                number = sceneSeatMiddleMapper.insertSelective(sceneSeatMiddle);
            }else{
                //修改
                number = sceneSeatMiddleMapper.updateByPrimaryKeySelective(sceneSeatMiddle);
            }
        }else{
            number = -5;
        }
        return number;
    }

    @Override
    public PageInfo findSceneSeatMiddlePage(SceneSeatMiddle sceneSeatMiddle, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        return new PageInfo(sceneSeatMiddleMapper.findSceneSeatMiddlePage(sceneSeatMiddle));
    }

    @Override
    public HashMap<String, Object> DropDown() {
        HashMap<String,Object> map = new HashMap<>();
        List<HashMap<String, Object>> scene = sceneSeatMiddleMapper.scene();
        List<HashMap<String, Object>> seat = sceneSeatMiddleMapper.seat();
        map.put("scene",scene);
        map.put("seat",seat);
        return map;
    }
}

