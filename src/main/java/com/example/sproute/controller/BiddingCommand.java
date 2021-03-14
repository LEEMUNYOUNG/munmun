package com.example.sproute.controller;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.example.sproute.domain.Bidding;

public class BiddingCommand {
	private String bidId;
	private String itemId;
	private String buyerId;
	private Date applyDate;
	private int bCount;
	private int price;
	@Valid
	private Bidding bidding; //여기안에 들어감.
	
	public Bidding getBidding() {
		return bidding;
	}
	public void setBidding(Bidding bidding) {
		this.bidding = bidding;
	}
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
	
	public String toString() {
		return "BiddingCommand [bidId=" + bidId + ", itemId=" + itemId + ", buyerId=" + buyerId + ", applyDate="
				+ applyDate + ", bCount=" + bCount + ", price=" + price + ", bidding=" + bidding + "]";
	}
	
}
