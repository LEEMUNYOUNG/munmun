package com.example.sproute.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.example.sproute.domain.Item;
import com.example.sproute.domain.ProductType;

@Controller
public class AddUsedItemController {
	@Value("addUsedItemForm")
	private String formViewName;

	// private CommentService commService;

	@ModelAttribute("used")
	public UsedCommand formBacking(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			UsedCommand used = new UsedCommand();
			return used;
		} else
			return new UsedCommand();
	}

	
	@ModelAttribute("ProductType")
	public ProductType[] referenceCategoryTypes() {
		return ProductType.values();
	}
	 
	@RequestMapping(value = "/shop/addUsedSumitted", method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}

	/*
	 * @RequestMapping(value="/shop/add", method = RequestMethod.POST) public String
	 * submit(@ModelAttribute("used") UsedCommand used, BindingResult result, Model
	 * model, SessionStatus status) {
	 * used.getUsed().setSellDate(Calendar.getInstance().getTime());
	 * used.getUsed().getItem().setCategoryId("used");
	 * used.getUsed().getItem().setAddDate(Calendar.getInstance().getTime().toString
	 * ()); Item item = used.getUsed().getItem();
	 * used.getUsed().setSellDate(Calendar.getInstance().getTime());
	 * used.getUsed().setSellerId("sellerId"); used.getUsed().setUsedId("usedId");
	 * item.setItemId("i002"); item.setProductId("S001"); System.out.println(item);
	 * int result1 = commService.insertUsed(item); System.out.println(result1);
	 * return "UsedProduct"; }
	 */

}
