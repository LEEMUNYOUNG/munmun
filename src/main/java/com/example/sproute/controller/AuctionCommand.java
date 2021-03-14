package com.example.sproute.controller;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import com.example.sproute.domain.Auction;
import com.example.sproute.domain.Item;

public class AuctionCommand {
	@Valid
	private Item item;
	private String sellerId;
	private int participant;
	@Pattern(regexp="(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])\\s([1-9]|[01][0-9]|2[0-3]):([0-5][0-9])")
	private String deadline;
	private String auctionId;
	private MultipartFile report;
	private String status;
	//private Auction auction;
	
//	public Auction getAuction() {
//		return auction;
//	}
//	public void setAuction(Auction auction) {
//		this.auction = auction;
//	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public int getParticipant() {
		return participant;
	}
	public void setParticipant(int participant) {
		this.participant = participant;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(String auctionId) {
		this.auctionId = auctionId;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
