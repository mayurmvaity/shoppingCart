package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
	}
	
	@Test
	public void testAddCategory()
	{
		category =new Category();
		
		category.setName("Samsung");
		category.setDescription("This is some desc for Samsung");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
		
		
	}
	
}
