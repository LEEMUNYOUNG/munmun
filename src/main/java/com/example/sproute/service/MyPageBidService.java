package com.example.sproute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.mapper.MyPageBidMapperRepository;
import com.example.sproute.domain.Bidding;
@Service
public class MyPageBidService {
	
	@Autowired
	private MyPageBidMapperRepository myRepository;
	
	
	public List<Bidding> getAllBiddingListByUserId(String userId) {
		return myRepository.getAllBiddingListByUserId(userId);
	}
	
	public List<Bidding> getEndBidList(String userId) {
		return myRepository.getEndBidList(userId);
	}
	
	public List<Bidding> getBiddingList(String userId) {
		return myRepository.getBiddingList(userId);
	}
	
	public Integer deleteMyBid(String bidId) {
		return myRepository.deleteMyBid(bidId); 
	}
}
