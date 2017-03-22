package com.niit.ecommerce.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Address;

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
	private HttpSession session;
	
	@RequestMapping(value = { "/manageAddress/{id}" })
	public ModelAndView showManageAddressPage(@PathVariable("id") int id, @ModelAttribute("address") Address address, BindingResult result) {
		
		log.debug("Starting of show manage address page method");
		
		System.out.println("clicked on manage addresses page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Addresses");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				
				//passing the list of addresses
				mv.addObject("Addresses",addressDAO.getByAid(id));
		
		mv.addObject("isUserClickManageAddress", true);
		
		log.debug("End of show manage address page method");
		
		return mv;
	}
	
	@RequestMapping(value={ "/addNewAddress/{id}" }, method= RequestMethod.POST)
	public ModelAndView addNewAddress(@PathVariable("id") int id, @ModelAttribute("address") @Valid Address address, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of add new address method");
		
		ModelAndView mv = new ModelAndView("page");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing the list of addresses
		mv.addObject("Addresses",addressDAO.getByAid(id));
		
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
		
		log.debug("End of add new address method");
		
		return mv;
	}
	
	@RequestMapping("/deleteAddresses/{id}")
	public ModelAndView deleteAddresses(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of delete address method");
		
		
		ModelAndView mv = new ModelAndView("page");
		
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

		log.debug("End of delete address method");
		
		return mv;
	}

	@RequestMapping("/updateAddress/{id}")
	public ModelAndView updateAddress(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of update address method");
		
		ModelAndView mv = new ModelAndView("page");
		
		Address address=null;
		address=addressDAO.get(id);
		
		//passing list of categories to navbar
		mv.addObject("categories",categoryDAO.list());
		
		//passing this category info
		mv.addObject("address",address);
		
		mv.addObject("isUserClickedUpdateAddress",true);
		
		log.debug("End of update address method");
		return mv;
	}
	
	
}
