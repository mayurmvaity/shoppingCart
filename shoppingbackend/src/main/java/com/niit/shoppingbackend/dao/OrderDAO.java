package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Ordertable;
import com.niit.shoppingbackend.dto.UserTable;

public interface OrderDAO {

	Ordertable get(int id);
	List<Ordertable> list();
	boolean add(Ordertable order);
	boolean update(Ordertable order);
	boolean delete(Ordertable order);
	
	List<Ordertable> getByUser(UserTable user);
	List<Ordertable> getByOrdered();
}
