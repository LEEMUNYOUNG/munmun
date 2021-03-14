package com.example.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Order;

@Repository
public class OrderMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public void insertOrder(Order order) {
		sqlSession.getMapper(OrderMapper.class).insertOrder(order);
	}
	
	public List<Order> selectOrderByUserId(String userId) {
		return sqlSession.getMapper(OrderMapper.class).selectOrderByUserId(userId);
	}
	
	public List<Order> selectOrderByOrderDate(Order order) {
		return sqlSession.getMapper(OrderMapper.class).selectOrderByOrderDate(order);
	}
	
	public void deleteOrder(String orderId) {
		sqlSession.getMapper(OrderMapper.class).deleteOrder(orderId);
	}
}
