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
	
/* @Test
	public void testAddCategory()
	{
		category =new Category();
		
		category.setName("Samsung");
		category.setDescription("This is some desc for Samsung");
		category.setImageURL("CAT_1.png");
		
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
		
		
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		
		category = categoryDAO.get(1);
		
		assertEquals("Successfully fetched a category inside the table","Samsung",category.getName());
		
	}*/
		
	/*	@Test
		public void testUpdateCategory() {
		
		
			category = categoryDAO.get(1);
			
			category.setName("SAMSUNG");
		
			assertEquals("Successfully updated a category in the table",true,categoryDAO.update(category));
		
		}
	*/
	
	/*@Test
	public void testDeleteCategory() {
	
	
		category = categoryDAO.get(1);
		assertEquals("Successfully deleted a category in the table",true,categoryDAO.delete(category));
	
	}*/
	
	/* @Test
	public void testListCategory() {
	
		assertEquals("Successfully fetched the list of a categories from the table",1,categoryDAO.list().size());
	
	} */
	
	@Test
	public void testCRUDCategory() {
		//add operation
		category =new Category();
		
		category.setName("Macintosh");
		category.setDescription("This is some desc for Macintosh");
		category.setImageURL("CAT_2mac.png");
		
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
		
		category =new Category();
		
		category.setName("Alienware");
		category.setDescription("This is some desc for alienware");
		category.setImageURL("CAT_3.png");
		
		assertEquals("Successfully added a category inside the table",true,categoryDAO.add(category));
		
		//fetchaing and updating
		category = categoryDAO.get(2);
		
		category.setName("OS-X");
	
		assertEquals("Successfully updated a category in the table",true,categoryDAO.update(category));
		
		//delete the category
		category = categoryDAO.get(2);
		assertEquals("Successfully deleted a category in the table",true,categoryDAO.delete(category));
		
		//fetching the list
		assertEquals("Successfully fetched the list of a categories from the table",1,categoryDAO.list().size());
		
	}
	
}
