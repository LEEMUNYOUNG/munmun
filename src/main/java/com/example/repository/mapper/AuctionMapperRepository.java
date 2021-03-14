package com.example.repository.mapper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Auction;
import com.example.sproute.domain.Bidding;

@Repository
public class AuctionMapperRepository {
	@Autowired
	private AuctionMapper auctionMapper;
	
	public Integer insertAuctionItem(Auction auction) {
		return auctionMapper.insertAuctionItem(auction);
	}
	
	public Auction selectAuction(String itemId) {
		return auctionMapper.selectAuction(itemId);
	}
	
	public Auction updateAuction(Auction auction) {
		return auctionMapper.updateAuction(auction);
	}
	
	public Integer deleteAuction(String itemId) {
		return auctionMapper.deleteAuction(itemId);
	}
	
	public Integer maxPriceAuction(String auctionId) {
		return auctionMapper.maxPriceAuction(auctionId);
	}
	
	public Integer bidCount(String auctionId) {
		return auctionMapper.bidCount(auctionId);
	}
	
	public void insertBid(Bidding bid) {
		auctionMapper.insertBid(bid);
	}
	
	public void updateParticipant(String itemId) {
		auctionMapper.updateParticipant(itemId);
	}
	public void closeAuction(Date curTime) {
	    auctionMapper.closeAuction(curTime);
	}
}
