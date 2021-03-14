package com.example.sproute.domain;

public class CartItem {
	private Item item;		//Item 객체 추가
	private int quantity;
	private boolean inStock;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	public double getTotalPrice() {		//해당 아이템의 총가격 구하기
		if (item != null) {
			return item.getPrice() * quantity;
		}
		else {
			return 0;
		}
	}

	public void incrementQuantity() {
		quantity++;
	}	
	
	public void decrementQuantity() {
		quantity--;
	}
}
