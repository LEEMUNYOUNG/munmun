package com.example.sproute.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sproute.domain.Item;
import com.example.sproute.domain.Used;
import com.example.sproute.service.ItemService;
import com.example.sproute.service.UsedService;

@Controller
public class ViewUsedController {
   @Value("UsedProduct")
   private String formViewName;
   @Autowired
   private ItemService itemService;
   @Autowired
   private UsedService usedService;
   
   @ModelAttribute("item")
   public UpdateUsedCommand createOrderForm() {
      return new UpdateUsedCommand();
   }
   
   @RequestMapping(value="shop/usedProduct", method = RequestMethod.GET)
   public String form(Model model) {
      List<Item> items = itemService.selectUsedItem("used");
      model.addAttribute("Items", items);
      return formViewName;
   }
   
   //0629-유정-구매내역수정된 부분
   @RequestMapping(value="shop/viewProduct", method = RequestMethod.GET)
   public String usedDetail(@RequestParam("itemId") String itemId, Model model) {
      Used used = usedService.selectUsed(itemId);
      Item item = itemService.selectItem(itemId);
      if (used == null || item == null) {
         model.addAttribute("message", "상품이 존재하지 않습니다.");
         return "NotFound";
      } else {
         model.addAttribute("used", used);
         model.addAttribute("item", item);
      }
      return "UsedItemDetail";
   }
   
   @RequestMapping(value="shop/viewUsed", method = RequestMethod.GET)
   public String viewProduct(@RequestParam("productId") String productId, Model model) {
      List<Item> items = itemService.selectItemByProductId(productId);
      System.out.println(items);
      model.addAttribute("items", items);
      return formViewName;
   }
   
   @RequestMapping(value="shop/ProductManagement")
   public String view(Model model, HttpSession session) {
      List<Item> items = itemService.selectUsedItemByUserId(session.getAttribute("userId").toString());
      model.addAttribute("Useditems", items);
      return "ProductManagement";
   }
   
   @RequestMapping(value="shop/deleteUsedProduct")
   public String deleteUsedProduct(@RequestParam("itemId") String itemId, Model model, HttpSession session) {
      itemService.deleteUsedItem(itemId);
      usedService.deleteUsed(itemId);
      List<Item> items = itemService.selectUsedItemByUserId(session.getAttribute("userId").toString());
      model.addAttribute("Useditems", items);
      return "ProductManagement";
   }
   /*@RequestParam(value = "i", defaultValue = "10")*/
   @RequestMapping(value="shop/updateUsedProduct")
   public String updateUsedProduct(@RequestParam("itemId") String itemId, @ModelAttribute("item") UpdateUsedCommand usedItem, Model model, HttpServletRequest request, HttpSession session, Errors result) {
      Item item = itemService.selectItem(itemId);
      if (request.getMethod().equalsIgnoreCase("GET")) {
         usedItem.setTitle(item.getTitle());
         usedItem.setDescription(item.getDescription());
         usedItem.setPrice(item.getPrice());
         usedItem.setStock(item.getStock());
         model.addAttribute("item", usedItem);
         
         return "UpdateUsedItemForm";
      }

      ValidationUtils.rejectIfEmptyOrWhitespace(result, "title", "used_title");
      ValidationUtils.rejectIfEmptyOrWhitespace(result, "description", "used_description");
      ValidationUtils.rejectIfEmptyOrWhitespace(result, "price", "used_price");
      ValidationUtils.rejectIfEmptyOrWhitespace(result, "stock", "used_stock"); //빈칸널
      
      if(usedItem.getStock() == null || usedItem.getStock() == 0) {
    	  result.rejectValue("stock", "zero_used");
      }
   
      if(result.hasErrors()) {
         return "UpdateUsedItemForm";
      }
      item.setTitle(usedItem.getTitle());
      item.setDescription(usedItem.getDescription());
      item.setPrice(usedItem.getPrice());
      item.setStock(usedItem.getStock());
      itemService.updateUsedItem(item);
      List<Item> items = itemService.selectUsedItemByUserId(session.getAttribute("userId").toString()); //세션 아이디 연결
      model.addAttribute("Useditems", items);
      return "ProductManagement";
   }

}