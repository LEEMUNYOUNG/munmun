package com.example.sproute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sproute.domain.Account;
import com.example.sproute.service.AccountService;

@Controller
public class ViewMemberListController {
	
	@Autowired
	private AccountService as;
	
	@RequestMapping("/shop/memberList")
	public String memberList(Model model) {
		List<Account> memberList = as.selectMemberList();
		model.addAttribute("memberList", memberList);
		
		return "viewMemberList";
	}
	
}
