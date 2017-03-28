package com.niit.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
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
import com.niit.shoppingbackend.dto.UserTable;

@Controller
@RequestMapping(value = { "/user" })
public class UserController {

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
	
	@RequestMapping(value = { "/changePW/{id}" })
	public ModelAndView showChangePWPage(@PathVariable("id") int id) {
		
		log.debug("Starting of change pw method");
		
		
		System.out.println("clicked on change PW page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Change Password");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				
				UserTable user=null;
				user=userDAO.get(id);
				
				// passing the current object
				mv.addObject("user",user);
				
				
		mv.addObject("isUserClickChangePW", true);
		
		log.debug("End of change pw method");
		
		return mv;
	}
	
	@RequestMapping(value={ "/validatePassword" }, method = RequestMethod.POST)
	public ModelAndView validatePassword(@ModelAttribute("user") @Valid UserTable user,BindingResult result, HttpServletRequest request) {
		// actually you have to take the data from db
		// temporarily
		log.debug("Starting of validate pw method");
		
		ModelAndView mv = new ModelAndView("page");
		
		if(result.hasErrors()) {
			
			mv.addObject("isUserClickChangePW",true);
			return mv;
		}
		
		
		
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
					
		//passing the list of products
		mv.addObject("products", productDAO.list());
		
		
		boolean c = user.pwvalidate();	
		
			
			
			if(c)
			{
				boolean b=userDAO.update(user);
			if(b) {	
				mv.addObject("Usermsg","PW updated");
			
			}
			else
			{
				mv.addObject("Usermsg","PW NOT updated");
			}
			
			}
		
			log.debug("End of validate pw method");
			
		
		return mv;
	}

	
	/*====================================== END OF change PW stuff =====================================*/
	
	
	
	@RequestMapping(value = { "/billingAddress/{id}" })
	public ModelAndView showBillingAddressPage(@PathVariable("id") int id) {
		log.debug("Starting of show biling address method");
		
		
		System.out.println("clicked on billing address page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Billing Address");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				
				UserTable user=null;
				user=userDAO.get(id);
				mv.addObject("user",user);
				
		
		mv.addObject("isUserClickBillingAddress", true);
		log.debug("End of show biling address method");
		
		return mv;
	}

	@RequestMapping(value= { "/updateBillingAddress" }, method= RequestMethod.POST)
	public ModelAndView updateBillingAddress(@ModelAttribute("user") @Valid UserTable user,BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		log.debug("Starting of update billing address method");
		
		ModelAndView mv = new ModelAndView("page");
		
		if(result.hasErrors()) {
			
			mv.addObject("isUserClickBillingAddress",true);
			return mv;
			
		}
		
		try{
			boolean b=userDAO.update(user);
			if(b)
			{
				mv.addObject("Usermsg","user updated");
			}
			else
			{
				mv.addObject("Usermsg","user NOT updated");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		log.debug("End of update billing address method");
		
		return mv;
	}
	

	@RequestMapping(value = { "/myAccount/{id}" })
	public ModelAndView showMyAccountPage(@PathVariable("id") int id) {
		
		log.debug("Starting of show my account page method");
		
		System.out.println("clicked on my account page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "My Account");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
				UserTable user=null;
				user=userDAO.get(id);
				
				mv.addObject("user",user);
				
				
		mv.addObject("isUserClickMyAccount", true);
		
		log.debug("end of show my account page method");
		
		return mv;
	}
	
	@RequestMapping(value = { "/personalInfo/{id}" })
	public ModelAndView showPersonalInfoPage(@PathVariable("id") int id) {
		
		log.debug("Starting of show personal info page method");
		
		System.out.println("clicked on personal info page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Personal Information");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
				
		UserTable user=null;
				user=userDAO.get(id);
				mv.addObject("user",user);

		mv.addObject("isUserClickPersonalInfo", true);
		
		log.debug("End of show personal info page method");
		
		return mv;
	}
	
	@RequestMapping(value={ "/updatePersonalInfo" }, method = RequestMethod.POST)
	public ModelAndView updatePersonalInfo(@ModelAttribute("user") @Valid UserTable user, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		log.debug("Starting of update personal info page method");
		
		ModelAndView mv = new ModelAndView("page");
		
		if(result.hasErrors()) {
			
			mv.addObject("isUserClickPersonalInfo", true);
			return mv;
			
		}
		
		try{
			boolean b=userDAO.update(user);
			if(b)
			{
				mv.addObject("Usermsg","user updated");
			}
			else
			{
				mv.addObject("Usermsg","user NOT updated");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		log.debug("End of update personal info page method");
		
		return mv;
	}
	
	@RequestMapping(value = { "/changeMobNo/{id}" })
	public ModelAndView showChangeMobNoPage(@PathVariable("id") int id) {
		
		log.debug("Starting of show change mobile no page method");
		
		System.out.println("clicked on change mobile no page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Change Mobile Number");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
				UserTable user=null;
				user=userDAO.get(id);
				mv.addObject("user",user);

		mv.addObject("isUserClickChangeMobNo", true);
		
		log.debug("End of show change mobile no page method");
		
		return mv;
	}

	@RequestMapping(value={ "/updateMobileNo" }, method=RequestMethod.POST)
	public ModelAndView updateMobileNo(@ModelAttribute("user") UserTable user) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of update mobile no page method");
		
		ModelAndView mv = new ModelAndView("page");
		
		try{
			boolean b=userDAO.update(user);
			if(b)
			{
				mv.addObject("Usermsg","Mobile no updated");
			}
			else
			{
				mv.addObject("Usermsg","Mobile no NOT updated");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		log.debug("End of update mobile no page method");
		
		return mv;
	}
	
	
	
}
