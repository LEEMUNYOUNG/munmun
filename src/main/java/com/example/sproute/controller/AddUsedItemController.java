package com.example.sproute.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.example.sproute.domain.Item;
import com.example.sproute.domain.ProductType;
import com.example.sproute.domain.Used;
import com.example.sproute.service.ItemService;
import com.example.sproute.service.UsedService;

@Controller
public class AddUsedItemController implements ApplicationContextAware {
   @Value("addUsedItemForm")
   private String formViewName;
   
   private WebApplicationContext context;   
   private String uploadDir;

   @Autowired
   private ItemService itemService;
   @Autowired
   private UsedService usedService;
   
   @Override               // life-cycle callback method
   public void setApplicationContext(ApplicationContext appContext)
      throws BeansException {
      this.context = (WebApplicationContext) appContext;
      this.uploadDir = context.getServletContext().getRealPath("/upload/");
   }

   @ModelAttribute("usedInfo")
   public UsedCommand formBacking(HttpServletRequest request) {
      if (request.getMethod().equalsIgnoreCase("GET")) {
         UsedCommand used = new UsedCommand();
         return used;
      } else
         return new UsedCommand();
   }

   
   @ModelAttribute("ProductType")
   public ProductType[] referenceCategoryTypes() {
      return ProductType.values();
   }
    
   @RequestMapping(value = "/shop/addUsedSumitted", method = RequestMethod.GET)
   public String form() {
      return formViewName;
   }

   @RequestMapping(value="/shop/add", method = RequestMethod.POST)
   public String submit(@Valid @ModelAttribute("usedInfo") UsedCommand used, BindingResult result, Model model, SessionStatus status, HttpSession session) {

      if(result.hasErrors()) {
         return formViewName;
      }
      
      uploadFile(used.getReport());
      
      String filename = used.getReport().getOriginalFilename();
      
      Used use = new Used();
      use.setSellerId(session.getAttribute("userId").toString());
      use.setUsingTime(used.getUsingTime());
      used.setCategoryId("used");
      //아래 simpleData?used.setAddDate(Calendar.getInstance().getTime().toString());
      
      Item item = new Item();
      item.setCategoryId("used");
      item.setDescription(used.getDescription());
      item.setPrice(used.getPrice());
      item.setStock(used.getStock());
      item.setTitle(used.getTitle());
      item.setImgName(filename);
      
      SimpleDateFormat today = new SimpleDateFormat("y/M/d");
      item.setAddDate(today.format(new Date()));
      
      String product = null;
      switch(used.getProductId()) {
         case "유모차":
               product = "S001";
               break;
            case "장난감":
               product = "S002";
               break;
            case "옷":
               product = "S003";
               break;
            case "신발":
               product = "S004";
               break;
            case "모빌":
               product = "S005";
               break;
      }
      item.setProductId(product);
      System.out.println(item);
      int result1 = itemService.insertItem(item);
      System.out.println(result1);
      use.setItem(item);
      int result2 = usedService.insertUsed(use);
      System.out.println(result2);
      List<Item> items = itemService.selectUsedItem("used");
      model.addAttribute("Items", items);
      return "UsedProduct";
   }
   
   private void uploadFile(MultipartFile report) {
      System.out.println(report.getOriginalFilename());
      File file = new File(this.uploadDir + report.getOriginalFilename());
      try {
         report.transferTo(file);
      } catch (IllegalStateException | IOException e) {
         e.printStackTrace();
      }
   }
   
}