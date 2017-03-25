package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.CartDAO;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.Category;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Cart get(int id) { 
		return sessionFactory.getCurrentSession().get(Cart.class, Integer.valueOf(id));
	}

	@Override
	public List<Cart> list() {
		String selectActiveCart = "FROM Cart WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCart);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public boolean add(Cart cart) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Cart cart) {
		try {
			
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Cart cart) {
		cart.setActive(false);
		 
		try {
	
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
