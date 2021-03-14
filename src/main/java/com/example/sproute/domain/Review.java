package com.example.sproute.domain;

public class Review {
	private int reviewId;
	private String userId;
	private String title;
	private double rating;
	private String content;
	private String itemId;
	
	public Review() {
		
	}
	
	
	public Review(int reviewId, String userId, String title, double rating, String content, String itemId) {
		super();
		this.reviewId = reviewId;
		this.userId = userId;
		this.title = title;
		this.rating = rating;
		this.content = content;
		this.itemId = itemId;
	}
	
	public Review(String userId, String title, double rating, String content, String itemId) {
		this.userId = userId;
		this.title = title;
		this.rating = rating;
		this.content = content;
		this.itemId = itemId;
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	
}
