package com.example.repository.mapper;

import java.util.List;

import com.example.sproute.domain.Bidding;

public interface MyPageBidMapper {

	List<Bidding> getAllBiddingListByUserId(String userId); //유저가 신청한 입찰 전체 출력 
	
	//경매시간이 종료된 입찰
	List<Bidding> getEndBidList(String userId); //유저가 신청한 입찰 중에 경매시간이 종료된 입찰
	
	//경매진행중인 입찰
	List<Bidding> getBiddingList(String userId); //경매 진행 중인 입찰
	
	Integer deleteMyBid(String bidId);
}

