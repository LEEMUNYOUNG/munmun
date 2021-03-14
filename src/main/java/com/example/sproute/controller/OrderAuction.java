package com.example.sproute.controller;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderAuction implements Serializable {
	private String auctionId = null;

	public String getAuctionId() {
		return auctionId;
	}

	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}
	
}
