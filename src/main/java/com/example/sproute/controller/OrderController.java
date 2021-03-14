package com.example.sproute.controller;

import java.util.ArrayList;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.sproute.domain.Account;
import com.example.sproute.domain.Cart;
import com.example.sproute.domain.CartItem;
import com.example.sproute.domain.Item;
import com.example.sproute.service.AccountService;
import com.example.sproute.service.ItemService;
import com.example.sproute.service.OrderService;

@Controller
@SessionAttributes({"sessionCart", "orderForm", "AuctionId"})
public class OrderController {
   @Autowired
   private AccountService accountService;
   @Autowired
   private OrderService orderService;
   @Autowired
   private ItemService itemService;
   
   /*@ModelAttribute("orderForm")
   public OrderForm createOrderForm() {
      return new OrderForm();
   }*/
   
   @ModelAttribute("orderForm")      //registrationForm 객체를 생성하여 session에 저장
   public OrderForm formBacking(HttpServletRequest request, HttpSession session) {
      if (request.getMethod().equalsIgnoreCase("GET")) {
         OrderForm orderForm = new OrderForm();
         String userSession = session.getAttribute("userId").toString();
         Account account = accountService.selectMemberListByUserId(userSession);
         orderForm.getOrder().initOrder(account);
         return orderForm;
      }
      else return new OrderForm();
   }
   
   @ModelAttribute("AuctionId")
   public OrderAuction auctionId() {
      return new OrderAuction();
   }
   
   @ModelAttribute("creditCardTypes")
   public List<String> referenceData() {
      ArrayList<String> creditCardTypes = new ArrayList<String>();
      creditCardTypes.add("Visa");
      creditCardTypes.add("MasterCard");
      creditCardTypes.add("American Express");
      return creditCardTypes;         
   }
   
   @RequestMapping("/shop/newOrder.do")
   public String initNewOrder(HttpServletRequest request,
         @ModelAttribute("sessionCart") Cart cart,
         @Valid @ModelAttribute("orderForm") OrderForm orderForm,
         BindingResult result,
         HttpSession session, Model model
         ) throws ModelAndViewDefiningException {
      if (cart.getNumberOfItems() == 0 && cart.getNumberOfUsedItems() == 0) {
         model.addAttribute("message", "장바구니에 상품이 없습니다.");
      } else {
         if (request.getMethod().equalsIgnoreCase("GET")) {
            if (cart != null) {
               // Re-read account from DB at team's request.
               /*Account account = accountService.selectMemberListByUserId(userSession);
               orderForm.getOrder().initOrder(account, cart);*/
               /*String userSession = session.getAttribute("userId").toString();
               Account account = accountService.selectMemberListByUserId(userSession);
               orderForm.getOrder().initOrder(account, cart);
               System.out.println(orderForm.getOrder());*/
               return "NewOrderForm";   
            }
         } else {
            if(result.hasErrors()) {
               return "NewOrderForm";
            }
            if (orderForm.isShippingAddressRequired()) {
               model.addAttribute("shipAddress", true);
            } else {
               model.addAttribute("shipAddress", false);
            }
            return "ConfirmOrder";
         }
      }
      return "cart";
   }
   
   @RequestMapping("/shop/confirmOrder.do")
   public String confirmOrder(HttpServletRequest request,
         @ModelAttribute("sessionCart") Cart cart,
         @ModelAttribute("orderForm") OrderForm orderForm,
         HttpSession session, Model model, SessionStatus status) {
      Iterator<CartItem> itemList = cart.getAll();
      //model.addAttribute("itemList", itemList);
      List<CartItem> items = new ArrayList<CartItem>();
       while (itemList.hasNext()) {
          CartItem cartItem = (CartItem) itemList.next();
          cartItem.getItem().setTotalPrice(cartItem.getQuantity() * cartItem.getItem().getPrice());
          items.add(cartItem);
          orderForm.getOrder().setItemId(cartItem.getItem().getItemId());
          itemService.updateStock(cartItem.getQuantity(), cartItem.getItem().getItemId());
          orderService.insertOrder(orderForm.getOrder());
       }
       model.addAttribute("items", items);
       if (orderForm.isShippingAddressRequired()) {
         model.addAttribute("shipAddress", true);
      } else {
         model.addAttribute("shipAddress", false);
      }
       model.addAttribute("check", 0);
       status.setComplete();
      return "ViewOrder";
   }
   
   @RequestMapping("/shop/AuctionOrder")
   public String AuctionOrder(HttpServletRequest request,
         @ModelAttribute("AuctionId") OrderAuction AuctionId,
         @Valid @ModelAttribute("orderForm") OrderForm orderForm,
         BindingResult result,
         @RequestParam("itemId") String itemId,
         HttpSession session, Model model) {
      String userSession = session.getAttribute("userId").toString();
      model.addAttribute("itemId", itemId);
      String message = null;
      if (request.getMethod().equalsIgnoreCase("GET")) {
         Item item = itemService.selectItem(itemId);
         if (item.getStock() < 1) {
            message = "구매 완료한 상품입니다.";
               model.addAttribute("message", message);
            return "MyPageMain";
         }
         //Account account = accountService.selectMemberListByUserId(userSession);
         //orderForm.getOrder().initOrder(account, null);
         AuctionId.setAuctionId(itemId);
         return "NewOrderForm";
      } else {
         if(result.hasErrors()) {
            return "NewOrderForm";
         }
         if (orderForm.isShippingAddressRequired()) {
            model.addAttribute("shipAddress", true);
         } else {
            model.addAttribute("shipAddress", false);
         }
         return "AuctionConfirmOrder";
      }
   }
   
   @RequestMapping("/shop/AuctionconfirmOrder.do")
   public String AuctionConfirmOrder (HttpServletRequest request,
         @ModelAttribute("AuctionId") OrderAuction AuctionId,
   @ModelAttribute("orderForm") OrderForm orderForm,
   HttpSession session, Model model, SessionStatus status) {
      //System.out.println("들어왔엉" + AuctionId.getAuctionId());
      List<CartItem> items = new ArrayList<CartItem>();
      CartItem cartItem = new CartItem();
      Item item = itemService.selectItem(AuctionId.getAuctionId());
      item.setTotalPrice(item.getPrice());
      cartItem.setItem(item);
      cartItem.setQuantity(1);
      //cartItem.getItem().setTotalPrice(cartItem.getQuantity() * cartItem.getItem().getPrice());
      System.out.println("뭐가 나오니" + item);
      items.add(cartItem);
      model.addAttribute("items", items);
       if (orderForm.isShippingAddressRequired()) {
         model.addAttribute("shipAddress", true);
      } else {
         model.addAttribute("shipAddress", false);
      }
       model.addAttribute("check", 1);
       orderForm.getOrder().setItemId(AuctionId.getAuctionId());
       itemService.updateStock(1, AuctionId.getAuctionId());
       orderService.insertOrder(orderForm.getOrder());
      status.setComplete();
      return "ViewOrder";
   }
   
}