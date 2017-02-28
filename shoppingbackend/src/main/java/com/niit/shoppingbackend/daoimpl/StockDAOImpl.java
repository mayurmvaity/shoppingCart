package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.StockDAO;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Stock;

@Repository("stockDAO")
@Transactional
public class StockDAOImpl implements StockDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public Stock get(int id) {
		
		return sessionFactory.getCurrentSession().get(Stock.class, Integer.valueOf(id));
		
	}

	@Override
	public List<Stock> list() {
		String selectActiveStock = "FROM Stock WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveStock);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public boolean add(Stock stock) {
		
		try {
			sessionFactory.getCurrentSession().save(stock);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean update(Stock stock) {
		try
		{
			sessionFactory.getCurrentSession().update(stock);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean delete(Stock stock) {
		stock.setActive(false);
		try {
			
			sessionFactory.getCurrentSession().update(stock);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
