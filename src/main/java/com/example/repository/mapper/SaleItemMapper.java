package com.example.repository.mapper;
import java.util.List;

import com.example.sproute.domain.Item;
import com.example.sproute.domain.Product;

public interface SaleItemMapper {
	
	List<Item> getItemListByCategory(String categoryId);
	List<Item> getItemListByProduct(Product product);
	Item getItem(String itemId);

}
