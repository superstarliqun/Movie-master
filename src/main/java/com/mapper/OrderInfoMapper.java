package com.mapper;

import com.entity.OrderInfo;

import java.util.HashMap;
import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    HashMap<String,Object> selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    int updateStauts(String OrderNumber,Integer stauts);

    List<OrderInfo> findOrderPage(OrderInfo orderInfo);

    List<HashMap<String,Object>> findByUserOrder(Integer userId);

    List<HashMap<String,Object>> findOrderTime(Integer id);
}