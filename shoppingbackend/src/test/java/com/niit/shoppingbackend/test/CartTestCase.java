package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.CartDAO;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.Category;

public class CartTestCase {
	private static AnnotationConfigApplicationContext context;
	
	private static CartDAO cartDAO;
	
	private Cart cart;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		cartDAO = (CartDAO) context.getBean("cartDAO");
		
	}
	

	
	@Test
	public void testCRUDCategory() {
		//add operation
		cart =new Cart();
		
		
		cart.setItems(10);
		cart.setTotalcost(15000);
		cart.setUserid(2);
		//category.setImageURL("CAT_2mac.png");
		
		assertEquals("Successfully added a cart inside the table",true,cartDAO.add(cart));
		
		cart =new Cart();
		
		
		cart.setItems(13);
		cart.setTotalcost(144000);
		cart.setUserid(1);
		//category.setImageURL("CAT_2mac.png");
		
		assertEquals("Successfully added a cart inside the table",true,cartDAO.add(cart));
		//fetchaing and updating
		cart = cartDAO.get(2);
		
		cart.setItems(9);
	
		assertEquals("Successfully updated a cart in the table",true,cartDAO.update(cart));
		
		//delete the category
		cart = cartDAO.get(6);
		assertEquals("Successfully deleted a cart in the table",true,cartDAO.delete(cart));
		
		//fetching the list
		assertEquals("Successfully fetched the list of a cart from the table",1,cartDAO.list().size());
		
	}
}
