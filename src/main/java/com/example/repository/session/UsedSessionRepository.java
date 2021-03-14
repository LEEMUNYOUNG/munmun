package com.example.repository.session;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Used;

@Repository
public class UsedSessionRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String namespace = "com.example.repository.mapper.UsedMapper";
	
	public Integer insertUsed(Used used) {
		int result = sqlSession.insert(namespace + ".insertUsed", used);
		return result;
	}
}
