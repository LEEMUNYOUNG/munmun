package com.example.sproute.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.mapper.UsedMapperRepository;
import com.example.sproute.domain.Used;

@Service
public class UsedService {
	@Autowired
	private UsedMapperRepository UsedRepository;
	
	public Integer insertUsed(Used used) {
		return UsedRepository.insertUsed(used);
	}
	
	public Used selectUsed(String itemId) {
		return UsedRepository.selectUsed(itemId);
	}
	
	public void deleteUsed(String itemId) {
		UsedRepository.deleteUsed(itemId);
	}
}
