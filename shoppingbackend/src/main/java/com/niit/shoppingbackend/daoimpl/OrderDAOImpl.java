package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.OrderDAO;
import com.niit.shoppingbackend.dto.Ordertable;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Ordertable get(int id) {
		return sessionFactory.getCurrentSession().get(Ordertable.class, Integer.valueOf(id));
	}

	@Override
	public List<Ordertable> list() {
		String selectActiveOrder = "FROM Ordertable WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveOrder);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public boolean add(Ordertable order) {
		try {
			
			sessionFactory.getCurrentSession().save(order);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Ordertable order) {
		try {
			
			sessionFactory.getCurrentSession().update(order);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Ordertable order) {
		order.setActive(false);
		try {
			
			sessionFactory.getCurrentSession().update(order);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
