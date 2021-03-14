package com.example.sproute.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Item {
	private String itemId;
	@NotEmpty
	private String productId;
	private String categoryId;
	@Min(1)
	private int price;
	@Min(1)
	private int stock;
	@NotEmpty
	private String title;
	@NotEmpty
	private String description;
	private String addDate;
	private String imgName;
	private int totalPrice;
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String toString() {
		return "Item [itemId=" + itemId + ", productId=" + productId + ", categoryId=" + categoryId + ", price=" + price
				+ ", stock=" + stock + ", title=" + title + ", description=" + description + ", addDate=" + addDate
				+ ", imgName=" + imgName + ", totalPrice=" + totalPrice + "]";
	}
	
		
}
