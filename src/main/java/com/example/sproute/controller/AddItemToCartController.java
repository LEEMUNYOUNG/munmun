package com.example.sproute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.sproute.domain.Cart;
import com.example.sproute.domain.Item;
import com.example.sproute.service.ItemService;

@Controller
@SessionAttributes("sessionCart")
public class AddItemToCartController {
	
	@Autowired
	private ItemService itemService;
	
	@ModelAttribute("sessionCart")
	public Cart createCart() {
		return new Cart();
	}
	
	@RequestMapping("/shop/addItemToCart")	//중고or일반상품 상세페이지에서 장바구니에 담을 시
	public ModelAndView handleRequest(
			@RequestParam("workingItemId") String workingItemId,
			@ModelAttribute("sessionCart") Cart cart, Model model 
			) throws Exception {
		Item item = this.itemService.selectItem(workingItemId);
		//getQuantity
		if (cart.containsItemId(workingItemId)) {
			if (item.getStock() < cart.getQuantityByItemId(workingItemId) + 1) {
				model.addAttribute("message", "재고가 부족합니다.");
			} else {
				cart.incrementQuantityByItemId(workingItemId);
			}
		} else {
			if (item.getStock() < 1) {
				model.addAttribute("message", "재고가 부족합니다.");
			} else {
				boolean isInStock = this.itemService.isItemInStock(workingItemId);			
				cart.addItem(item, isInStock);
			}
		}
		return new ModelAndView("cart", "cart", cart); 
	}

}
