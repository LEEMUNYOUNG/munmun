package com.example.repository.mapper;

import java.util.Date;

import com.example.sproute.domain.Auction;
import com.example.sproute.domain.Bidding;

public interface AuctionMapper {
	
	Integer insertAuctionItem(Auction auction);
	
	Auction selectAuction(String itemId);
	Auction updateAuction(Auction auction);
	Integer deleteAuction(String itemId);
	Integer maxPriceAuction(String auctionId);
	Integer bidCount(String auctionId);
	void insertBid(Bidding bid);
	void updateParticipant(String itemId);
	void closeAuction(Date curTime);
	//Bidding updatePaticipant(Bidding bidding, Auction auction);
}
