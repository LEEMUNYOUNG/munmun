package com.example.repository.mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Review;

@Repository
public class ReviewMapperRepository {
	
	@Autowired
	private ReviewMapper rm;
	@Autowired
	private SqlSessionTemplate session;
	
	public int insertReview(Review review) {
		return rm.insertReview(review);
	}
	
	public int deleteReview(int reviewId) {
		return session.getMapper(ReviewMapper.class).deleteReview(reviewId);
	}
	public int updateReview(Review review) {
		return session.getMapper(ReviewMapper.class).updateReview(review);
	}
	
}
