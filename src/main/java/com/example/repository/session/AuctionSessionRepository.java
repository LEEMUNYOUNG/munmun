package com.example.repository.session;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.repository.mapper.AuctionMapper;

import com.example.sproute.domain.Auction;


@Repository
public class AuctionSessionRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String namespace = 
			"com.example.repository.mapper.AuctionMapper";
	
	public Integer insertAuction(Auction auction) {
		int result = sqlSession.insert(namespace + ".insertAuction", auction);
		return result;
	}
	
	public Integer updateParticipantAfter(String auctionId) {
		int result = sqlSession.update(namespace + ".updateParticipantAfter", auctionId);
		return result;
	}
	public String selectAuctionId(String bidId) {
		return sqlSession.selectOne(namespace + ".selectAuctionId", bidId);
	}
	
	public Auction selectAuction(String itemId) {
		return sqlSession.getMapper(AuctionMapper.class)
				.selectAuction(itemId);
	}
	
	public Auction updateAuction(Auction auction) {
		return sqlSession.getMapper(AuctionMapper.class)
				.updateAuction(auction);
	}
	
	public Integer deleteAuction(String itemId) {
		return sqlSession.getMapper(AuctionMapper.class)
				.deleteAuction(itemId);
	}

}
