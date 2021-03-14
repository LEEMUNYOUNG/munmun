package com.example.repository.mapper;

import java.util.List;

import com.example.sproute.domain.Auction;
public interface MyPageAuctionMapper {
	
	//경매관련
	List<Auction> getUserAuctionListByUserId(String userId); //유저가 등록한 경매아이템리스트 //유저가 등록한 경매아이템리스트
	Integer deleteMyAuctionItemByAutionId(String auctionId); //경매아이템 삭제
	Integer deleteItem(String itemId); //아이템 삭제
	Auction selectAuctionByAuctionId(String auctionId);
	Integer updateMyAddAuctionItem(Auction auction); //경매아이템 수정
	Integer updateAuctionItem(Auction auction);
	
	
}
