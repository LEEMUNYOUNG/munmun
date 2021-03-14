package com.example.sproute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ViewProductController {
	

	@RequestMapping("/shop/viewCategory.do") //메인->일반상품가는 것
	public String handleRequest(@RequestParam(value="categoryId") String categoryId, ModelMap model) throws Exception {
		
		
		return "SaleProduct";
	}
}
