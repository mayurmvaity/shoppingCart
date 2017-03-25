package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Cart;

public interface CartDAO {

	Cart get(int id);
	List<Cart> list();
	boolean add(Cart cart);
	boolean update(Cart cart);
	boolean delete(Cart cart);
	
}
