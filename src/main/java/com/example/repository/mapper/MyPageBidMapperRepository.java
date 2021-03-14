package com.example.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Bidding;
@Repository
public class MyPageBidMapperRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Bidding> getAllBiddingListByUserId(String userId) {
		List<Bidding> resultList = sqlSession.getMapper(MyPageBidMapper.class).getAllBiddingListByUserId(userId);
		return resultList;
	}
	
	public List<Bidding> getEndBidList(String userId) {
		List<Bidding> resultList = sqlSession.getMapper(MyPageBidMapper.class).getEndBidList(userId);
		return resultList;
	}
	
	public List<Bidding> getBiddingList(String userId) {
		List<Bidding> resultList = sqlSession.getMapper(MyPageBidMapper.class).getBiddingList(userId);
		
		return resultList;
	}
	
	public Integer deleteMyBid(String bidId) {
		int result = sqlSession.getMapper(MyPageBidMapper.class).deleteMyBid(bidId);
		
		return result;
	}
}
