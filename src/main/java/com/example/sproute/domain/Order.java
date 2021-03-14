package com.example.sproute.domain;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.example.sproute.controller.OrderForm;

public class Order {
   String orderId;
   String userId;
   Date orderDate;
   @NotBlank
   String shipAddress;
   @NotBlank
   String address;
   int totalPrice;
   String cardType;
   @NotBlank
   @Pattern(regexp="^\\d{3}\\s\\d{4}\\s\\d{4}\\s\\d{4}$")
   String cardNumber;
   @NotBlank
   @Pattern(regexp="^\\d{2}/\\d{2}$")
   String expireDate;
   @NotBlank
   String name; // 회원이름
   String itemId;
   public String getOrderId() {
      return orderId;
   }
   public void setOrderId(String orderId) {
      this.orderId = orderId;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public Date getOrderDate() {
      return orderDate;
   }
   public void setOrderDate(Date orderDate) {
      this.orderDate = orderDate;
   }
   public String getShipAddress() {
      return shipAddress;
   }
   public void setShipAddress(String shipAddress) {
      this.shipAddress = shipAddress;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public int getTotalPrice() {
      return totalPrice;
   }
   public void setTotalPrice(int totalPrice) {
      this.totalPrice = totalPrice;
   }
   public String getCardType() {
      return cardType;
   }
   public void setCardType(String cardType) {
      this.cardType = cardType;
   }
   public String getCardNumber() {
      return cardNumber;
   }
   public void setCardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
   }
   public String getExpireDate() {
      return expireDate;
   }
   public void setExpireDate(String expireDate) {
      this.expireDate = expireDate;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getItemId() {
      return itemId;
   }
   public void setItemId(String itemId) {
      this.itemId = itemId;
   }
   public void initOrder(Account account) {
      name = account.getName();
      orderDate = new Date();
      userId = account.getUserId();
      
      shipAddress = "";
      address = account.getAddress();
      
      cardNumber = "999 9999 9999 9999";
      expireDate = "12/03";
       cardType = "Visa";
   }
   @Override
   public String toString() {
      return "Order [orderId=" + orderId + ", userId=" + userId + ", orderDate=" + orderDate + ", shipAddress="
            + shipAddress + ", address=" + address + ", totalPrice=" + totalPrice + ", cardType=" + cardType
            + ", cardNumber=" + cardNumber + ", expireDate=" + expireDate + ", name=" + name + "itemId=" + itemId + "]";
   }
   
}