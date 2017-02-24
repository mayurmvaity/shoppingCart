package com.niit.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		
		Category category=new Category();
		
		//adding first category
		category.setId(1);
		category.setName("Television");
		category.setDescription("This is some desc for television");
		category.setImageURL("CAT_1.png");
		
		categories.add(category);
		
		//second category
		category=new Category();
		
		category.setId(2);
		category.setName("Mobiles");
		category.setDescription("This is some desc for mobiles");
		category.setImageURL("CAT_2.png");
		
		categories.add(category);
		
				//third category
				category=new Category();
				
				category.setId(3);
				category.setName("Laptops");
				category.setDescription("This is some desc for laptops");
				category.setImageURL("CAT_3.png");
				
				categories.add(category);
		
	}
	
	
	
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}
