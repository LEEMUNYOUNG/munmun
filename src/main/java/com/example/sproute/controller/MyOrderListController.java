package com.example.sproute.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sproute.domain.Item;
import com.example.sproute.domain.Order;
import com.example.sproute.service.ItemService;
import com.example.sproute.service.OrderService;

@Controller
public class MyOrderListController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ItemService itemService;
	
	private final Map<String, Item> itemMap = Collections.synchronizedMap(new HashMap<String, Item>());
	
	
	@RequestMapping("/mypage/MyOrderList")
	public String MyOrderList(HttpSession session, ModelMap model) {
		String userId = session.getAttribute("userId").toString();
		List<Order> orders = orderService.selectOrderByUserId(userId);
		Item item;
		for (int i = 0; i < orders.size(); i++) {
			item = itemService.selectItem(orders.get(i).getItemId());
			if (item == null) {
				itemMap.put("null", null);
			} else {
				itemMap.put(item.getItemId(), item);
			}
		}
		model.addAttribute("items", itemMap);
 		model.addAttribute("orders", orders);
		return "MyPageOrderList";
	}
	
	@RequestMapping("/mypage/MyOrderList/cancel") 
	public String CancelOrder(@RequestParam(value="orderId") String orderId,
			ModelMap model, HttpSession session) throws Exception {
		orderService.deleteOrder(orderId);	
		return "redirect:/mypage/MyOrderList";
	}
	
}
