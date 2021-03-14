package com.example.repository.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Used;

@Repository
public class UsedMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Integer insertUsed(Used used) {
		Integer result = sqlSession.getMapper(UsedMapper.class).insertUsed(used);
		return result;
	}
	
	public Used selectUsed(String itemId) {
		Used used = sqlSession.getMapper(UsedMapper.class).selectUsed(itemId);
		return used;
	}
	
	public void deleteUsed(String itemId) {
		sqlSession.getMapper(UsedMapper.class).deleteUsed(itemId);
	}
}
