package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.User;

public interface UserDAO {

	User get(int id);
	List<User> list();
	boolean add(User user);
	boolean update(User user);
	boolean delete(User user);
	
	
}
