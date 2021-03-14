package com.example.sproute.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.example.sproute.domain.Cart;

@Controller
@SessionAttributes("sessionCart")
public class ViewCartController {
	
	@ModelAttribute("sessionCart")
	public Cart createCart(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("sessionCart");
		if (cart == null) cart = new Cart();
		return cart;
	}
	
	@RequestMapping("/shop/viewCart")	
	public ModelAndView viewCart(
			HttpServletRequest request,
			@RequestParam(value="page", required=false) String page,
			@ModelAttribute("sessionCart") Cart cart, Model model) 
			throws Exception {
		handleRequest(page, cart);
		model.addAttribute("message", null);
		return new ModelAndView("cart", "cart", cart);
	}
	
	private void handleRequest(String page, Cart cart)
			throws Exception {
		if ("nextCart".equals(page)) {
			cart.getCartItemList().nextPage();
			cart.getUsedCartItemList().nextPage();
		}
		else if ("previousCart".equals(page)) {
			cart.getCartItemList().previousPage();
			cart.getUsedCartItemList().previousPage();
		}
	}
}
