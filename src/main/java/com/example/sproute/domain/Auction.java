package com.example.sproute.domain;

public class Auction {
   private Item item;
   private String sellerId;
   private int participant;
   private String deadline;
   private String auctionId;
   private String status;
   
   

   public Auction() {
   }

public Auction(Item item, String sellerId, int participant, String deadline, String auctionId, String status) {
		this.item = item;
		this.sellerId = sellerId;
		this.participant = participant;
		this.deadline = deadline;
		this.auctionId = auctionId;
		this.status = status;
	}
   
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
   public String getStatus() {
      return status;
   }
   public void setStatus(String status) {
      this.status = status;
   }

@Override
public String toString() {
	return "Auction [item=" + item + ", sellerId=" + sellerId + ", participant=" + participant + ", deadline="
			+ deadline + ", auctionId=" + auctionId + ", status=" + status + "]";
}
   
   
   
}