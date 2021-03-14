package com.example.sproute.domain;

import java.util.Date;

import javax.validation.constraints.Min;

public class Bidding {
	private String bidId;
	private String itemId;
	private String buyerId;
	private Date applyDate;
	@Min(1)
	private int bCount;
	@Min(1)
	private int price;
	private int maxPrice;
	private int check;
	private Auction auction;
	
	public String getBidId() {
		return bidId;
	}
	public void setBidId(String bidId) {
		this.bidId = bidId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public int getbCount() {
		return bCount;
	}
	public void setbCount(int bCount) {
		this.bCount = bCount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Auction getAuction() {
		return auction;
	}
	public void setAuction(Auction auction) {
		this.auction = auction;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}

	public String toString() {
		return "Bidding [bidId=" + bidId + ", itemId=" + itemId + ", buyerId=" + buyerId + ", applyDate=" + applyDate
				+ ", bCount=" + bCount + ", price=" + price + ", maxPrice=" + maxPrice + ", check=" + check
				+ ", auction=" + auction + "]";
	}
	
	
}
