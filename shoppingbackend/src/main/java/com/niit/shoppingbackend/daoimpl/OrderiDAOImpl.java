package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.OrderiDAO;
import com.niit.shoppingbackend.dto.Orderi;


@Repository("orderiDAO")
@Transactional
public class OrderiDAOImpl implements OrderiDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public Orderi get(int id) {
		return sessionFactory.getCurrentSession().get(Orderi.class, Integer.valueOf(id));
	}

	@Override
	public List<Orderi> list() {
		String selectActiveSupplier = "FROM Orderi WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveSupplier);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public boolean add(Orderi orderi) {
		try {
			
			sessionFactory.getCurrentSession().save(orderi);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Orderi orderi) {
		try {
			
			sessionFactory.getCurrentSession().update(orderi);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Orderi orderi) {
		orderi.setActive(false);
		try {
			
			sessionFactory.getCurrentSession().update(orderi);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Orderi> getUndelivered(int uid) {
		String selectActiveSupplier = "FROM Orderi WHERE active = :active and delivered = :delivered and ordered =:ordered and uid = :uid";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveSupplier);
		
		query.setParameter("active", true);
		query.setParameter("delivered", false);
		query.setParameter("ordered", true);
		query.setParameter("uid", uid);
		
		return query.getResultList();
	}
	
	
	
}
