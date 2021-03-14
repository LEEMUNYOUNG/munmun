package com.example.repository.mapper;

import com.example.sproute.domain.Review;

public interface ReviewMapper {
	int insertReview(Review review);
	
	int deleteReview(int reviewId);
	
	int updateReview(Review review);
}
