package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.CartitemDAO;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.Cartitem;

@Repository("cartitemDAO")
@Transactional
public class CartItemDAOImpl implements CartitemDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public Cartitem get(int id) {

		return sessionFactory.getCurrentSession().get(Cartitem.class, Integer.valueOf(id));
		
	}

	@Override
	public List<Cartitem> list() {
		String selectActiveCartitem = "FROM Cartitem WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCartitem);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public boolean add(Cartitem cartitem) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().save(cartitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Cartitem cartitem) {
		try {
			
			sessionFactory.getCurrentSession().update(cartitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Cartitem cartitem) {
		//cartitem.setActive(false);
		 
		try {
	
			sessionFactory.getCurrentSession().delete(cartitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/*@Override
	public boolean delete(Cartitem cartitem) {
		cartitem.setActive(false);
		 
		try {
	
			sessionFactory.getCurrentSession().update(cartitem);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	*/
	
	@Override
	public List<Cartitem> getByUserid(int userid) {
		String selectActiveCartitem = "FROM Cartitem WHERE active = :active and userid = :userid";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCartitem);
		
		query.setParameter("active", true);
		query.setParameter("userid", userid);
		
		return query.getResultList();
	}

	@Override
	public boolean productExists(int userid, int pid) {
		String selectActiveCartitem = "FROM Cartitem WHERE active = :active and pid = :pid and userid = :userid";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCartitem);
		
		query.setParameter("active", true);
		query.setParameter("pid", pid);
		query.setParameter("userid", userid);
		System.out.println(query);
		try{
		
		if(query.getSingleResult()==null) return false;
		else return true;
		}
		catch(Exception e) {
			System.out.println("exception occurred");
			return false;
		}
		
	}

	@Override
	public Cartitem getByPid(int userid, int pid) {
		String selectActiveCartitem = "FROM Cartitem WHERE active = :active and pid = :pid and userid = :userid";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCartitem);
		
		query.setParameter("active", true);
		query.setParameter("pid", pid);
		query.setParameter("userid", userid);

		return (Cartitem) query.getSingleResult();
	}

	
	

}
