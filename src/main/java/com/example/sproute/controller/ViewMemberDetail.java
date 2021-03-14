package com.example.sproute.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.sproute.domain.Account;
import com.example.sproute.service.AccountService;

@Controller
public class ViewMemberDetail {
	@Autowired
	private AccountService as;
	
	@ModelAttribute("detailReq")
	public AccountCommand formData() {
		AccountCommand ac = new AccountCommand();
		
		return ac;
	}
	
	@RequestMapping("/mypage/memberDetail")
	public String memberDetail(@ModelAttribute("detailReq")AccountCommand ac, HttpSession session,
			Model model) {
		String userId = session.getAttribute("userId").toString();
		Account accont = as.selectMemberListByUserId(userId);
		
		ac = new AccountCommand(accont.getId(), accont.getUserId(), accont.getPassword(), accont.getEmail(),
				accont.getAddress(), accont.getPhone(), accont.getSex(), accont.getName(), accont.getBirth());
	
		
		model.addAttribute("detailReq", ac);
		
		return "viewMemberDetail";
	}
	
}
