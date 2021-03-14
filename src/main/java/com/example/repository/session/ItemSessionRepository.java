package com.example.repository.session;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Item;

@Repository
public class ItemSessionRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String namespace = "com.example.repository.mapper.ItemMapper";
	
	public Integer insertItem(Item item) {
		int result = sqlSession.insert(namespace + ".insertItem", item);
		return result;
	}
	public Integer updateAuctionItem(Item item) {
		int result = sqlSession.update(namespace + ".updateAuctionItem", item);
		return result;
	}
}
