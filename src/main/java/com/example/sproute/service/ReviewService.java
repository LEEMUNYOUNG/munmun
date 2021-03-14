package com.example.sproute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.mapper.ReviewMapperRepository;
import com.example.repository.session.ReviewSessionRepository;
import com.example.sproute.domain.Review;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewMapperRepository rm;
	
	@Autowired 
	private ReviewSessionRepository rs;
	
	//리뷰 추가
	public int insertReview(Review review) {
		return rm.insertReview(review);
	}
	//특정 회원 리뷰 조회
	public List<Review> reviewList(String userId){
		return rs.reviewList(userId);
	}
	//특정 아이템 리뷰 조회
	public List<Review> viewItemReview(String itemId){
		return rs.ItemReviewList(itemId);
	}
	//리뷰아이디로 리뷰 조회
	public Review selectReviewByReviewId(int reviewId) {
		return rs.selectReviewbyReviewId(reviewId);
	}
	//리뷰 삭제
	public int deleteReview(int reviewId) {
		return rm.deleteReview(reviewId);
	}
	//리뷰 수정
	public int updateReview(Review review) {
		return rm.updateReview(review);
	}
	
}
