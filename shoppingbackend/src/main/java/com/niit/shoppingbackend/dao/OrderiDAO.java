package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Orderi;

public interface OrderiDAO {

	Orderi get(int id);
	List<Orderi> list();
	boolean add(Orderi orderi);
	boolean update(Orderi orderi);
	boolean delete(Orderi orderi);
	
	List<Orderi> getUndelivered(int uid);
}
