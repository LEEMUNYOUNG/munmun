package com.example.repository.session;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Item;

@Repository
public class SaleItemSessionRepository {
	private SqlSessionTemplate sqlSession;
	
	private final String namespace = "com.example.repository.mapper.SaleItemMapper";
	
	public List<Item> getItemListByCategory(String categoryId) {
		List<Item> resultList = sqlSession.selectList(namespace + ".getItemListByCategory", categoryId);
		return resultList;
	}
	
	public List<Item> getItemListByProduct(String productId) {
		List<Item> resultList = sqlSession.selectList(namespace + ".getItemListByProduct", productId);
		return resultList;
	}
	
	public Item getItem(String itemId) {
		Item result = sqlSession.selectOne(namespace + ".getItem", itemId);
		return result;
		
	}
	
}





