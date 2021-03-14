package com.example.sproute.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sproute.domain.Auction;
import com.example.sproute.domain.ProductType;
import com.example.sproute.service.MyPageAuctionService;

@Controller
public class MyPageAuctionController {

	@Autowired
	private MyPageAuctionService myService;
	
	//경매
	@RequestMapping("/mypage/MyAuctionMain")
	public String myAuctionPageView(HttpSession session, ModelMap model) throws Exception {
		System.out.println(session.getAttribute("userId").toString());
		List<Auction> items = myService.getUserAuctionListByUserId(session.getAttribute("userId").toString());
		model.addAttribute("Items", items);
		
		return "MyPageAuction";
	}
	
	@RequestMapping("/mypage/MyAuctionMain/delete") 
	public String DeleteMyAuction(@RequestParam(value="auctionId") String auctionId, ModelMap model, HttpSession session) throws Exception {
		Integer delete = myService.deleteMyAuctionItemByAutionId(auctionId);
		Integer itemde = myService.deleteItem(auctionId);
		String userId = session.getAttribute("userId").toString();
	
		return "redirect:/mypage/MyAuctionMain";
	}
	
	//수정 폼
	@GetMapping("/mypage/MyAuctionMain/updateForm")
	public String updateForm() {
		return "ModifyMyAuctionItem";
	}
	
	@PostMapping("/mypage/MyAuctionMain/updateForm")
	public String updateSubmit(@ModelAttribute("updateCommand") Auction action, HttpSession session) {
		Integer result = myService.updateMyAddAuctionItem(action);
		String userId = session.getAttribute("userId").toString();
		
		return "redirect:/mypage/MyAuctionMain";
	}
	
	@ModelAttribute("ProductType")
	public ProductType[] referenceCategoryTypes() {
		return ProductType.values();
	}
	
}
