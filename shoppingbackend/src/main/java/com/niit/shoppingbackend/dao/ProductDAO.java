package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.CPro;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Product;

public interface ProductDAO {

	Product get(int id);
	List<Product> list();
	
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	List<CPro> getPlist();
	List getPlistById(int id);
	
	List getPlistByPId(int id);
	List getPlistByColor(String color);
}
