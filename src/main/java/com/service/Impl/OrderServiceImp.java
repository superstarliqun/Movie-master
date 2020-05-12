package com.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Order;
import com.github.pagehelper.PageInfo;
import com.service.IOrderService;

@Service
public class OrderServiceImp implements IOrderService{


	@Override
	public Order findOrderById(String order_id) {
		return null;
	}

	@Override
	public Integer addOrder(Order order) {
		return null;
	}

	@Override
	public Integer updateOrderStateToRefund(String order_id) {
		return null;
	}

	@Override
	public Integer updateOrderStateToRefunded(String order_id) {
		return null;
	}

	@Override
	public PageInfo<Order> findOrdersByUserName(Integer page, Integer limit, String user_name) {
		return null;
	}

	@Override
	public List<Order> findAllOrders() {
		return null;
	}

	@Override
	public List<Order> findRefundOrderByUserName(String user_name) {
		return null;
	}

	@Override
	public PageInfo<Order> findOrdersByState(Integer page, Integer limit, int order_state) {
		return null;
	}

	@Override
	public PageInfo<Order> findAllOrdersBySplitPage(Integer page, Integer limit, String keyword) {
		return null;
	}
}
