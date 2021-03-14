package com.example.sproute.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.sproute.domain.Review;
import com.example.sproute.service.ReviewService;

@Controller
public class UpdateReviewController {
	
	@Autowired
	private ReviewService rs;
	
	@ModelAttribute("updateReviewReq")
	public ReviewCommand formData(HttpServletRequest request, HttpSession session) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			int reviewId = Integer.valueOf(request.getParameter("reviewId"));
			
			Review review = rs.selectReviewByReviewId(reviewId);
			ReviewCommand rc = new ReviewCommand(reviewId, session.getAttribute("userId").toString(),
					review.getRating(), review.getContent(), review.getTitle(), review.getItemId());
			return rc;
		}
			return new ReviewCommand();
	}
	
	@GetMapping("/mypage/updateForm")
	public String updateForm(@RequestParam("reviewId") String reviewId, @ModelAttribute("updateReviewReq")ReviewCommand formData) {
		return "updateReviewForm";
	}
	
	@PostMapping("/mypage/updateForm")
	public String updateReview(@ModelAttribute("updateReviewReq")ReviewCommand req, HttpServletRequest request,RedirectAttributes redirect, Errors error) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "title", "update_title_empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "rating", "update_rating_empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "content", "update_content_empty");
		
		if(error.hasErrors()) {
			return "updateReviewForm";
		}
		int reviewId = Integer.valueOf(request.getParameter("reviewId"));
		String itemId = request.getParameter("itemId");
		
		Review review = new Review(reviewId, req.getUserId(), req.getTitle(),
				req.getRating(), req.getContent(), itemId);
		
		System.out.println("ReviewId test : " + reviewId);
		int result = rs.updateReview(review);
		System.out.println("Update Result : " + result);
		
		return "redirect:/mypage/myReview";
	}
}
