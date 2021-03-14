package com.example.sproute.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.repository.mapper.AuctionMapperRepository;
import com.example.sproute.domain.Bidding;
import com.example.sproute.service.AuctionService;
import com.example.sproute.service.MyPageBidService;

@Controller
public class MyPageBidController {

	@Autowired
	private MyPageBidService myService;
	@Autowired
	private AuctionService as;
	@Autowired
	private AuctionMapperRepository auctionRepository;
	
	//입찰
	@RequestMapping("/mypage/MyBidMain") 
	public String viewMyBid(HttpSession session, ModelMap model) throws Exception {
//		bid테이블에서 buyerId를 이용해서 일단 모든 입찰내역을 가져옴.
//		List<Bidding> items = myService.getAllBiddingListByUserId(session.getAttribute("userId").toString());
//		System.out.println("입찰컨트롤러:" + items.get(0).getAuction().getItem() );
//		model.addAttribute("Items", items);
		
		System.out.println("/mypage/MyBidMain " + session.getAttribute("userId").toString());
		
		//입찰 진행 중인 bid리스트
		List<Bidding> bidingList = myService.getBiddingList(session.getAttribute("userId").toString());
		
		for (int i = 0; i < bidingList.size(); i++) {
			int bidCount = auctionRepository.bidCount(bidingList.get(i).getItemId());
			int maxPrice = 0;
			
			if (bidCount != 0) {
				maxPrice = auctionRepository.maxPriceAuction(bidingList.get(i).getItemId());
			}
			bidingList.get(i).setMaxPrice(maxPrice);
		}
	
		model.addAttribute("bidingList", bidingList);
		
		//입찰 종료된 bid리스트
		List<Bidding> endBidList = myService.getEndBidList(session.getAttribute("userId").toString());
		for (int i = 0; i < endBidList.size(); i++) {
			endBidList.get(i).setCheck(0);
			int bidCount = auctionRepository.bidCount(endBidList.get(i).getItemId());
			int maxPrice = 0;
			
			if (bidCount != 0) {
				maxPrice = auctionRepository.maxPriceAuction(endBidList.get(i).getItemId());
			}
			endBidList.get(i).setMaxPrice(maxPrice);
			if (endBidList.get(i).getPrice() == maxPrice) {
				endBidList.get(i).setCheck(1);
			}
		}
		model.addAttribute("endBidList", endBidList);
		return "MyPageBid";
	}
	
	@RequestMapping("/mypage/MyBidMain/delete")
	public String DeleteMyBid(@RequestParam("bidId") String bidId, Model model, HttpSession session, HttpServletRequest request) {
		String auctionId = as.selectAuctionId(bidId);
		int updateParticipant = as.updateParticipantAfter(auctionId);
		int BidDelete = myService.deleteMyBid(bidId);
	
		System.out.println("update Result :" + updateParticipant);
		System.out.println("delete Result :" + BidDelete);
		
		return "redirect:/mypage/MyBidMain";
	}
	
}

