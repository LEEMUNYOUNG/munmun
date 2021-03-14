package com.example.sproute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.mapper.ItemMapperRepository;
import com.example.repository.session.ItemSessionRepository;
import com.example.sproute.domain.Item;

@Service
public class ItemService {
	@Autowired
	private ItemMapperRepository itemRepository;
	@Autowired
	private ItemSessionRepository isr;
	
	public Integer insertItem(Item item) {
		return itemRepository.insertItem(item);
	}
	
	public List<Item> selectUsedItem(String categoryId) {
		return itemRepository.selectUsedItem(categoryId);
	}
	
	public List<Item> selectAuctionItem(String categoryId) {
		return itemRepository.selectAuctionItem(categoryId);
	}
	
	public Item selectItem(String itemId) {
		return itemRepository.selectItem(itemId);
	}
	
	public List<Item> selectItemByProductId(String productId) {
		return itemRepository.selectItemByProductId(productId);
	}
	
	public List<Item> selectUsedItemByUserId(String sellerId) {
		return itemRepository.selectUsedItemByUserId(sellerId);
	}
	
	public void deleteUsedItem(String itemId) {
		itemRepository.deleteUsedItem(itemId);
	}
	
	public void updateUsedItem(Item item) {
		itemRepository.updateUsedItem(item);
	}
	public List<Item> selectItemByProduct(String categoryId, String productId) {
		return itemRepository.selectItemByProduct(categoryId, productId);
	}	
	
	public boolean isItemInStock(String itemId) {
		return (itemRepository.getItemStock(itemId) > 0);
	}	
	
	public Integer updateAuctionItem(Item item) {
		return isr.updateAuctionItem(item);
	}
	
	public void updateStock(int stock, String itemId) {
		itemRepository.updateStock(stock, itemId);
	}
	
	public List<Item> selectAllAuction(String categoryId) {
		return itemRepository.selectAllAuction(categoryId);
	}
}
