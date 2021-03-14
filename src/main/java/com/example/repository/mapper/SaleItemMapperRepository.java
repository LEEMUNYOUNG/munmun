package com.example.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Item;
import com.example.sproute.domain.Product;

@Repository
public class SaleItemMapperRepository {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Item> getItemListByCategory(String categoryId) {
		List<Item> resultList = sqlSession.getMapper(SaleItemMapper.class).getItemListByCategory(categoryId);
		
		return resultList;
	}
	
	public List<Item> getItemListByProduct(Product product) {
		List<Item> resultList = sqlSession.getMapper(SaleItemMapper.class).getItemListByProduct(product);
		
		return resultList;
	}
	
	public Item getItem(String itemId) {
		Item result = sqlSession.getMapper(SaleItemMapper.class).getItem(itemId);
		
		return result;
		
	}
}
