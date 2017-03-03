package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	@Test
	public void testCRUDProduct() {
		
		//add opertaion
		product =new Product();
		
		product.setPname("Galaxy S7 edge");
		product.setPdesc("This is desc of galaxy s7 edge");
		product.setCid(3);
		product.setPrice(50900);
		product.setPimage("s7edge.png");

		assertEquals("Successfully added a product to the table",true,productDAO.add(product));
		
		product =new Product();
		
		product.setPname("Galaxy A9 pro");
		product.setPdesc("This is desc of galaxy A9 pro");
		product.setCid(3);
		product.setPrice(14900);
		product.setPimage("a9pro.png");

		assertEquals("Successfully added a product to the table",true,productDAO.add(product));
		
		// fetching and update 
		
		product = productDAO.get(2);
		product.setPname("NOTE5");
		
		assertEquals("Successfully updated product name",true,productDAO.update(product));
		
		// delete category
		
		product = productDAO.get(2);
		product.setActive(false);
		
		assertEquals("Successfully deleted product from table",true, productDAO.update(product));
		
		//fetching the list
		assertEquals("Successfully fetched list",1,productDAO.list().size());
		
	}
	
}
