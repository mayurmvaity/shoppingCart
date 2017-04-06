package com.niit.ecommerce.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.CartitemDAO;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.OrderDAO;
import com.niit.shoppingbackend.dao.OrderiDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.UserTable;

@Controller
@RequestMapping(value = { "/user" })
public class AddressController {
 
	private static Logger log = Logger.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private CartitemDAO cartitemDAO;
	
	@Autowired
	private OrderiDAO orderiDAO;
	
	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = { "/manageAddress" })
	public ModelAndView showManageAddressPage(Principal principal, @ModelAttribute("address") Address address, BindingResult result) {
		
		log.debug("Starting of show manage address page method");
		
		System.out.println("clicked on manage addresses page");
		ModelAndView mv = new ModelAndView("page");
		UserTable user=userDAO.getUserByEmail(principal.getName());
		
		mv.addObject("title", "Manage Addresses");
		
		
				
				//passing the list of addresses
				mv.addObject("addresses",addressDAO.getByAid(user.getUid()));
				
				UserTable user1=userDAO.getUserByEmail(principal.getName());

				/**************/
			// passing the list of categories
			mv.addObject("categories", categoryDAO.list());
			//passing the list of products
			mv.addObject("products", productDAO.list());
			//session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
			session.setAttribute("username", user1.getFname());
			session.setAttribute("Role",user1.getRole());
			session.setAttribute("userid",user1.getUid());
			session.setAttribute("cartid",user1.getCart());
			session.setAttribute("cartitems",cartitemDAO.getByUserid(user1.getUid()));
			// passing order details to orderdetails page
			session.setAttribute("carto",orderiDAO.getUndelivered(user1.getUid()));
			
			session.setAttribute("orders", orderDAO.getByUser(user1));
				/***************/
				
		
		mv.addObject("isUserClickManageAddress", true);
		
		log.debug("End of show manage address page method");
		
		return mv;
	}
	
	@RequestMapping(value={ "/addNewAddress" }, method= RequestMethod.POST)
	public ModelAndView addNewAddress(Principal principal, @ModelAttribute("address") @Valid Address address, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of add new address method");
		
		ModelAndView mv = new ModelAndView("page");
		UserTable user=userDAO.getUserByEmail(principal.getName());
		
		
		
		
		
		if(result.hasErrors()) {
			
			mv.addObject("isUserClickManageAddress",true);
			return mv;
			
		}
		
		
		try{
			if(address.getAddid()==0) {
			boolean b=addressDAO.add(address);
			if(b)
			{
				mv.addObject("Usermsg","Address added");
			}
			else
			{
				mv.addObject("Usermsg","Address not added");
			}
			}
			else {
				boolean b=addressDAO.update(address);
				if(b)
				{
					mv.addObject("Usermsg","Address Updated");
				}
				else
				{
					mv.addObject("Usermsg","Address not updated");
				}
				
				
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		UserTable user1=userDAO.getUserByEmail(principal.getName());

		//passing the list of addresses
		mv.addObject("addresses",addressDAO.getByAid(user1.getUid()));
		
		//passing this address info
		Address address1=new Address();
		mv.addObject("address",address1);
		
			/**************/
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		//passing the list of products
		mv.addObject("products", productDAO.list());
		//session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
		session.setAttribute("username", user1.getFname());
		session.setAttribute("Role",user1.getRole());
		session.setAttribute("userid",user1.getUid());
		session.setAttribute("cartid",user1.getCart());
		session.setAttribute("cartitems",cartitemDAO.getByUserid(user1.getUid()));
		// passing order details to orderdetails page
		session.setAttribute("carto",orderiDAO.getUndelivered(user1.getUid()));
		
		session.setAttribute("orders", orderDAO.getByUser(user1));
			/***************/
		
		mv.addObject("isUserClickManageAddress", true);
		log.debug("End of add new address method");
		
		return mv;
	}
	
	@RequestMapping("/deleteAddresses/{id}")
	public ModelAndView deleteAddresses(@PathVariable("id") int id, Principal principal, @ModelAttribute("address") @Valid Address address1, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of delete address method");
		
		
		ModelAndView mv = new ModelAndView("page");
		
		UserTable user=userDAO.getUserByEmail(principal.getName());
		
		
		
		Address address=null;
		address=addressDAO.get(id);

		
		boolean b=addressDAO.delete(address);
		
		if(b)
		{
			
			mv.addObject("Usermsg","address deleted");
		}
		else
		{
			mv.addObject("Usermsg","address NOT deleted");
		}

		
		
		UserTable user1=userDAO.getUserByEmail(principal.getName());

		//passing the list of addresses
		mv.addObject("addresses",addressDAO.getByAid(user1.getUid()));
		
			/**************/
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		//passing the list of products
		mv.addObject("products", productDAO.list());
		//session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
		session.setAttribute("username", user1.getFname());
		session.setAttribute("Role",user1.getRole());
		session.setAttribute("userid",user1.getUid());
		session.setAttribute("cartid",user1.getCart());
		session.setAttribute("cartitems",cartitemDAO.getByUserid(user1.getUid()));
		// passing order details to orderdetails page
		session.setAttribute("carto",orderiDAO.getUndelivered(user1.getUid()));
		
		session.setAttribute("orders", orderDAO.getByUser(user1));
			/***************/
		
		mv.addObject("isUserClickManageAddress", true);
		log.debug("End of delete address method");
		
		return mv;
	}

	@RequestMapping("/updateAddress/{id}")
	public ModelAndView updateAddress(@PathVariable("id") int id, Principal principal, @ModelAttribute("address") @Valid Address address1, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of update address method");
		
		ModelAndView mv = new ModelAndView("page");
		
		Address address=null;
		address=addressDAO.get(id);
		
		UserTable user=userDAO.getUserByEmail(principal.getName());
		
		//passing the list of addresses
		mv.addObject("addresses",addressDAO.getByAid(user.getUid()));
		
		//passing this address info
		mv.addObject("address",address);
		
		UserTable user1=userDAO.getUserByEmail(principal.getName());

			/**************/
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		//passing the list of products
		mv.addObject("products", productDAO.list());
		//session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
		session.setAttribute("username", user1.getFname());
		session.setAttribute("Role",user1.getRole());
		session.setAttribute("userid",user1.getUid());
		session.setAttribute("cartid",user1.getCart());
		session.setAttribute("cartitems",cartitemDAO.getByUserid(user1.getUid()));
		// passing order details to orderdetails page
		session.setAttribute("carto",orderiDAO.getUndelivered(user1.getUid()));
		
		session.setAttribute("orders", orderDAO.getByUser(user1));
			/***************/
	
		
		
		
		mv.addObject("isUserClickedUpdateAddress",true);
		
		log.debug("End of update address method");
		return mv;
	}
	
	@RequestMapping(value={ "/addAddressNew/{id}" }, method= RequestMethod.POST)
	public ModelAndView addAddressNew(Principal principal,@PathVariable("id") int id, @ModelAttribute("address") @Valid Address address, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of add new address method");
		
		ModelAndView mv = new ModelAndView("page");
		
		
		/*//passing the list of categories
		mv.addObject("categories",categoryDAO.list());*/
		
		
		
		if(result.hasErrors()) {
			
			mv.addObject("isUserClickManageAddress",true);
			return mv;
			
		}
		
		
		try{
			if(address.getAddid()==0) {
			boolean b=addressDAO.add(address);
			if(b)
			{
				mv.addObject("Usermsg","Address added");
			}
			else
			{
				mv.addObject("Usermsg","Address not added");
			}
			}
			else {
				boolean b=addressDAO.update(address);
				if(b)
				{
					mv.addObject("Usermsg","Address Updated");
				}
				else
				{
					mv.addObject("Usermsg","Address not updated");
				}
				
				
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		UserTable user=null;
		user=userDAO.getUserByEmail(principal.getName());
		
		//passing the list of addresses
		mv.addObject("addresses",addressDAO.getByAid(user.getUid()));
		
		
		UserTable user1=userDAO.getUserByEmail(principal.getName());

			/**************/
		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		//passing the list of products
		mv.addObject("products", productDAO.list());
		//session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
		session.setAttribute("username", user1.getFname());
		session.setAttribute("Role",user1.getRole());
		session.setAttribute("userid",user1.getUid());
		session.setAttribute("cartid",user1.getCart());
		session.setAttribute("cartitems",cartitemDAO.getByUserid(user1.getUid()));
		// passing order details to orderdetails page
		session.setAttribute("carto",orderiDAO.getUndelivered(user1.getUid()));
		
		session.setAttribute("orders", orderDAO.getByUser(user1));
			/***************/
		
		
		
		mv.addObject("isUserClickSelectAddress", true);
		log.debug("End of add new address method");
		
		return mv;
	}
	
	
	
}
