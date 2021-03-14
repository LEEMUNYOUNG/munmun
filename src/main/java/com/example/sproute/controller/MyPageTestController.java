package com.example.sproute.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//jsp 확인하려고 만든거니까 지우고 다른 컨트롤러 사용하세욘@
@Controller
public class MyPageTestController {

	@RequestMapping("/mypage/main")
	public String mypageView(HttpSession session, HttpServletRequest request, Model model){
		System.out.println(session.getAttribute("userName"));
		System.out.println(session.getAttribute("userId"));
		model.addAttribute("userName", session.getAttribute("userName"));
		model.addAttribute("message", null);
		return "MyPageMain";
	}
		
//	@RequestMapping("/mypage/auction")
//	public String mypageAuctionView() throws Exception {
//		
//		return "MyPageAuction";
//	}
//		
		
}
