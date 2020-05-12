package com.service;

import com.entity.OrderInfo;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

public interface OrderInfoService{


    int deleteByPrimaryKey(String id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    HashMap<String,Object> selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    int updateStauts(String OrderNumber,Integer stauts);

    PageInfo findOrderPage(OrderInfo orderInfo, PageInfo pageInfo);

    List<HashMap<String,Object>> findByUserOrder(Integer userId);

    Object findOrderTime(Integer id);


}
