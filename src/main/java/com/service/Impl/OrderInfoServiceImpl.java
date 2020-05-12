package com.service.Impl;

import com.entity.AlreadyPurchased;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.AlreadyPurchasedMapper;
import com.mapper.MovieSceneMapper;
import com.util.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.xml.crypto.Data;

import com.entity.OrderInfo;
import com.mapper.OrderInfoMapper;
import com.service.OrderInfoService;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService{

    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private MovieSceneMapper movieSceneMapper;

    @Autowired
    private AlreadyPurchasedMapper alreadyPurchasedMapper;


    @Override
    public int deleteByPrimaryKey(String id) {
        return orderInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderInfo record) {
        return orderInfoMapper.insert(record);
    }

    @Override
    @Transactional
    public int insertSelective(OrderInfo record) {
        //id随机数
        record.setId(RandomUtils.RandomUtils());
        //创建时间
        record.setCreateTime(new Date());
        //将座位变成不可选座位  首先查询出所有已经购买的座位，进行字符串拼接的形式，在保存到数据库中
        String sceneList = movieSceneMapper.findSceneList(record.getSceneId());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(sceneList);
        if(sceneList!=null&&sceneList!=""){
            stringBuffer.append(","+record.getSeatNumber());
        }
        AlreadyPurchased alreadyPurchased = new AlreadyPurchased();
        alreadyPurchased.setId(record.getSceneId());
        alreadyPurchased.setArray(stringBuffer.toString());
        alreadyPurchasedMapper.updateByPrimaryKeySelective(alreadyPurchased);
        return orderInfoMapper.insertSelective(record);
    }

    @Override
    public HashMap<String,Object> selectByPrimaryKey(String id) {
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderInfo record) {
        return orderInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateStauts(String OrderNumber,Integer stauts) {
        return orderInfoMapper.updateStauts(OrderNumber,stauts);
    }

    @Override
    public PageInfo findOrderPage(OrderInfo orderInfo, PageInfo pageInfo) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        List<OrderInfo> list = orderInfoMapper.findOrderPage(orderInfo);
        return new PageInfo(list);
    }

    @Override
    public List<HashMap<String,Object>> findByUserOrder(Integer userId) {
        return orderInfoMapper.findByUserOrder(userId);
    }

    @Override
    public Object findOrderTime(Integer id) {
        ArrayList list = new ArrayList();
        Date dateNow = new Date();
        long time = 30*60*1000;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        List<HashMap<String, Object>> orderTime = orderInfoMapper.findOrderTime(id);
        for(HashMap<String, Object> map:orderTime){
            String strDate = (String)map.get("projection_time");
            try {
                Date date=simpleDateFormat.parse(strDate);
                if(dateNow.getTime()+time>date.getTime()){
                    list.add(map.get("id"));
                }
            } catch(ParseException px) {
                px.printStackTrace();
            }
        }
        return list;
    }

}
