package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.StockDAO;
import com.niit.shoppingbackend.dto.Stock;

public class StockTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static StockDAO stockDAO;
	
	private Stock stock;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		stockDAO = (StockDAO) context.getBean("stockDAO");
		
	}
	
	@Test
	public void testCRUDStock() {
		
		// add operation
		stock = new Stock();
		
		stock.setPid(3);
		stock.setSid(1);
		stock.setPrice(15000);
		stock.setAmount(150);
		
		assertEquals("Successfully added new stock to the table",true,stockDAO.add(stock));
		
		stock = new Stock();
		
		stock.setPid(2);
		stock.setSid(1);
		stock.setPrice(25000);
		stock.setAmount(100);
		
		assertEquals("Successfully added new stock to the table",true,stockDAO.add(stock));
		
		// fetching and update
		stock = stockDAO.get(2);
		
		stock.setPrice(30000);
		
		assertEquals("Successfully updated stock price",true,stockDAO.update(stock)); 
		
		// delete
		stock = stockDAO.get(2);
		
		assertEquals("Successfully dleted stock from the table",true,stockDAO.delete(stock));
		
		// get list
		assertEquals("Successfully got list from stock table",1,stockDAO.list().size());
		
	}
	
	
}
