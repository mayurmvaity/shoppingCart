package com.niit.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.UserTable;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public UserTable get(int id) {
		
		return sessionFactory.getCurrentSession().get(UserTable.class, Integer.valueOf(id));
	
	}

	@Override
	public List<UserTable> list() {
		String selectActiveUser = "FROM User WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveUser);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	@Override
	public boolean add(UserTable user) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(UserTable user) {
		try {
			
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(UserTable user) {
		user.setActive(false);
		 
		try {
	
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public UserTable valid(String email, String pw) {
		String hlist = "from User u where u.active= :active and u.email = :email and u.pw= :pw";
		
		
		Query query = sessionFactory.getCurrentSession().createQuery(hlist);
		
		query.setParameter("active", true);
		query.setParameter("pw", pw);
		query.setParameter("email", email);
		
		List results = query.getResultList();
		return (UserTable) results.get(0);
		
		
	}

	@Override
	public UserTable getUserByEmail(String email) {
		
			String huser = "FROM UserTable WHERE email =:email";
			Query query = sessionFactory.getCurrentSession().createQuery(huser);
			query.setParameter("email", email);
			List<UserTable> ulist = query.getResultList();
			if (ulist != null && !ulist.isEmpty()) {
				return ulist.get(0);
			}
			return null;
	}

	@Override
	public boolean userExists(String email) {
		
		String selectActiveUser = "FROM UserTable WHERE active = :active and email = :email";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveUser);
		
		query.setParameter("active", true);
		query.setParameter("email", email);
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
	


}
