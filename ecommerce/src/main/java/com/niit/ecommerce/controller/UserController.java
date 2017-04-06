package com.niit.ecommerce.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	private CartitemDAO cartitemDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private OrderiDAO orderiDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = { "/changePW" })
	public ModelAndView showChangePWPage(Principal principal) {
		
		log.debug("Starting of change pw method");
		
		
		System.out.println("clicked on change PW page");
		ModelAndView mv = new ModelAndView("page");
		
		UserTable user=userDAO.getUserByEmail(principal.getName());
		mv.addObject("title", "Change Password");
		
		
				
				
				//user=userDAO.get(id);
				
				// passing the current object
				mv.addObject("user",user);
				
				/**************/
				// passing the list of categories
				mv.addObject("categories", categoryDAO.list());
				//passing the list of products
				mv.addObject("products", productDAO.list());
				//session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
				session.setAttribute("username", user.getFname());
				session.setAttribute("Role",user.getRole());
				session.setAttribute("userid",user.getUid());
				session.setAttribute("cartid",user.getCart());
				session.setAttribute("cartitems",cartitemDAO.getByUserid(user.getUid()));
				// passing order details to orderdetails page
				session.setAttribute("carto",orderiDAO.getUndelivered(user.getUid()));
				
				session.setAttribute("orders", orderDAO.getByUser(user));
					/***************/
				
		mv.addObject("isUserClickChangePW", true);
		
		log.debug("End of change pw method");
		
		return mv;
	}
	
	@RequestMapping(value={ "/validatePassword" }, method = RequestMethod.POST)
	public ModelAndView validatePassword(Principal principal, @ModelAttribute("user") @Valid UserTable user,BindingResult result, HttpServletRequest request) {
		// actually you have to take the data from db
		// temporarily
		log.debug("Starting of validate pw method");
		
		ModelAndView mv = new ModelAndView("page");
		UserTable user1=userDAO.getUserByEmail(principal.getName());
		
		if(result.hasErrors()) {
			
			mv.addObject("isUserClickChangePW",true);
			return mv;
		}
		
	
		
		
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
			
			mv.addObject("isUserClickMyAccount", true);
		
		return mv;
	}

	
	/*====================================== END OF change PW stuff =====================================*/
	
	
	
	@RequestMapping(value = { "/billingAddress" })
	public ModelAndView showBillingAddressPage(Principal principal) {
		log.debug("Starting of show biling address method");
		
		
		System.out.println("clicked on billing address page");
		ModelAndView mv = new ModelAndView("page");
		UserTable user=userDAO.getUserByEmail(principal.getName());
		mv.addObject("title", "Billing Address");
		
		
				
				/*UserTable user=null;
				user=userDAO.get(id);*/
				mv.addObject("user",user);
		
				/**************/
				// passing the list of categories
				mv.addObject("categories", categoryDAO.list());
				//passing the list of products
				mv.addObject("products", productDAO.list());
				//session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
				session.setAttribute("username", user.getFname());
				session.setAttribute("Role",user.getRole());
				session.setAttribute("userid",user.getUid());
				session.setAttribute("cartid",user.getCart());
				session.setAttribute("cartitems",cartitemDAO.getByUserid(user.getUid()));
				// passing order details to orderdetails page
				session.setAttribute("carto",orderiDAO.getUndelivered(user.getUid()));
				
				session.setAttribute("orders", orderDAO.getByUser(user));
					/***************/
		
		mv.addObject("isUserClickBillingAddress", true);
		log.debug("End of show biling address method");
		
		return mv;
	}

	@RequestMapping(value= { "/updateBillingAddress" }, method= RequestMethod.POST)
	public ModelAndView updateBillingAddress(Principal principal, @ModelAttribute("user") @Valid UserTable user,BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		log.debug("Starting of update billing address method");
		
		ModelAndView mv = new ModelAndView("page");
		UserTable user1=userDAO.getUserByEmail(principal.getName());
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
		
		mv.addObject("isUserClickMyAccount", true);
		log.debug("End of update billing address method");
		
		return mv;
	}
	

	@RequestMapping(value = { "/myAccount" })
	public ModelAndView showMyAccountPage(Principal principal) {
		
		log.debug("Starting of show my account page method");
		
		System.out.println("clicked on my account page");
		ModelAndView mv = new ModelAndView("page");
		
		UserTable user = userDAO.getUserByEmail(principal.getName());
		
		mv.addObject("title", "My Account");
		
		
				/*UserTable user=null;
				user=userDAO.get(id);*/
				
				mv.addObject("user",user);
				
					/**************/
				// passing the list of categories
				mv.addObject("categories", categoryDAO.list());
				//passing the list of products
				mv.addObject("products", productDAO.list());
				//session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
				session.setAttribute("username", user.getFname());
				session.setAttribute("Role",user.getRole());
				session.setAttribute("userid",user.getUid());
				session.setAttribute("cartid",user.getCart());
				session.setAttribute("cartitems",cartitemDAO.getByUserid(user.getUid()));
				// passing order details to orderdetails page
				session.setAttribute("carto",orderiDAO.getUndelivered(user.getUid()));
				
				session.setAttribute("orders", orderDAO.getByUser(user));
					/***************/
				
		mv.addObject("isUserClickMyAccount", true);
		
		log.debug("end of show my account page method");
		
		return mv;
	}
	
	@RequestMapping(value = { "/personalInfo" })
	public ModelAndView showPersonalInfoPage(Principal principal) {
		
		log.debug("Starting of show personal info page method");
		
		System.out.println("clicked on personal info page");
		ModelAndView mv = new ModelAndView("page");
		UserTable user=userDAO.getUserByEmail(principal.getName());
		
		mv.addObject("title", "Personal Information");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
				
		
				mv.addObject("user",user);
				
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
				
				
				
		mv.addObject("isUserClickPersonalInfo", true);
		
		log.debug("End of show personal info page method");
		
		return mv;
	}
	
	@RequestMapping(value={ "/updatePersonalInfo" }, method = RequestMethod.POST)
	public ModelAndView updatePersonalInfo(Principal principal, @ModelAttribute("user") @Valid UserTable user, BindingResult result) {
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
		
		mv.addObject("isUserClickMyAccount", true);
		
		log.debug("End of update personal info page method");
		
		return mv;
	}
	
	@RequestMapping(value = { "/changeMobNo" })
	public ModelAndView showChangeMobNoPage(Principal principal) {
		
		log.debug("Starting of show change mobile no page method");
		
		System.out.println("clicked on change mobile no page");
		ModelAndView mv = new ModelAndView("page");
		UserTable user=userDAO.getUserByEmail(principal.getName());
		mv.addObject("title", "Change Mobile Number");
		
				
				mv.addObject("user",user);
				
					/**************/
				// passing the list of categories
				mv.addObject("categories", categoryDAO.list());
				//passing the list of products
				mv.addObject("products", productDAO.list());
				//session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
				session.setAttribute("username", user.getFname());
				session.setAttribute("Role",user.getRole());
				session.setAttribute("userid",user.getUid());
				session.setAttribute("cartid",user.getCart());
				session.setAttribute("cartitems",cartitemDAO.getByUserid(user.getUid()));
				// passing order details to orderdetails page
				session.setAttribute("carto",orderiDAO.getUndelivered(user.getUid()));
				
				session.setAttribute("orders", orderDAO.getByUser(user));
					/***************/
				

		mv.addObject("isUserClickChangeMobNo", true);
		
		log.debug("End of show change mobile no page method");
		
		return mv;
	}

	@RequestMapping(value={ "/updateMobileNo" }, method=RequestMethod.POST)
	public ModelAndView updateMobileNo(Principal principal, @ModelAttribute("user") UserTable user) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of update mobile no page method");
		
		ModelAndView mv = new ModelAndView("page");
		UserTable user1=userDAO.getUserByEmail(principal.getName());
		
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
		
		mv.addObject("isUserClickMyAccount", true);
		
		log.debug("End of update mobile no page method");
		
		return mv;
	}
	
	
	
}
