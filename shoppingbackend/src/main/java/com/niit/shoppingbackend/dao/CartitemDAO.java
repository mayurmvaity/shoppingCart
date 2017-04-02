package com.niit.shoppingbackend.dao;

import java.util.List;

import com.niit.shoppingbackend.dto.Cartitem;

public interface CartitemDAO {

	Cartitem get(int id);
	List<Cartitem> list();
	boolean add(Cartitem cartitem);
	boolean update(Cartitem cartitem);
	boolean delete(Cartitem cartitem);
	
	List<Cartitem> getByUserid(int userid);
	
	boolean productExists(int userid,int pid);
	Cartitem getByPid(int userid,int pid);
	
	
}
