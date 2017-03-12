package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dto.Address;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Address get(int id) {
		
		return sessionFactory.getCurrentSession().get(Address.class, Integer.valueOf(id));
	
	}

	@Override
	public List<Address> list() {
		
		String selectActiveAddress = "FROM Address WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveAddress);
		
		query.setParameter("active", true);
		
		return query.getResultList();
		
	}

	@Override
	public boolean add(Address address) {
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().save(address);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Address address) {
		
		try {
			
			sessionFactory.getCurrentSession().update(address);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean delete(Address address) {

		address.setActive(false);
		 
		try {
	
			sessionFactory.getCurrentSession().update(address);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
