package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Stock;

public interface StockDAO {
	
	
	Stock get(int id);
	List<Stock> list();
	boolean add(Stock stock);
	boolean update(Stock stock);
	boolean delete(Stock stock);
	

}
