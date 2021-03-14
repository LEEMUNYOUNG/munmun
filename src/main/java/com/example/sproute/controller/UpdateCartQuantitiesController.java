package com.example.sproute.controller;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.sproute.domain.Cart;
import com.example.sproute.domain.CartItem;
import com.example.sproute.domain.Item;
import com.example.sproute.service.ItemService;

@Controller
@SessionAttributes("sessionCart")
public class UpdateCartQuantitiesController { 

	@Autowired
	private ItemService itemService;

	@RequestMapping("/shop/updateCartQuantities")
	public ModelAndView handleRequest(
			HttpServletRequest request,	
			@ModelAttribute("sessionCart") Cart cart, Model model) throws Exception {		
		Iterator<CartItem> cartItems = cart.getAll();
		while (cartItems.hasNext()) {
			CartItem cartItem = (CartItem) cartItems.next();
			String itemId = cartItem.getItem().getItemId();
			String message = null;
			try {
				int quantity = Integer.parseInt(request.getParameter(itemId));
				 Item item = itemService.selectItem(itemId);
		            if (quantity > item.getStock()) {
		               message = "재고가 부족합니다.";
		               model.addAttribute("message", message);
		            } else {
		               cart.setQuantityByItemId(itemId, quantity);
		            }
		            if (quantity < 1) {
		               cartItems.remove();
		            }
		         }

			catch (NumberFormatException ex) {
				
			}
		}
		return new ModelAndView("cart", "cart", cart);
	}
}
