package com.example.repository.session;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Account;

@Repository
public class AccountSessionRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String namespace = "com.example.repository.mapper.AccountMapper";
	
	//회원 가입
	public int insertMember(Account account) {
		return sqlSession.insert(namespace + ".insertMember", account);
	}
	
	//전체 회원 목록
	public List<Account> memberList() {
		List<Account> memberList = sqlSession.selectList(namespace + ".selectMemberList"); 
		
		return memberList;
	}
	
	//특정 회원 목록
	public Account memberListByUserId(String userId) {
		Account account = sqlSession.selectOne(namespace + ".selectMemberListbyUserId", userId);
		
		return account;
	}
	
	//회원 정보 수정
	public int modifyMember(Account account) {
		return sqlSession.update(namespace + ".modifyMember", account);
	}
	
	
}
