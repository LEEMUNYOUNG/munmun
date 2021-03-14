package com.example.sproute.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.WebUtils;

import com.example.sproute.domain.Auction;
import com.example.sproute.domain.Item;
import com.example.sproute.domain.ProductType;
import com.example.sproute.service.ItemService;
import com.example.sproute.service.MyPageAuctionService;

@Controller
public class UpdateAuctionController {
	@Autowired
	private MyPageAuctionService mas;
	@Autowired
	private ItemService is;
	
	@ModelAttribute("modifyAuc")
	public AuctionCommand formData(HttpServletRequest request) {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			String auctionId = request.getParameter("auctionId").toString();
			Auction auction = mas.selectAuctionByAuctionId(auctionId);
			
			AuctionCommand ac = new AuctionCommand();
			Item i = new Item();
			i.setItemId(auction.getItem().getItemId());
			i.setProductId(auction.getItem().getProductId());
			i.setCategoryId(auction.getItem().getCategoryId());
			i.setPrice(auction.getItem().getPrice());
			i.setStock(auction.getItem().getStock());
			i.setTitle(auction.getItem().getTitle());
			i.setDescription(auction.getItem().getDescription());
			
			ac.setItem(i);
			
			ac.setDeadline(auction.getDeadline());
			ac.setParticipant(auction.getParticipant());
			ac.setSellerId(WebUtils.getSessionAttribute(request, "userId").toString());

			return ac;
		}
		return new AuctionCommand();
	}
	@ModelAttribute("ProductType")
	public ProductType[] referenceCategoryTypes() {
		return ProductType.values();
	}
	
	//�뤌 遺덈윭�삤�뒗 嫄�
	@GetMapping("/mypage/updateAuctionForm")
	public String updateAuctionForm(@ModelAttribute("modifyAuc")AuctionCommand ac) {
		return "ModifyMyAuctionItem";
	}
	
	//寃쎈ℓ �닔�젙
	@PostMapping("/mypage/updateAuction")
	public String updateAuction(@Valid @ModelAttribute("modifyAuc")AuctionCommand ac, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()) {
			return "ModifyMyAuctionItem";
		}
		
		String itemId = request.getParameter("auctionId");
		int price = Integer.valueOf(ac.getItem().getPrice());

		Item item = new Item();
		item.setItemId(itemId);
		item.setCategoryId("Auction");
		item.setDescription(ac.getItem().getDescription());
		item.setTitle(ac.getItem().getTitle());
		item.setPrice(price);
		item.setStock(ac.getItem().getStock());
		item.setProductId(ac.getItem().getProductId());
		
		int updateResult = is.updateAuctionItem(item);
		System.out.println("Update Result : " + updateResult);
		
		return "redirect:/mypage/MyAuctionMain";
	}
}
