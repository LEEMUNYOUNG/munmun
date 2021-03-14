package com.example.sproute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.session.AccountSessionRepository;
import com.example.sproute.domain.Account;

@Service
public class AccountService {
	
	@Autowired
	private AccountSessionRepository accountRepository;
	
	//회원 가입
	public int insertMember(Account account) {
		return accountRepository.insertMember(account);
	}
	
	//전체 회원 목록 조회
	public List<Account> selectMemberList() {
		return accountRepository.memberList();
	}
	
	//특정 회원 목록 객체
	public Account selectMemberListByUserId(String userId) {
		return accountRepository.memberListByUserId(userId);
	}
	
	//회원 정보 수정
	public int modifyMember(Account account) {
		return accountRepository.modifyMember(account);
	}

}
