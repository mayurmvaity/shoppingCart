package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Supplier get(int id) {
		
		return sessionFactory.getCurrentSession().get(Supplier.class, Integer.valueOf(id));
		
	}

	@Override
	public List<Supplier> list() {
		
		String selectActiveSupplier = "FROM Supplier WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveSupplier);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public boolean add(Supplier supplier) {
		
		try {
			
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Supplier supplier) {
		
		try {
			
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Supplier supplier) {
		
		supplier.setActive(false);
		try {
			
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	
	
}
