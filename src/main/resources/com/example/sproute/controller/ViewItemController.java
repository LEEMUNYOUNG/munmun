package com.example.sproute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sproute.domain.Item;

@Controller
public class ViewItemController {
	
	@RequestMapping("/shop/viewItemDetail.do") //상품(itemid)상세보기
	public String handleRequest2(String itemId, ModelMap model) throws Exception {
		//Item item = itemService.selectItem(itemId);  
		//model.addAttribute("item", item);
		return "SaleProductDetail";
	}
	
}
