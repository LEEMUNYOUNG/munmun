package com.example.sproute.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sproute.domain.Review;
import com.example.sproute.service.ReviewService;

@Controller
public class ReviewContorller {
	
	@Autowired
	private ReviewService rs;
	
//	@ModelAttribute("reviewReq")
//	public ReviewCommand formData(HttpServletRequest request) {
//			ReviewCommand rc = new ReviewCommand();
//			rc.setItemId(request.getParameter("itemId"));
//			System.out.println("안녕" + rc.toString());
//			return rc;
//	
//	}
	
	@ModelAttribute("reviewReq")
	public ReviewCommand formData(HttpServletRequest request) {
			if(request.getMethod().equalsIgnoreCase("GET")) {
				ReviewCommand review = new ReviewCommand();
				System.out.println("폼데이터 : " + request.getParameter("itemId"));
				review.setItemId(request.getParameter("itemId"));
				return review;
			} else
				return new ReviewCommand();
	
	}
	
	//리뷰 폼 불러오기 (리뷰작성 클릭 시)
	@GetMapping("/shop/reviewForm")
	public String reviewForm(@RequestParam("itemId") String itemId, HttpServletRequest request) {
		return "reviewForm";
	}
	//리뷰 작성@Valid
	@PostMapping("/shop/reviewForm")
	public String reveiw(@ModelAttribute("reviewReq") ReviewCommand req, HttpServletRequest request, HttpSession session, RedirectAttributes redirect, Errors result) {
		req.setUserId(session.getAttribute("userId").toString());

		
			ValidationUtils.rejectIfEmptyOrWhitespace(result, "title", "noInputTitle");
			ValidationUtils.rejectIfEmptyOrWhitespace(result, "rating", "noInputRating");
			ValidationUtils.rejectIfEmptyOrWhitespace(result, "content", "noInputcontent");
		
		if(result.hasErrors()) {
			return "reviewForm";
		}
		
		Review review = new Review(session.getAttribute("userId").toString(), req.getTitle(),
				req.getRating(), req.getContent(), request.getParameter("itemId"));
		
		rs.insertReview(review);
		
		redirect.addAttribute("itemId", request.getParameter("itemId"));
		return "redirect:/shop/viewItemDetail.do";
	}
	
	//아이템별로 리뷰 출력
	@GetMapping("/shop/viewReview/itemId/{itemId}")
	public String viewItemReview(@PathVariable("itemId") String itemId, Model model) {
		List<Review> list = rs.viewItemReview(itemId); 
		model.addAttribute("itemReview", list);
		return "viewItemReview";
	}
	
	//사용자 아이디별로 리뷰 출력
	@RequestMapping("/mypage/myReview")
	public String myReview(Model model, HttpSession session) {
		List<Review> list = rs.reviewList(session.getAttribute("userId").toString());
		model.addAttribute("reviewList", list);
		return "viewMyReview";
	}
	
	//리뷰 삭제
	@RequestMapping("/mypage/deleteReview/{reviewId}")
	public String deleteReview(@PathVariable("reviewId") int reviewId, HttpServletRequest request) {
		
		int result = rs.deleteReview(reviewId);
		System.out.println("Delete Result : " + result);
		return "redirect:/mypage/myReview";
	}
	
}
