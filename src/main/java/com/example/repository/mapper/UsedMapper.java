package com.example.repository.mapper;

import com.example.sproute.domain.Used;

public interface UsedMapper {
	Integer insertUsed(Used used);
	
	Used selectUsed(String itemId);
	
	void deleteUsed(String itemId);
}
