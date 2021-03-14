package com.example.sproute.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewUsedController {
	@Value("UsedProduct")
	private String formViewName;
	
	@RequestMapping(value="shop/usedProduct", method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	@RequestMapping(value="shop/viewProduct", method = RequestMethod.GET)
	public String usedDetail() {
		return "UsedItemDetail";
	}

}
