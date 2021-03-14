package com.example.repository.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.sproute.domain.Item;

@Repository
public class ItemMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public Integer insertItem(Item item) {
		Integer result = sqlSession.getMapper(ItemMapper.class).insertItem(item);
		return result;
	}
	
	public List<Item> selectUsedItem(String categoryId) {
		return sqlSession.getMapper(ItemMapper.class).selectUsedItem(categoryId);
	}
	
	public Item selectItem(String itemId) {
		return sqlSession.getMapper(ItemMapper.class).selectItem(itemId);
	}
	
	public List<Item> selectItemByProductId(String productId) {
		return sqlSession.getMapper(ItemMapper.class).selectItemByProductId(productId);
	}

	public List<Item> selectAuctionItem(String categoryId) {
		return sqlSession.getMapper(ItemMapper.class).selectAuctionItem(categoryId);
	}
	
	public List<Item> selectUsedItemByUserId(String sellerId) {
		return sqlSession.getMapper(ItemMapper.class).selectUsedItemByUserId(sellerId);
	}
	
	public void deleteUsedItem(String itemId) {
		sqlSession.getMapper(ItemMapper.class).deleteUsedItem(itemId);
	}
	
	public void updateUsedItem(Item item) {
		sqlSession.getMapper(ItemMapper.class).updateUsedItem(item);
	}
	
	public List<Item> selectItemByProduct(String categoryId, String productId) {
		return sqlSession.getMapper(ItemMapper.class).selectItemByProduct(categoryId, productId);
	}
	
	public List<Item> selectAllAuction(String categoryId) {
		return sqlSession.getMapper(ItemMapper.class).selectAllAuction(categoryId);
	}
	
	public boolean isItemInStock(String itemId) throws DataAccessException {
		return sqlSession.getMapper(ItemMapper.class).isItemInStock(itemId);
	}
	
	public int getItemStock(String itemId) {
		return sqlSession.getMapper(ItemMapper.class).getItemStock(itemId);
	}
	
	public void updateStock(int stock, String itemId) {
		sqlSession.getMapper(ItemMapper.class).updateStock(stock, itemId);
	}
}
