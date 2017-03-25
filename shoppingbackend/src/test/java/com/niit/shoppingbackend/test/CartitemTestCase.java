package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.CartDAO;
import com.niit.shoppingbackend.dao.CartitemDAO;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.Cartitem;

public class CartitemTestCase {

private static AnnotationConfigApplicationContext context;
	
	private static CartitemDAO cartitemDAO;
	
	private Cartitem cartitem;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		cartitemDAO = (CartitemDAO) context.getBean("cartitemDAO");
		
	}
	

	
	@Test
	public void testCRUDCategory() {
		//add operation
		cartitem =new Cartitem();
		
		
		cartitem.setCartid(5);
		cartitem.setIno(69);
		cartitem.setIquantity(2);
		cartitem.setIprice(5000);
		cartitem.setItotal(10000);
		//category.setImageURL("CAT_2mac.png");
		
		assertEquals("Successfully added a cart inside the table",true,cartitemDAO.add(cartitem));
		
		cartitem =new Cartitem();
		
		
		cartitem.setCartid(5);
		cartitem.setIno(70);
		cartitem.setIquantity(3);
		cartitem.setIprice(5000);
		cartitem.setItotal(15000);
		//category.setImageURL("CAT_2mac.png");
		
		assertEquals("Successfully added a cart inside the table",true,cartitemDAO.add(cartitem));
		//fetchaing and updating
		cartitem = cartitemDAO.get(2);
		
		cartitem.setIquantity(4);
	
		assertEquals("Successfully updated a cart in the table",true,cartitemDAO.update(cartitem));
		
		//delete the category
		cartitem = cartitemDAO.get(3);
		assertEquals("Successfully deleted a cart in the table",true,cartitemDAO.delete(cartitem));
		
		//fetching the list
		assertEquals("Successfully fetched the list of a cart from the table",1,cartitemDAO.list().size());
		
	}
	
	
}
