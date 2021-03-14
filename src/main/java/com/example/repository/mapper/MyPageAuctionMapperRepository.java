package com.example.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.sproute.domain.Auction;

@Repository
public class MyPageAuctionMapperRepository {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Auction> getUserAuctionListByUserId(String userId){
		List<Auction> resultList = sqlSession.getMapper(MyPageAuctionMapper.class).getUserAuctionListByUserId(userId);
		return resultList;
	}
	
	public Integer deleteMyAuctionItemByAutionId(String auctionId){
		int result = sqlSession.getMapper(MyPageAuctionMapper.class).deleteMyAuctionItemByAutionId(auctionId);
		return result;
	}
	
	public Integer deleteItem(String itemId){
		int result = sqlSession.getMapper(MyPageAuctionMapper.class).deleteItem(itemId);
		return result;
	}
	
	public Auction selectAuctionByAuctionId(String auctionId) {
		return (Auction)sqlSession.getMapper(MyPageAuctionMapper.class).selectAuctionByAuctionId(auctionId);
	}
	
	public Integer updateMyAddAuctionItem(Auction auction) {
		int result = sqlSession.getMapper(MyPageAuctionMapper.class).updateMyAddAuctionItem(auction);
		return result;
	}
}
