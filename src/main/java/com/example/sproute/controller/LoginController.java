package com.example.sproute.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;

import com.example.sproute.domain.Account;
import com.example.sproute.service.AccountService;

@Controller
@SessionAttributes("session")
public class LoginController {
   
   @Autowired
   private AccountService as;
   
   @ModelAttribute("loginForm")
   public LoginCommand formData() {
      return new LoginCommand();
   }

   @RequestMapping("/shop/loginForm")
   public String loginForm(HttpServletRequest request, Model model) {
      System.out.println(WebUtils.getSessionAttribute(request, "path"));
      return "login";
   }
   
   @RequestMapping("/shop/login")
   public String login(@Valid @ModelAttribute("loginForm")LoginCommand lc,BindingResult result, Model model,
         HttpSession session, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect) {
      String loginId = lc.getLoginId();
      String loginpw = lc.getLoginpw();
      
      session = request.getSession();
      Account account = as.selectMemberListByUserId(loginId);
     
      if (account == null) {
     	 result.rejectValue("loginId", "notExist", "아이디가 존재하지 않습니다.");
          return "login";
       }
      
      else if(loginId.equals(account.getUserId()) && loginpw.equals(account.getPassword())){
         System.out.println(account.getName());
         
         session.setAttribute("userId", loginId);
         session.setAttribute("userName", account.getName());
         System.out.println("Account name test: " + account.getName());
         System.out.println("session Id : " + session.getAttribute("userId"));
         model.addAttribute("session", session.getAttribute("userId"));
         
         if(session.getAttribute("path") == null) {
        	 return "redirect:/";
         }
         else {
        	 String path = session.getAttribute("path").toString();
             if(session.getAttribute("query") == null)
                 return "redirect:" + path;
             
             else if (session.getAttribute("query").toString() != null) {
           	  String query = session.getAttribute("query").toString();
                 //redirect.addAttribute("itemId", query);
                 return "redirect:" + path + "?" + query;
             }
         }
      }
//      else if (!loginId.equals(account.getUserId())) {
//         result.rejectValue("loginId", "notExist", "占쏙옙占싱듸옙 占쏙옙占쏙옙占쏙옙占쏙옙 占십쏙옙占싹댐옙.");
//      }
      
      else if(loginId.equals(account.getUserId()) && !loginpw.equals(account.getPassword())) {
          result.rejectValue("loginpw", "notMatch", "비밀번호가 일치하지 않습니다.");
       }
      
      if(result.hasErrors()) {
         return "login";
      }
      return "";
      
   }

   
}