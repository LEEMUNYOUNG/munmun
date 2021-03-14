package com.example.sproute.controller;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class UsedCommand {
   private String sellerId;
   private Date sellDate;
   @NotBlank
   private String usingTime;
   private String usedId;
   private MultipartFile report;
   private String productId;
   private String categoryId;
   @Min(1)
   private int price;
   @Min(1)
   private int stock;
   @NotBlank
   private String title;
   @NotBlank
   private String description;
   private String addDate;
   
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
   public String getUsedId() {
      return usedId;
   }
   public void setUsedId(String usedId) {
      this.usedId = usedId;
   }
   public MultipartFile getReport() {
      return report;
   }
   public void setReport(MultipartFile report) {
      this.report = report;
   }
   public String getProductId() {
      return productId;
   }
   public void setProductId(String productId) {
      this.productId = productId;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public int getStock() {
      return stock;
   }
   public void setStock(int stock) {
      this.stock = stock;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getDescription() {
      return description;
   }
   public void setDescription(String description) {
      this.description = description;
   }
   public String getAddDate() {
      return addDate;
   }
   public void setAddDate(String addDate) {
      this.addDate = addDate;
   }
   public String getCategoryId() {
      return categoryId;
   }
   public void setCategoryId(String categoryId) {
      this.categoryId = categoryId;
   }
   @Override
   public String toString() {
      return "UsedCommand [sellerId=" + sellerId + ", sellDate=" + sellDate + ", usingTime=" + usingTime + ", usedId="
            + usedId + ", report=" + report + ", productId=" + productId + ", categoryId=" + categoryId + ", price="
            + price + ", stock=" + stock + ", title=" + title + ", description=" + description + ", addDate="
            + addDate + "]";
   }
   
}