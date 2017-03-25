package com.niit.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.UserTable;

public class UserTestCase {
private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private UserTable user;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	
	/*@Test
	public void testCRUDCategory() {
		//add operation
		user =new User();
		
		user.setFname("Adam");
		user.setLname("Scott");
		user.setRole("CUSTOMER");
		user.setPw("niit@123");
		user.setEmail("adamscott@apokalyps.com");
		user.setAdd1("abdfiabri1");
		user.setAdd2("abdfiabri2");
		user.setAdd3("abdfiabri3");
		user.setState("Krypton");
		user.setCity("ELcity");
		user.setPincode(400081);
		user.setPno(9920188240L);
		
		
		assertEquals("Successfully added a user inside the table",true,userDAO.add(user));
		
		user =new User();
		
		user.setFname("Bill");
		user.setLname("Goldberg");
		user.setRole("CUSTOMER");
		user.setPw("niit@124");
		user.setEmail("next173@apokalyps.com");
		user.setAdd1("abdf173ri1");
		user.setAdd2("abdf173bri2");
		user.setAdd3("abdf173ri3");
		user.setState("Maha");
		user.setCity("Mum");
		user.setPincode(400080);
		user.setPno(9920188240L);
		
		assertEquals("Successfully added a User inside the table",true,userDAO.add(user));
		
		//fetchaing and updating
		user = userDAO.get(2);
		
		user.setFname("BILLION");
	
		assertEquals("Successfully updated a user in the table",true,userDAO.update(user));
		
		//delete the category
		user = userDAO.get(2);
		assertEquals("Successfully deleted a user in the table",true,userDAO.delete(user));
		
		//fetching the list
		assertEquals("Successfully fetched the list of a users from the table",1,userDAO.list().size());
		
	}*/
	@Test
	public void testCRUDCategory() {
		
		
		//fetchaing and updating
		user = userDAO.get(2);
		
		user.setFname("Cill");
		user.setLname("Marko");
	
		assertEquals("Successfully updated a user in the table",true,userDAO.update(user));
		
		
		
	}
}
