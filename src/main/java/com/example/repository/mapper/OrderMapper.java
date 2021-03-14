package com.example.repository.mapper;

import java.util.List;

import com.example.sproute.domain.Order;

public interface OrderMapper {
	
	void insertOrder(Order order);
	
	List<Order> selectOrderByUserId(String userId);
	
	List<Order> selectOrderByOrderDate(Order order);
	
	List<Order> selectOrderDate(String userId);
	
	void deleteOrder(String orderId);
}
