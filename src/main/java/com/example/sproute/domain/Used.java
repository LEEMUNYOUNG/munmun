package com.example.sproute.domain;

import java.util.Date;

public class Used {
	private String sellerId;
	private Date sellDate;
	private String usingTime;
	private Item item;
	private String usedId;
	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public Date getSellDate() {
		return sellDate;
	}
	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
	public String getUsingTime() {
		return usingTime;
	}
	public void setUsingTime(String usingTime) {
		this.usingTime = usingTime;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getUsedId() {
		return usedId;
	}
	public void setUsedId(String usedId) {
		this.usedId = usedId;
	}
}
