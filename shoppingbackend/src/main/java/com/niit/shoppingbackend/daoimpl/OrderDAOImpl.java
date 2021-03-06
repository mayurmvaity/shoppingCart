package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.OrderDAO;
import com.niit.shoppingbackend.dto.Ordertable;
import com.niit.shoppingbackend.dto.UserTable;

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

	@Override
	public List<Ordertable> getByUser(UserTable user) {
		String selectActiveSupplier = "FROM Ordertable WHERE active = :active and ordered =:ordered and user = :user";
		//String selectActiveSupplier = "FROM Ordertable WHERE active = :active and delivered = :delivered and ordered =:ordered and user = :user";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveSupplier);
		
		query.setParameter("active", true);
		//query.setParameter("delivered", false);
		query.setParameter("ordered", true);
		query.setParameter("user", user);
		
		return query.getResultList();
	}

	@Override
	public List<Ordertable> getByOrdered() {
		String selectActiveOrder = "FROM Ordertable WHERE active = :active and ordered = :ordered";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveOrder);
		
		query.setParameter("active", true);
		query.setParameter("ordered", true);
		
		return query.getResultList();
	}
	
	
}
