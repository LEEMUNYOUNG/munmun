package com.example.sproute.controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.repository.mapper.AuctionMapperRepository;
import com.example.sproute.domain.Auction;
import com.example.sproute.domain.Bidding;
import com.example.sproute.domain.Item;
import com.example.sproute.service.ItemService;

@Controller
public class AddBidFormController {
   
   @Autowired
   private ItemService itemService;
   @Autowired
   private AuctionMapperRepository auctionRepository;
   
   @ModelAttribute("bidding")
   public BiddingCommand formBacking(HttpServletRequest request) {
      if (request.getMethod().equalsIgnoreCase("GET")) {
         BiddingCommand bid = new BiddingCommand();
         
         return bid;
      } else return new BiddingCommand();
   }
   
   @RequestMapping(value ="/shop/addBidForm", method = RequestMethod.GET)      
   public String bidForm(@RequestParam("itemId") String itemId, Model model, 
         @ModelAttribute("bidding") BiddingCommand bidding) {
      Auction auction = auctionRepository.selectAuction(itemId);
      
      int bidCount = auctionRepository.bidCount(itemId);
      
      int maxPrice = 0;
      if (bidCount != 0) {
         maxPrice = auctionRepository.maxPriceAuction(itemId);
      }
      Item item = itemService.selectItem(itemId);
      
      auction.setItem(item);
      
      model.addAttribute("auction", auction);
      model.addAttribute("maxPrice", maxPrice);
      return "addBidForm";
   }
   
   
   @RequestMapping(value ="/shop/addBidForm", method = RequestMethod.POST)     
   public String addbidForm(@RequestParam("itemId") String itemId, 
          @Valid @ModelAttribute("bidding") BiddingCommand bidding,
         BindingResult result, Model model, SessionStatus status,
         RedirectAttributes redirect, HttpSession session) {
     
      if (bidding.getBidding().getbCount() > 1) {
         result.rejectValue("bidding.bCount", "morethan1", "수량은 1개 이상 할 수 없습니다.");
      }
      
      if(result.hasErrors()) {
         
         Auction auction = auctionRepository.selectAuction(itemId);
        
         int bidCount = auctionRepository.bidCount(itemId);
         
         int maxPrice = 0;
         if (bidCount != 0) {
            maxPrice = auctionRepository.maxPriceAuction(itemId);
         }
         Item item = itemService.selectItem(itemId);
         auction.setItem(item);
         
         model.addAttribute("auction", auction);
         model.addAttribute("maxPrice", maxPrice);
         
         return "addBidForm";
      }
      

      Bidding mybidding = bidding.getBidding();
      mybidding.setApplyDate(Calendar.getInstance().getTime());
      mybidding.setBuyerId(session.getAttribute("userId").toString());
      mybidding.setItemId(itemId);
      mybidding.setPrice(bidding.getBidding().getPrice());
      mybidding.setbCount(1);
      auctionRepository.insertBid(mybidding);
      auctionRepository.updateParticipant(itemId);
      redirect.addAttribute("itemId", itemId);

      return "redirect:auctionItemDetail";
   }
}