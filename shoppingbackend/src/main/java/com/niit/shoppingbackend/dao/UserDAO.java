package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.UserTable;

public interface UserDAO {

	UserTable get(int id);
	List<UserTable> list();
	boolean add(UserTable user);
	boolean update(UserTable user);
	boolean delete(UserTable user);
	
	UserTable valid(String email, String pw);
	
	UserTable getUserByEmail(String email);
	boolean userExists(String email);
}
