package com.example.sproute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.repository.mapper.AuctionMapperRepository;
import com.example.sproute.domain.Auction;
import com.example.sproute.domain.Item;
import com.example.sproute.domain.Product;
import com.example.sproute.service.AuctionService;
import com.example.sproute.service.ItemService;

@Controller
public class ViewAuctionController {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private AuctionMapperRepository auctionRepository;
	
	
	@RequestMapping(value ="/shop/auctionProduct")	// "경매" 카테고리 클릭 시,
	public String auctionProduct(Model model) {
		List<Item> items = itemService.selectAllAuction("Auction");
		model.addAttribute("items", items);
		return "AuctionProduct";
	}
	
	@RequestMapping(value="/shop/auctionByProductId")	// "경매" 카테고리 내에서 항목 클릭시(유모차, 장난감 등) 분류
	public String auctionByProductId(@RequestParam("categoryId") String categoryId, @RequestParam("productId") String productId, Model model) {
		List<Item> items = itemService.selectItemByProduct(categoryId, productId);
		System.out.println(items);
		model.addAttribute("items", items);
		return "AuctionProduct";
	}
	
	//0629-유정-구매내역수정된 부분
	@RequestMapping(value="/shop/auctionItemDetail", method = RequestMethod.GET)	// Item 클릭 시 상세 보기
	public String auctionItemDetail(@RequestParam("itemId") String itemId, Model model) {
		Auction auction = auctionRepository.selectAuction(itemId);
		Item item = itemService.selectItem(itemId);
		if (auction == null || item == null) {
			model.addAttribute("message", "상품이 존재하지 않습니다.");
			return "NotFound";
		} else {
			model.addAttribute("auction", auction);
			model.addAttribute("item", item);
		}
		return "AuctionItemDetail"; 
	}
	
	/*
	 * @RequestMapping("/shop/deleteAuctionItem") // Item 삭제 public String
	 * deleteAuctionItem(@RequestParam("itemId") String itemId, Model model) { int
	 * di = itemService.deleteItem(itemId); System.out.println(di); int da =
	 * auctionRepository.deleteAuction(itemId); System.out.println(da); List<Item>
	 * items = itemService.selectAuctionItem("Auction"); model.addAttribute("items",
	 * items); return "AuctionProduct"; }
	 */
	
}
