package com.example.sproute.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.sproute.domain.Auction;
import com.example.sproute.domain.Item;
import com.example.sproute.domain.ProductType;
import com.example.sproute.service.AuctionService;
import com.example.sproute.service.ItemService;

@Controller
public class AddAuctionItemController implements ApplicationContextAware {
	
	@Autowired
	private ItemService itemService;
	@Autowired
	private AuctionService auctionService;
	
	private WebApplicationContext context;	
	private String uploadDir;

	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/upload/");
	}
	
	@ModelAttribute("auction")
	public AuctionCommand formBacking(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			AuctionCommand auction = new AuctionCommand();
			Item item = new Item();
			item.setStock(1);
			auction.setItem(item);

			return auction;
		} else return new AuctionCommand();
	}
	
	@ModelAttribute("ProductType")
	public ProductType[] referenceCategoryTypes() {
		return ProductType.values();
	}
	
	@RequestMapping(value = "/shop/addAuctionItem", method = RequestMethod.GET)
	public String auctionForm() {
		return "addAuctionItemForm";
	}

	@RequestMapping(value ="/shop/addAuctionItem", method = RequestMethod.POST)      //요청 URL
	   public String auctionForm(@Valid @ModelAttribute("auction") AuctionCommand auction, 
	         BindingResult result, Model model, SessionStatus status, HttpSession session) throws ParseException {
			
			if(auction.getItem().getStock() > 1) {
				result.rejectValue("item.stock", "morethan1", "1개이상 입력하실 수 없습니다.");
			}
		
			if(result.hasErrors()) {
				
				return "addAuctionItemForm";
			}
			uploadFile(auction.getReport());
			
			String filename = auction.getReport().getOriginalFilename();
			String userId = session.getAttribute("userId").toString();
			
			auction.getItem().setImgName(filename);
		      auction.getItem().setCategoryId("Auction");
		      //등록 날짜 지정
		      SimpleDateFormat today = new SimpleDateFormat("y/M/d");
		      auction.getItem().setAddDate(today.format(new Date()));
		      
		      
		      Auction inputAuction = new Auction(auction.getItem(), userId, 0, auction.getDeadline(), auction.getAuctionId(), "OPEN");
		     
		      String product = null;
		      switch(auction.getItem().getProductId()) {
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
		      
		      auction.getItem().setProductId(product);
		      System.out.println(auction.getItem());
		      int result1 = itemService.insertItem(auction.getItem());
		      System.out.println(result1);
		      int result2 = auctionService.insertAuctionItem(inputAuction);
		      System.out.println(result2);
		      List<Item> items = itemService.selectAllAuction("Auction");
		      
		      String str_Deadline = auction.getDeadline();
		         
		        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		        Date date_Deadline = df.parse(str_Deadline); /// Date타입으로 변경
		      
		        auctionService.testScheduler(date_Deadline);
		      
		      model.addAttribute("items", items);
		      return "AuctionProduct";
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
