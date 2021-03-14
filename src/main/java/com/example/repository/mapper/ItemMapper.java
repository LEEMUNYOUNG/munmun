package com.example.repository.mapper;

import java.util.List;
import java.util.Map;

import com.example.sproute.domain.Item;

public interface ItemMapper {
	Integer insertItem(Item item);

	List<Item> selectUsedItem(String categoryId);
	
	List<Item> selectAuctionItem(String categoryId);
	
	List<Item> selectAllAuction(String cateforyId);
	
	Item selectItem(String itemId);
	
	List<Item> selectItemByProductId(String productId);
	
	List<Item> selectUsedItemByUserId(String sellerId);
	
	void deleteUsedItem(String itemId);
	
	void updateUsedItem(Item item);
	
	List<Item> selectItemByProduct(String categoryId, String productId);
	
	boolean isItemInStock(String itemId);	//구매하려는 상품이 재고 범위 내인지 아닌지?
	
	void updateInventoryQuantity(Map<String, Object> param);	//상품 재고 수량 update -> Order 구현시

	int getItemStock(String itemId);	//상품 재고 수량 -> Order 구현 시
	
	void updateStock(int stock, String itemId);
}
