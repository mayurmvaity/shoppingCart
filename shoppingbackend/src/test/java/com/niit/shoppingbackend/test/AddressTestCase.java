package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.UserTable;

public class AddressTestCase {
private static AnnotationConfigApplicationContext context;
	
	private static AddressDAO addressDAO;
	
	private Address address;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		addressDAO = (AddressDAO) context.getBean("addressDAO");
		
	}
	
	@Test
	public void testCRUDCategory() {
		//add operation
		address =new Address();
		
	
		address.setAdd1("abdfiabri1");
		address.setAdd2("abdfiabri2");
		address.setAdd3("abdfiabri3");
		address.setState("Krypton");
		address.setCity("ELcity");
		address.setPincode(400081);
		
		
		
		assertEquals("Successfully added a user inside the table",true,addressDAO.add(address));
		
		address =new Address();
		
		
		address.setAdd1("abdf173ri1");
		address.setAdd2("abdf173bri2");
		address.setAdd3("abdf173ri3");
		address.setState("Maha");
		address.setCity("Mum");
		address.setPincode(400080);
	
		
		assertEquals("Successfully added a User inside the table",true,addressDAO.add(address));
		
		//fetchaing and updating
		address = addressDAO.get(2);
		
		address.setAdd1("BILLION");
	
		assertEquals("Successfully updated a user in the table",true,addressDAO.update(address));
		
		//delete the category
		address = addressDAO.get(2);
		assertEquals("Successfully deleted a user in the table",true,addressDAO.delete(address));
		
		//fetching the list
		assertEquals("Successfully fetched the list of a users from the table",1,addressDAO.list().size());
		
	}
	
}
