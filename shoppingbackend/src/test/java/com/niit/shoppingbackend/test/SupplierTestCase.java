package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dto.Supplier;

public class SupplierTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static SupplierDAO supplierDAO;
	
	private Supplier supplier;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
	}
	
	
	@Test
	public void testCRUDSupplier() {
		
		// add op
		supplier = new Supplier();
		
		supplier.setSname("Samsung International");
		supplier.setSdesc("this is samsung details");
		
		assertEquals("Successfully added a supplier inside the table",true,supplierDAO.add(supplier));
		
		supplier = new Supplier();
		
		supplier.setSname("Reliance Digital");
		supplier.setSdesc("this is reliance digital details");
		
		assertEquals("Successfully added a supplier inside the table",true,supplierDAO.add(supplier));
		
		// fetching and update 
		supplier = supplierDAO.get(2);
		
		supplier.setSname("Reliance INDIA");
		
		assertEquals("Successfully updated a supplier in the table",true,supplierDAO.update(supplier));
		
		// deleting 
		supplier = supplierDAO.get(2);
		
		assertEquals("Successfully deleted a supplier in the table",true,supplierDAO.delete(supplier));
		
		// fetching the lit
		assertEquals("Successfully fetched a supplier list",1,supplierDAO.list().size());
		
	}
	
	
}
