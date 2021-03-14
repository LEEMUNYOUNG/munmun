package com.example.sproute.domain;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.aspectj.weaver.Iterators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;

import com.example.sproute.service.ItemService;


@SuppressWarnings("serial")
public class Cart implements Serializable{
	
	@Autowired
	ItemService itemService;
	
	
	private final Map<String, CartItem> itemMap = Collections.synchronizedMap(new HashMap<String, CartItem>());

	private final PagedListHolder<CartItem> itemList = new PagedListHolder<CartItem>();
	private final PagedListHolder<CartItem> usedItemList = new PagedListHolder<CartItem>();
	
	public Cart() {
		this.itemList.setPageSize(4);
		this.usedItemList.setPageSize(4);
	}

	public Iterator<CartItem> getSaleCartItems() { return itemList.getSource().iterator(); }
	public Iterator<CartItem> getUsedCartItems() { return usedItemList.getSource().iterator(); }
	public Iterator<CartItem> getAll() { 
		return Iterators.append(itemList.getSource().iterator(), usedItemList.getSource().iterator());
	}
	
	public PagedListHolder<CartItem> getCartItemList() { return itemList; }
	public PagedListHolder<CartItem> getUsedCartItemList() { return usedItemList; }

	public int getNumberOfItems() { return itemList.getSource().size(); }
	public int getNumberOfUsedItems() { return usedItemList.getSource().size(); }

	public boolean containsItemId(String itemId) {
	    return itemMap.containsKey(itemId);
	}

	public void addItem(Item item, boolean isInStock) {
	    CartItem cartItem = itemMap.get(item.getItemId());
	    if (cartItem == null) {
	      cartItem = new CartItem();
	      cartItem.setItem(item);
	      cartItem.setQuantity(0);
	      cartItem.setInStock(isInStock);
	      itemMap.put(item.getItemId(), cartItem);
	      if (cartItem.getItem().getCategoryId().equals("sale")) {
	    	  itemList.getSource().add(cartItem);
	      } else
	    	  usedItemList.getSource().add(cartItem);
	    }
	    cartItem.incrementQuantity();
	}

	public Item removeItemById(String itemId) {
	    CartItem cartItem = itemMap.remove(itemId);
	    if (cartItem == null) {
	      return null;
	    }
	    else {
	    	if(cartItem.getItem().getCategoryId().equals("sale")){
	    		itemList.getSource().remove(cartItem);
	    		cartItem.incrementQuantity();
	    	}
	    	else {  
	    		usedItemList.getSource().remove(cartItem); 
	    		cartItem.incrementQuantity();
	    	}
	    }
	    return cartItem.getItem();
	}
	  
	public void incrementQuantityByItemId(String itemId) {
	    CartItem cartItem = itemMap.get(itemId);
	    cartItem.incrementQuantity();
	}

	public void setQuantityByItemId(String itemId, int quantity) {
	    CartItem cartItem = itemMap.get(itemId);
	    cartItem.setQuantity(quantity);
	}
	
	public int getQuantityByItemId(String itemId) {
		CartItem cartItem = itemMap.get(itemId);
		System.out.println(cartItem.getQuantity());
		return cartItem.getQuantity();
	}

	public double getSubTotal() {	//장바구니에 담긴 아이템의 전체 가격
	    double subTotal = 0;
	    Iterator<CartItem> items = getSaleCartItems();
	    
	    while (items.hasNext()) {
	      CartItem cartItem = (CartItem) items.next(); 
	      Item item;
	      if (cartItem.getItem().getCategoryId().equals("sale")) {
	    	  item = cartItem.getItem();
	    	  double price = item.getPrice();
	    	  int quantity = cartItem.getQuantity();
	    	  subTotal += price * quantity;
			}
	    }
	    return subTotal;
	}
	
	public double getUsedSubTotal() {	//장바구니에 담긴 아이템의 전체 가격
	    double subTotal = 0;
	    Iterator<CartItem> useditems = getUsedCartItems();
	    
	    while (useditems.hasNext()) {
	      CartItem cartItem = (CartItem) useditems.next(); 
	      Item item;
	      if (cartItem.getItem().getCategoryId().equals("used")) {
	    	  item = cartItem.getItem();
	    	  double price = item.getPrice();
	    	  int quantity = cartItem.getQuantity();
	    	  subTotal += price * quantity;
			}
	    }
	    return subTotal;
	}
}
