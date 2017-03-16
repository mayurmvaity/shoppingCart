package com.niit.ecommerce.controller;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Product;
import com.niit.shoppingbackend.dto.Supplier;
import com.niit.shoppingbackend.dto.User;

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
		mv.addObject("products", productDAO.getPlist());

		User user=null;
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

	@RequestMapping("/logout")
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
	}

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

	
	@RequestMapping(value = { "/changePW/{id}" })
	public ModelAndView showChangePWPage(@PathVariable("id") int id) {
		
		log.debug("Starting of change pw method");
		
		
		System.out.println("clicked on change PW page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Change Password");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				
				User user=null;
				user=userDAO.get(id);
				
				// passing the current object
				mv.addObject("user",user);
				
				
		mv.addObject("isUserClickChangePW", true);
		
		log.debug("End of change pw method");
		
		return mv;
	}
	
	@PostMapping("/user/validatePassword")
	public ModelAndView validatePassword(@ModelAttribute("user") @Valid User user,BindingResult result, HttpServletRequest request) {
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
		mv.addObject("products", productDAO.getPlist());
		
		
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
				
				User user=null;
				user=userDAO.get(id);
				mv.addObject("user",user);
				
		
		mv.addObject("isUserClickBillingAddress", true);
		log.debug("End of show biling address method");
		
		return mv;
	}

	@PostMapping("/user/updateBillingAddress")
	public ModelAndView updateBillingAddress(@ModelAttribute("user") @Valid User user,BindingResult result) {
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
		
				User user=null;
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
				
				User user=null;
				user=userDAO.get(id);
				mv.addObject("user",user);

		mv.addObject("isUserClickPersonalInfo", true);
		
		log.debug("End of show personal info page method");
		
		return mv;
	}
	
	@PostMapping("/user/updatePersonalInfo")
	public ModelAndView updatePersonalInfo(@ModelAttribute("user") @Valid User user, BindingResult result) {
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
	
	@RequestMapping(value = { "/user/changeMobNo/{id}" })
	public ModelAndView showChangeMobNoPage(@PathVariable("id") int id) {
		
		log.debug("Starting of show change mobile no page method");
		
		System.out.println("clicked on change mobile no page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Change Mobile Number");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
				User user=null;
				user=userDAO.get(id);
				mv.addObject("user",user);

		mv.addObject("isUserClickChangeMobNo", true);
		
		log.debug("End of show change mobile no page method");
		
		return mv;
	}

	@PostMapping("/user/updateMobileNo")
	public ModelAndView updateMobileNo(@ModelAttribute("user") User user) {
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
	
	/*=========================================== Addresses methods here ========================================================*/
	
	@RequestMapping(value = { "/user/manageAddress/{id}" })
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
	
	@PostMapping("/user/addNewAddress/{id}")
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
	
	@RequestMapping("/user/deleteAddresses/{id}")
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

	@RequestMapping("/user/updateAddress/{id}")
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
	
	/*=========================================== End of Addresses methods ========================================================*/
	
	@RequestMapping(value = { "/orderDetails" })
	public ModelAndView showOrderDetailsPage() {
		
		log.debug("Starting of show order details page method");
		
		System.out.println("clicked on order details page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Order Details");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickOrderDetails", true);
		
		log.debug("End of show order details page method");
		return mv;
	}

	@RequestMapping(value = { "/wishList" })
	public ModelAndView showWishListPage() {
		
		log.debug("Starting of show wish list page method");
		System.out.println("clicked on wish list page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Wish List");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickWishList", true);
		log.debug("End of show wish list page method");
		return mv;
	}

	@RequestMapping(value = { "/myCart" })
	public ModelAndView showMyCartPage() {
		
		log.debug("Starting of show my cart page method");
		System.out.println("clicked on my cart page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "My Cart");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickMyCart", true);
		log.debug("End of show my cart page method");
		return mv;
	}

	@RequestMapping(value = { "/selectAddress" })
	public ModelAndView showSelectAddressPage() {
		log.debug("Starting of show select address page method");
		
		
		System.out.println("clicked on select address page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Select Address");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickSelectAddress", true);
		
		log.debug("End of show select address page method");
		
		return mv;
	}

	@RequestMapping(value = { "/confirmPurchase" })
	public ModelAndView showConfirmPurchasePage() {
		
		log.debug("Starting of show confirm purchase page method");
		
		System.out.println("clicked on confirm purchase page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Confirm Purchase");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickConfirmPurchase", true);
		
		log.debug("End of show confirm purchase page method");
		
		return mv;
	}

	@RequestMapping(value = { "/paymentMode" })
	public ModelAndView showPaymentModePage() {
		
		log.debug("Starting of show payment mode page method");
		
		System.out.println("clicked on payment mode page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Payment Mode");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickPaymentMode", true);
		log.debug("End of show payment mode page method");
		
		return mv;
	}

	@RequestMapping(value = { "/orderDetailsButton" })
	public ModelAndView showOrderDetailsButtonPage() {
		log.debug("Starting of show Order details button page method");
		
		System.out.println("clicked on order details button page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Order Details Button");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickOrderDetailsButton", true);
		
		log.debug("End of show Order details button page method");
		
		return mv;
	}

	
	
	
	
	
	
	
	
	
	
	

	@RequestMapping(value = { "/addSupplier" })
	public ModelAndView showAddSupplierPage(@ModelAttribute("supplier") Supplier supplier, BindingResult result) {
		
		log.debug("Starting of show add supplier page method");
		
		System.out.println("clicked on add supplier page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add supplier");
		
		
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				// getting table of suppliers
				mv.addObject("suppliers",supplierDAO.list());
		
		mv.addObject("isUserClickAddSupplier", true);
		mv.addObject("supplier",supplier);
		
		log.debug("End of show add supplier page method");
		
		return mv;
	}

	
	
	
	@RequestMapping(value = { "/admin/show/all/adminsProducts" })
	public ModelAndView showAdminsProductsPage() {
		
		log.debug("Starting of showAdminsProductsPage method");
		
		System.out.println("clicked on admins products page");
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		//passing the list of products
		mv.addObject("products", productDAO.getPlist());
		
		mv.addObject("isUserClickAdminsProducts", true);
		
		log.debug("end of showAdminsProductsPage method");
		return mv;
	}
	
	@RequestMapping(value = { "/show/category/{id}/adminproducts" })
	public ModelAndView showCategoryAdminProducts(@PathVariable("id") int id) {
		
		log.debug("Starting of showCategoryAdminProducts method");

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
		mv.addObject("catProducts",productDAO.getPlistById(xid));
		
		mv.addObject("userClickCategoryAdminProducts", true);
		log.debug("End of showCategoryAdminProducts method");
		
		return mv;
	}
	
	@RequestMapping(value = { "/adminsHome" })
	public ModelAndView showAdminsHomePage() {
		
		log.debug("Starting of show admins homepage method");
		
		System.out.println("clicked on admins home page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Admins Home");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickAdminsHome", true);
		
		log.debug("End of show admins homepage method");
		
		return mv;
	}

	@RequestMapping(value = { "/adminsProDetails" })
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
	}
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
		mv.addObject("products", productDAO.getPlist());
		
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
		mv.addObject("catProducts",productDAO.getPlistById(xid));
		
		mv.addObject("userClickCategoryProducts", true);
		
		log.debug("Starting of show category products method");
		return mv;
	}
	
	@RequestMapping(value = { "/productDetails/{id}" })
	public ModelAndView showProductDetailsPage(@PathVariable("id") int id) {
		
		log.debug("Starting of show product details page method");
		
		System.out.println("clicked on product details page");
		ModelAndView mv = new ModelAndView("page");
		
		
		mv.addObject("title", "Product Details");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("products",productDAO.getPlistByPId(id));
		
		/*Product product=null;
		product=productDAO.get(id);
		
		String c=product.getPcolor();
		
		mv.addObject("colors",productDAO.getPlistByColor(c));*/
		
		
		mv.addObject("isUserClickProductDetails", true);
		
		log.debug("End of show product details page method");
		
		return mv;
	}
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		log.debug("Starting of index  method");
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "Welcome to Spring Web MVC");
		mv.addObject("title", "Home");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		//passing the list of products
		mv.addObject("products", productDAO.getPlist());
	
		//mv.addObject("products", productDAO.getPlist());
		
		mv.addObject("msg", "WELCOME TO SHOPPING CART");
		mv.addObject("userClickHome", true);
		
		log.debug("End of index  method");
		
		return mv;
	}
	
	/* ========================== uploadImage() method product methods here ======================== */
	
	
	
	@RequestMapping(value = { "/addProduct" })
	public ModelAndView showAddProductPage(@ModelAttribute("command") Product product,BindingResult result) {
		
		log.debug("Starting of show add product page  method");
		
		System.out.println("clicked on add product page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Product");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				
				//passing the join of product and category
				mv.addObject("listProducts", productDAO.getPlist());
		
		mv.addObject("isUserClickAddProduct", true);
		mv.addObject("product",product);
		
		log.debug("End of show add product page  method");
		
		return mv;
	}
	
	@Autowired
	ServletContext req;
	@Autowired
	private HttpServletRequest request;
	
	@PostMapping("/admin/productAddition")
	public ModelAndView productAddition(@ModelAttribute("product") @Valid Product product, BindingResult result, HttpServletRequest request) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of product addition  method");
		
		ModelAndView mv = new ModelAndView("page");
		
		if(result.hasErrors())
		{
			mv.addObject("isUserClickAddProduct",true);
			return mv;
			
		}
		
		
		String p=req.getRealPath("/");
		String path=product.getFilePath(p,req.getContextPath());
		//product.uploadFileHandler(path,product.getImage());
		
		if(product.getPid()==0) {
		boolean b=productDAO.add(product);
		
		if(b)
		{
			
			mv.addObject("CRUDmsgP","Product added");
		}
		else
		{
			mv.addObject("CRUDmsgP","Product NOT added");
		}
		}
		else {
			boolean b=productDAO.update(product);
			
			if(b)
			{
				
				mv.addObject("CRUDmsgP","Product updated");
			}
			else
			{
				mv.addObject("CRUDmsgP","Product NOT updated");
			}
			
		}
		
		mv.addObject("title", "Add Product");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
				
		//passing the join of product and category
		mv.addObject("listProducts", productDAO.getPlist());
		
		mv.addObject("isUserClickAddProduct", true);
		
		log.debug("End of product addition  method");
		
		return mv;
	}
	
	@RequestMapping("/admin/productDeletion/{id}")
	public ModelAndView productDeletion(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of product deletion  method");
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product=null;
		product=productDAO.get(id);

		
		boolean b=productDAO.delete(product);
		
		if(b)
		{
			
			mv.addObject("CRUDmsgP","Product deleted");
		}
		else
		{
			mv.addObject("CRUDmsgP","Product NOT deleted");
		}

		log.debug("End of product deletion  method");
		
		return mv;
	}
	
	@RequestMapping("/admin/productUpdate/{id}")
	public ModelAndView productUpdate(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of product update  method");
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product=null;
		product=productDAO.get(id);
		
		//passing list of categories to navbar
		mv.addObject("categories",categoryDAO.list());
		
		//passing this category info
		mv.addObject("product",product);
		
		mv.addObject("isUserClickedUpdateProduct",true);
		
		log.debug("End of product update  method");
		
		return mv;
	}
	
	
	/*====================================== category deletion ===========================================*/
	
	@RequestMapping(value = { "/addCategory" })
	public ModelAndView showAddCategoryPage(@ModelAttribute("command") Category category, BindingResult result) {
		
		log.debug("Starting of show add category page method");
		
		System.out.println("clicked on add category page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add New Brand");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickAddCategory", true);
		
		mv.addObject("category",category);
		
		log.debug("End of show add category page method");
		
		return mv;
	}
	
	
	
	@RequestMapping("/admin/categoryDeletion/{id}")
	public ModelAndView categoryDeletion(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of category deletion method");
		
		ModelAndView mv = new ModelAndView("page");
		
		Category category=null;
		category=categoryDAO.get(id);

		
		boolean b=categoryDAO.delete(category);
		
		if(b)
		{
			
			mv.addObject("CRUDmsgC","Category deleted");
		}
		else
		{
			mv.addObject("CRUDmsgC","Category NOT deleted");
		}
		
		log.debug("End of category deletion method");
		
		return mv;
	}
	
	@RequestMapping("/admin/categoryUpdate/{id}")
	public ModelAndView categoryUpdate(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		
		 log.debug("starting of category update method");
		
		ModelAndView mv = new ModelAndView("page");
		
		Category category=null;
		category=categoryDAO.get(id);
		
		//passing list of categories to navbar
		mv.addObject("categories",categoryDAO.list());
		
		//passing this category info
		mv.addObject("category",category);
		
		mv.addObject("isUserClickedUpdateCategory",true);
		
		 log.debug("End of category update method");
			
		return mv;
	}
	
	@PostMapping("/admin/categoryAddition")
	public ModelAndView categoryAddition(@ModelAttribute("category") @Valid Category category, BindingResult result) throws Exception {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("starting of category addition method");
		
		ModelAndView mv = new ModelAndView("page");
		
		if(result.hasErrors())
		{
			mv.addObject("isUserClickAddCategory",true);
			return mv;
		}
		if(category.getId()==0)
		{
		boolean b=categoryDAO.add(category);
		if(b)
		{
			mv.addObject("CRUDmsgC","Category added");
		}
		else
		{
			mv.addObject("CRUDmsgC","Category NOT added");
		}
		}
		else
		{
			boolean b=categoryDAO.update(category);
			if(b)
			{
				mv.addObject("CRUDmsgC","Category updated");
			}
			else
			{
				mv.addObject("CRUDmsgC","Category NOT updated");
			}
			
			
		}
		
		log.debug("End of category addition method");
		
		return mv;
	}
	
/*====================================== Supplier deletion ===========================================*/
	
	@RequestMapping("/admin/supplierDeletion/{id}")
	public ModelAndView supplierDeletion(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of supplier deletion method");
		
		ModelAndView mv = new ModelAndView("page");
		
		
		
		
		Supplier supplier=null;
		supplier=supplierDAO.get(id);

		
		boolean b=supplierDAO.delete(supplier);
		
		if(b)
		{
			
			mv.addObject("CRUDmsgS","Supplier deleted");
		}
		else
		{
			mv.addObject("CRUDmsgS","Supplier NOT deleted");
		}
		
		log.debug("End of supplier deletion method");
		return mv;
	}
	
	@RequestMapping("/admin/supplierUpdate/{id}")
	public ModelAndView supplierUpdate(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of supplier update method");
		
		ModelAndView mv = new ModelAndView("page");
		// getting table of suppliers
				mv.addObject("suppliers",supplierDAO.list());
		
		Supplier supplier=null;
		supplier=supplierDAO.get(id);
		
		//passing list of categories to navbar
		mv.addObject("categories",categoryDAO.list());
		
		//passing this supplier info
		mv.addObject("supplier",supplier);
		
		mv.addObject("isUserClickedUpdateSupplier",true);
		
		log.debug("End of supplier update method");
		return mv;
	}
	
	@PostMapping("/admin/supplierAddition")
	public ModelAndView supplierAddition(@ModelAttribute("supplier") @Valid Supplier supplier, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		log.debug("Starting of supplier addition method");
		
		ModelAndView mv = new ModelAndView("page");
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		// getting table of suppliers
		mv.addObject("suppliers",supplierDAO.list());
		
		if(result.hasErrors())
		{
			mv.addObject("isUserClickAddSupplier",true);
			return mv;
		}
		
		
		if(supplier.getSid()==0) {
		boolean b=supplierDAO.add(supplier);
		if(b)
		{
			mv.addObject("CRUDmsgS","Supplier added");
		}
		else
		{
			mv.addObject("CRUDmsgS","Supplier NOT added");
		}
		}
		else
		{
			boolean b=supplierDAO.update(supplier);
			if(b)
			{
				mv.addObject("CRUDmsgS","Supplier updated");
			}
			else
			{
				mv.addObject("CRUDmsgS","Supplier NOT updated");
			}
			
			
		}
		
		log.debug("End of supplier addition method");
		return mv;
	}
	/*===================================== Registeration  ======================================*/
	
	@RequestMapping(value = { "/register" })
	public ModelAndView showRegistrationPage(@ModelAttribute("command") User user, BindingResult result) {
		
		log.debug("Starting of show registration page method");
		
		System.out.println("clicked on reg page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Sign Up");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("isUserClickRegPage", true);
		mv.addObject("user",user);
		
		log.debug("End of show registration page method");
		
		return mv;
	}
	
	
	@PostMapping("/registeration")
	public ModelAndView registeration(@ModelAttribute("user") @Valid User user, BindingResult result) {
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
		
		if(user.getUid()==0) {
		boolean b=userDAO.add(user);
		
		if(b)
		{
			
			mv.addObject("RegMsg","Registered Successfully");
		}
		else
		{
			mv.addObject("RegMsg","Couldn't register");
		}
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
	
	
	
	
}
