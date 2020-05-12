package com.controller;

import com.entity.OrderInfo;
import com.github.pagehelper.PageInfo;
import com.service.OrderInfoService;
import com.util.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理模块
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderInfoService orderInfoService;


    @PostMapping(value = "/savePayOrder")
    public RestResult savePayOrder(OrderInfo orderInfo){
        try {
            orderInfoService.insertSelective(orderInfo);
            return RestResult.ok(orderInfo.getId());
        }catch (Exception e){
            e.printStackTrace();
            return RestResult.build(500,"保存失败");
        }
    }

    /**
     * 根据订单编号修改订单状态
     * @param orderNumber
     * @param stauts
     * @return
     */
    @RequestMapping(value = "/updateStauts")
    public RestResult updateStauts(String orderNumber,Integer stauts){
        if(orderInfoService.updateStauts(orderNumber,stauts)>0){
            return RestResult.ok();
        }else{
            return RestResult.build(404,"暂无订单");
        }
    }

    /**
     * 分页查询订单列表
     * @param orderInfo
     * @param pageInfo
     * @return
     */
    @RequestMapping(value = "/findOrderPage")
    public RestResult findOrderPage(OrderInfo orderInfo, PageInfo pageInfo){
        return RestResult.ok(orderInfoService.findOrderPage(orderInfo,pageInfo));
    }

    /**
     * 查询单一的订单
     * @param id
     * @return
     */
    @GetMapping(value = "/findOneOrder")
    public RestResult findOneOrder(String id){
        return RestResult.ok( orderInfoService.selectByPrimaryKey(id));
    }


    /**
     * 查询该用户的所有订单
     */
    @GetMapping(value = "/findByUserOrder")
    public RestResult findByUserOrder(Integer userId){
        return  RestResult.ok(orderInfoService.findByUserOrder(userId));
    }



    @GetMapping(value = "/findOrderTime")
    public RestResult findOrderTime(Integer id){
        return RestResult.ok(orderInfoService.findOrderTime(id));
    }
}
