package com.example.sproute.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {
	
	@RequestMapping("/shop/logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		session = request.getSession();
		System.out.println("session Test : " + session.getAttribute("userId"));
		session.invalidate();
		return "redirect:/";
	}
}
