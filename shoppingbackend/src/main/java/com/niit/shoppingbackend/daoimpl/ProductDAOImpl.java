package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dto.CPro;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<Product> list() {
	
		String selectActiveProduct = "FROM Product WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveProduct);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public Product get(int id) {
		
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
		
	}
	

	public Category getCategory(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		
	}
	
	@Override
	public boolean add(Product product) {

		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
			
		}
		
	}

	@Override
	public boolean update(Product product) {
		
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
			
		}
	}

	
	@Override
	public List<CPro> getPlist() {
		String hlist = "from Product p left outer join Category c ON p.cid=c.id where p.active= :active and c.active= :active";
		//String hlist="FROM Category where active= :active";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hlist);
		
		query.setParameter("active", true);
		
		
		return query.getResultList();
	}

	

	

	
}
