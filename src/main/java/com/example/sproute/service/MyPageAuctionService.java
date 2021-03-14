package com.example.sproute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.mapper.MyPageAuctionMapperRepository;
import com.example.sproute.domain.Auction;
@Service
public class MyPageAuctionService {

	@Autowired
	private MyPageAuctionMapperRepository myRepository;

	
	public List<Auction> getUserAuctionListByUserId(String auctionId) {
		return myRepository.getUserAuctionListByUserId(auctionId);
	}
	
	public Integer deleteMyAuctionItemByAutionId(String auctionId) {
		return myRepository.deleteMyAuctionItemByAutionId(auctionId);
	}
	
	public Integer deleteItem(String itemId) {
		return myRepository.deleteItem(itemId);
	}
	
	public Auction selectAuctionByAuctionId(String auctionId) {
		return myRepository.selectAuctionByAuctionId(auctionId);
	}
	
	public Integer updateMyAddAuctionItem(Auction auction) {
		return myRepository.updateMyAddAuctionItem(auction);
	}
}
