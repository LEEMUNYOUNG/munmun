package com.example.sproute.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginFormController {

	@RequestMapping("/store/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	/*@RequestMapping("/shop/index.do")
	public String mainForm() {
		return "redirect:../index";
	}*/
	
}
