package com.niit.ecommerce.controller;



import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ecommerce.exception.ProductNotFoundException;
import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.CartDAO;
import com.niit.shoppingbackend.dao.CartitemDAO;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.OrderDAO;
import com.niit.shoppingbackend.dao.OrderiDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Product;
import com.niit.shoppingbackend.dto.UserTable;

@Controller
public class PageController {
	 
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
	private CartDAO cartDAO;
	
	@Autowired
	private CartitemDAO cartitemDAO;
	
	@Autowired
	private OrderiDAO orderiDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private HttpSession session;

	/*@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring Web MVC");
		mv.addObject("title", "Home");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("msg", "WELCOME TO SHOPPING CART");
		mv.addObject("userClickHome", true);
		return mv;
	}*/

	

	@RequestMapping(value = { "/login" })
	public ModelAndView showLoginPage() {
		log.debug("Starting of login method");
		System.out.println("clicked on login page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "login");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("isUserClickLoginPage", true);
		log.debug("End of login method");
		
		return mv;
	}

	@PostMapping("/validate")
	public ModelAndView validateCredentials(@RequestParam(value = "userID", required = true) String id,
			@RequestParam(value = "password", required = true) String pwd) {
		// actually you have to take the data from db
		// temporarily
		log.debug("Starting of validate credentials method");
		
		ModelAndView mv = new ModelAndView("page");
		
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
					
		//passing the list of products
		mv.addObject("products", productDAO.list());

		UserTable user=null;
		user=userDAO.valid(id, pwd);
		
		if (user == null) {
			
			mv.addObject("errorMessage", "Invalid credentials please try again");
			mv.addObject("title", "Log In");

		} else if (user.getRole().equals("CUSTOMER")) {
			
			mv.addObject("successMessageU", "Valid credentials");
			session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
			session.setAttribute("username", user.getFname());
			session.setAttribute("Role",user.getRole());
			session.setAttribute("userid",user.getUid());
			
			mv.addObject("title", "Home");
			mv.addObject("user",user);
			
		} else {
			
			mv.addObject("successMessageA", "Valid credentials");
			session.setAttribute("adminMessage", "Welcome :" + user.getFname()+" "+user.getLname());
			session.setAttribute("adminName", user.getFname());
			session.setAttribute("Role",user.getRole());
			mv.addObject("title", "Admin Console");
		
		}
		
		
		/*if (id.equals("niit") && pwd.equals("niit@123")) {
			mv.addObject("successMessageU", "Valid credentials");
			session.setAttribute("loginMessage", "Welcome :" + id);
			session.setAttribute("username", id);
			mv.addObject("title", "Home");
			
			

		} else if (id.equals("admin") && pwd.equals("admin")) {
			mv.addObject("successMessageA", "Valid credentials");
			session.setAttribute("adminMessage", "Welcome :" + id);
			session.setAttribute("adminName", id);
			mv.addObject("title", "Admin Console");
			
		} else {
			mv.addObject("errorMessage", "Invalid credentials please try again");
			mv.addObject("title", "Log In");
		}
*/
		
		log.debug("End of validate credentials method");
		
		return mv;
	}

	/*@RequestMapping("/logout")
	public ModelAndView logout() {
		
		log.debug("Starting of logout method");
		
		System.out.println("Clicked on logout link");
		ModelAndView mv = new ModelAndView("page");
		session.invalidate(); // session.removeAttribute("loginMessage");
		mv.addObject("title", "Home");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing the list of products
		mv.addObject("products", productDAO.getPlist());
		
		mv.addObject("isUserClickedLogout", true);

		log.debug("End of logout method");
		
		
		return mv;
	}*/
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		ModelAndView mv=new ModelAndView("page");
		//session.invalidate(); // session.removeAttribute("loginMessage");
		mv.addObject("title", "Home");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing the list of products
				mv.addObject("products", productDAO.list());
		
		
		
		mv.addObject("isUserClickedLogout", true);
		return mv;
	}
	
	  /*@RequestMapping(value="/logout", method = RequestMethod.GET)
	  public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      if (auth != null){    
	          new SecurityContextLogoutHandler().logout(request, response, auth);
	      }
	      return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	  }*/


	@RequestMapping("/403")
	public ModelAndView error() {
		log.debug("start of 403 method");
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("errorMessage","403 error");
		mv.addObject("isUserClickLoginPage",true);
		log.debug("End of 403 method");

		return mv;
		
	}
	
	/*@RequestMapping("/loginerror")
	public String LoginError(@RequestParam(value = "error", required = false) String error, Model model) {
		log.debug("start of login error method");
		model.addAttribute("errorMessage", "Incorrect Username or Password.");
		log.debug("End of login error method");
		return "login";
}*/
	/*
	 * @RequestMapping(value = { "/productList" }) public ModelAndView
	 * showProductListPage() {
	 * System.out.println("clicked on product list page"); ModelAndView mv = new
	 * ModelAndView("page"); mv.addObject("title","Product list");
	 * mv.addObject("isUserClickProductList",true); return mv; }
	 */
	/*
	 * @RequestMapping(value = { "/sidebarC" }) public ModelAndView
	 * showSidebarCPage() { System.out.println("clicked on sidebar C page");
	 * ModelAndView mv = new ModelAndView("page");
	 * 
	 * mv.addObject("isUserClickProductList",true); return mv; }
	 */

	@RequestMapping(value = { "/contactUs" })
	public ModelAndView showContactUsPage() {
		
		log.debug("Starting of contact us method");
		
		System.out.println("clicked on contact us page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickContactUs", true);
		log.debug("End of contactus method");
		
		return mv;
	}

	@RequestMapping(value = { "/aboutUs" })
	public ModelAndView showAboutUsPage() {
		log.debug("Starting of about us method");
		
		System.out.println("clicked on about us page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickAboutUs", true);
		log.debug("End of about us method");
		
		
		return mv;
	}
	
	
	

	/*====================================== change PW stuff =====================================*/

	
	
	
	/*=========================================== Addresses methods here ========================================================*/
	
	
	/*=========================================== End of Addresses methods ========================================================*/
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	/*
	 * Methods to load all the products and based on category
	 */

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {
		
		log.debug("Starting of show all products method");

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		//passing the list of products
		mv.addObject("products", productDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		
		log.debug("End of show all products method");
		
		return mv;
	}

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		
		log.debug("Starting of show category products method");

		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category

		Category category = null;
		category = categoryDAO.get(id);

		mv.addObject("title", category.getName());
		int xid=category.getId();
		
		// passing the list of categories for navbar
		mv.addObject("categories", categoryDAO.list());

		// passing a single category object
		mv.addObject("category", category);

		//passing the list of products
		mv.addObject("catProducts",productDAO.getPlistById(id));
		
		mv.addObject("userClickCategoryProducts", true);
		
		log.debug("Starting of show category products method");
		return mv;
	}
	
	@RequestMapping(value = { "/productDetails/{id}" })
	public ModelAndView showProductDetailsPage(@PathVariable("id") int id) throws ProductNotFoundException {
		
		log.debug("Starting of show product details page method");
		
		System.out.println("clicked on product details page");
		ModelAndView mv = new ModelAndView("page");
		
		Product product=null;
		product=productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		mv.addObject("title", product.getCategory().getName() +" "+product.getPname()+" "+product.getPcolor());
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("product",productDAO.get(id));
		
		mv.addObject("isUserClickProductDetails", true);
		
		log.debug("End of show product details page method");
		
		return mv;
	}
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index(Principal principal) {

		log.debug("Starting of index  method");
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring Web MVC");
		mv.addObject("title", "Home");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		//passing the list of products
				mv.addObject("products", productDAO.list());
	
		if(principal!= null)
		{
			UserTable user=null;
			user=userDAO.getUserByEmail(principal.getName());
			if(user.getRole().equals("ROLE_USER"))
			{
			session.setAttribute("loginMessage", "Welcome :" + user.getFname()+" "+user.getLname());
			session.setAttribute("username", user.getFname());
			session.setAttribute("Role",user.getRole());
			session.setAttribute("userid",user.getUid());
			session.setAttribute("cartid",user.getCart());
			session.setAttribute("cartitems",cartitemDAO.getByUserid(user.getUid()));
			// passing order details to orderdetails page
						//mv.addObject("carto",cartitemDAO.getOrderedItems(userid, oid));
						session.setAttribute("carto",orderiDAO.getUndelivered(user.getUid()));
						
						session.setAttribute("orders", orderDAO.getByUser(user));
			mv.addObject("title", "Home");
			mv.addObject("user",user);
			mv.addObject("userClickHome", true);
			}
			else
			{
				mv.addObject("successMessageA", "Valid credentials");
				session.setAttribute("adminMessage", "Welcome :" + user.getFname()+" "+user.getLname());
				session.setAttribute("adminName", user.getFname());
				session.setAttribute("Role",user.getRole());
				mv.addObject("title", "Admin Console");
				mv.addObject("isUserClickAdminsProducts", true);
			}
		}
		else
		{
			mv.addObject("userClickHome", true);
		}
		
		mv.addObject("msg", "WELCOME TO SHOPPING CART");
		
		
		
		
		
		log.debug("End of index  method");
		
		return mv;
	}
	
	/* ========================== uploadImage() method product methods here ======================== */
	
	
	
	
	/*====================================== category deletion ===========================================*/
	
	
	
/*====================================== Supplier deletion ===========================================*/
	
	
	/*===================================== Registeration  ======================================*/
	
	@RequestMapping(value = { "/register" })
	public ModelAndView showRegistrationPage(@ModelAttribute("command") UserTable user, BindingResult result) {
		
		log.debug("Starting of show registration page method");
		
		System.out.println("clicked on reg page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Sign Up");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		
		
		mv.addObject("isUserClickRegPage", true);
		//mv.addObject("cart",cart);
		mv.addObject("user",user);
		
		log.debug("End of show registration page method");
		
		return mv;
	}
	
	
	@PostMapping("/registeration")
	public ModelAndView registeration(@ModelAttribute("user") @Valid UserTable user, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of registration method");
		
		ModelAndView mv = new ModelAndView("page");
		
		// passing the list of categories
				mv.addObject("categories", categoryDAO.list());

				System.out.println(user.toString());
		
		if(result.hasErrors()){
			mv.addObject("isUserClickRegPage", true);
			return mv;
		}
		
		
		if(!(userDAO.userExists(user.getEmail())))
		{
		if(user.getUid()==0) {
		boolean b=userDAO.add(user);
		
		if(b)
		{
			Cart cart = new Cart();
			boolean x=cartDAO.add(cart);
			user.setCart(cart);
			boolean y=userDAO.update(user);
			mv.addObject("RegMsg","Registered Successfully");
			mv.addObject("isUserClickLoginPage", true);
		}
		else
		{
			mv.addObject("RegMsg","Couldn't register");
			mv.addObject("isUserClickRegPage", true);
		}
		}
		}
		else
		{
			mv.addObject("Emailerror","Same User email cannot be registered");
			mv.addObject("isUserClickRegPage", true);
		}
		
		/*mv.addObject("title", "Home");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
				
		//passing the join of product and category
		mv.addObject("listProducts", productDAO.getPlist());
		
		mv.addObject("userClickHome", true);*/
		
		log.debug("End of registration method");
		
		return mv;
	}
	
	/*============= Starting of Admins new pages ============*/
	
	
	/*@RequestMapping(value = { "/adminsProDetails" })
	public ModelAndView showAdminsProDetailsPage() {
		
		log.debug("Starting of show admins prodetails method");
		
		System.out.println("clicked on admins product details page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Admins Product Details");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickAdminsProDetails", true);
		
		log.debug("End of show admins pro details method");
		
		return mv;
	}*/
	
	
	
	
}
