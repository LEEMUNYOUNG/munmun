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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import com.example.sproute.domain.Account;
import com.example.sproute.service.AccountService;

@Controller
public class UpdateMemberContorller {
	
	@Autowired
	private AccountService as;
	
	@ModelAttribute("modifyReq")
	public AccountCommand formData(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			String userId = (String) WebUtils.getSessionAttribute(request, "userId");
			
			Account account = as.selectMemberListByUserId(userId);
			
			AccountCommand ac = new AccountCommand();
			ac.setUserId(account.getUserId());
			ac.setPassword(account.getPassword());
			ac.setName(account.getName());
			ac.setEmail(account.getEmail());
			ac.setAddress(account.getAddress());
			ac.setPhone(account.getPhone());
			ac.setBirth(account.getBirth());
			ac.setSex(account.getSex());
		
			return ac;
		}
			return new AccountCommand();
			
	}
	//회원수정폼
	@RequestMapping("/shop/viewModifyForm")
	public String viewModifyForm( 
			@ModelAttribute("modifyReq")AccountCommand formData) {
		
		return "modifyMember";
	}
	//회원정보 수정
		@RequestMapping("/shop/modify")
		   public String updateMember(HttpServletRequest request,
		         @Valid @ModelAttribute("modifyReq")AccountCommand req, BindingResult result, Model model) {
			
			String userId = (String) WebUtils.getSessionAttribute(request, "userId");
			
			if (!req.isSamecPassword()) {
				result.rejectValue("cPassword", "notSame", "암호가 일치하지 않습니다.");
			}
			
		      if(result.hasErrors()) {
		         return "modifyMember";
		      }
			Account account = new Account(userId, req.getPassword(), req.getEmail(), req.getName(),
					req.getAddress(), req.getPhone(), req.getSex(), req.getBirth());
			
			System.out.println(account.getPassword());
			
			int modifyResult = as.modifyMember(account);
			System.out.println("Modify Result : " + modifyResult);

			
			return "redirect:/mypage/memberDetail";
		}
		
		
	}
