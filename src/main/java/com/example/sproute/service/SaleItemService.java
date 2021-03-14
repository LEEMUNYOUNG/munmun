package com.example.sproute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.mapper.SaleItemMapperRepository;
import com.example.sproute.domain.Item;
import com.example.sproute.domain.Product;

@Service
public class SaleItemService {
	
	@Autowired
	private SaleItemMapperRepository saleItemRepository;
	
	
	public List<Item> getItemListByCategory(String categoryId) {
		return saleItemRepository.getItemListByCategory(categoryId);
	}
	
	public List<Item> getItemListByProduct(Product product) {
		return saleItemRepository.getItemListByProduct(product);
	}
	
	public Item getItem(String itemId) {
		return saleItemRepository.getItem(itemId);
	}
	

}
