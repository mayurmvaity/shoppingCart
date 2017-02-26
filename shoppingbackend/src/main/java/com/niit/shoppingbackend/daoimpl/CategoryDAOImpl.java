package com.niit.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category=new Category();
		
		//adding first category
		category.setId(1);
		category.setName("Samsung");
		category.setDescription("This is some desc for Samsung");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		//second category
		category=new Category();
		
		category.setId(2);
		category.setName("HTC");
		category.setDescription("This is some desc for HTC");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
				//third category
				category=new Category();
				
				category.setId(3);
				category.setName("OnePlus");
				category.setDescription("This is some desc for OnePlus");
				category.setImageURL("CAT_3.png");
				
				categories.add(category);
		
	}
	
	
	
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}





	@Override
	public Category get(int id) {
		
		// enhanced for loop
		for(Category category : categories) {
			
			if(category.getId() == id) return category;
			
		}
		return null;
	}





	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
		
	
	}

}
