package com.example.repository.session;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Review;

@Repository
public class ReviewSessionRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private final String namespace = "com.example.repository.mapper.ReviewMapper";
	
	//특정 회원 리뷰 조회
	public List<Review> reviewList(String userId) {
		List<Review> list = sqlSession.selectList(namespace + ".selectReviewByUserId", userId);
		
		return list;
	}
	
	//아이템 아이디로 리뷰 조회
	public List<Review> ItemReviewList(String itemId){
		List<Review> itemReviewList = sqlSession.selectList(namespace + ".selectReviewByItemId", itemId);
		
		return itemReviewList;
	}
	
	//리뷰아이디로 리뷰 조회
	public Review selectReviewbyReviewId(int reviewId) {
		return sqlSession.selectOne(namespace + ".selectReviewByReviewId", reviewId);
	}
	
	//리뷰 수정
	/*public int updateReview(Review review) {
		return sqlSession.update(namespace + ".updateReview", review);
	}*/
}
