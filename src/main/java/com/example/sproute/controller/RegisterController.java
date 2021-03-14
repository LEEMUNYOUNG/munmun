package com.example.sproute.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.example.sproute.domain.Account;
import com.example.sproute.service.AccountService;


@Controller
public class RegisterController {
	
	@Autowired
	private AccountService as;
	
	@ModelAttribute("registerReq")
	public AccountCommand formData(HttpServletRequest request) {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			AccountCommand rc = new AccountCommand();
			return rc;
		}
		return new AccountCommand();
	}
	
	@RequestMapping("/shop/joinForm")
	public String RegisterForm() {
		return "joinForm";
	}
	
	//회원가입 절차
	@PostMapping("/shop/register")
	   public String register(@Valid @ModelAttribute("registerReq") AccountCommand req,
	         BindingResult result) {
		
	      if (!req.isSamecPassword()) {
	         result.rejectValue("cPassword", "notSame", "비밀번호가 일치하지 않습니다.");
	      }
	      
	      Account ac = as.selectMemberListByUserId(req.getUserId());
	      if (ac != null) {
	         if(ac.getUserId().equals(req.getUserId())) {
	            result.rejectValue("userId", "duplicate", "이미 존재하는 아이디 입니다.");
	         }
	      }
	      if(result.hasErrors()) {
	         return "joinForm";
	      }
	      if(ac == null) {
	         Account account = new Account(req.getUserId(), req.getPassword(), req.getEmail(), req.getName(), 
	               req.getAddress(), req.getPhone(), req.getSex(), req.getBirth());
	         int result1 = as.insertMember(account);
	         System.out.println("Insert Result : " + result1);
	         return "redirect:/";
	      }
	      return "/";

	   }
	

}
