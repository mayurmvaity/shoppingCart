package com.niit.ecommerce.controller;



import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Product;
import com.niit.shoppingbackend.dto.Supplier;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
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

	@RequestMapping(value = { "/register" })
	public ModelAndView showRegistrationPage() {
		System.out.println("clicked on reg page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Sign Up");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("isUserClickRegPage", true);
		return mv;
	}

	@RequestMapping(value = { "/login" })
	public ModelAndView showLoginPage() {
		System.out.println("clicked on login page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "login");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		mv.addObject("isUserClickLoginPage", true);
		return mv;
	}

	@PostMapping("/validate")
	public ModelAndView validateCredentials(@RequestParam(value = "userID", required = true) String id,
			@RequestParam(value = "password", required = true) String pwd) {
		// actually you have to take the data from db
		// temporarily
		ModelAndView mv = new ModelAndView("page");
		
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
					
		//passing the list of products
		mv.addObject("products", productDAO.getPlist());

		if (id.equals("niit") && pwd.equals("niit@123")) {
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

		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		System.out.println("Clicked on logout link");
		ModelAndView mv = new ModelAndView("page");
		session.invalidate(); // session.removeAttribute("loginMessage");
		mv.addObject("title", "Home");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing the list of products
		mv.addObject("products", productDAO.getPlist());
		
		mv.addObject("isUserClickedLogout", true);

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
		System.out.println("clicked on contact us page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickContactUs", true);
		return mv;
	}

	@RequestMapping(value = { "/aboutUs" })
	public ModelAndView showAboutUsPage() {
		System.out.println("clicked on about us page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickAboutUs", true);
		return mv;
	}
	
	
	

	@RequestMapping(value = { "/personalInfo" })
	public ModelAndView showPersonalInfoPage() {
		System.out.println("clicked on personal info page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Personal Information");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickPersonalInfo", true);
		return mv;
	}

	@RequestMapping(value = { "/changeMobNo" })
	public ModelAndView showChangeMobNoPage() {
		System.out.println("clicked on change mobile no page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Change Mobile Number");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickChangeMobNo", true);
		return mv;
	}

	@RequestMapping(value = { "/changePW" })
	public ModelAndView showChangePWPage() {
		System.out.println("clicked on change PW page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Change Password");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickChangePW", true);
		return mv;
	}

	@RequestMapping(value = { "/manageAddress" })
	public ModelAndView showManageAddressPage() {
		System.out.println("clicked on manage addresses page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Addresses");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickManageAddress", true);
		return mv;
	}

	@RequestMapping(value = { "/myAccount" })
	public ModelAndView showMyAccountPage() {
		System.out.println("clicked on my account page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "My Account");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickMyAccount", true);
		return mv;
	}

	@RequestMapping(value = { "/orderDetails" })
	public ModelAndView showOrderDetailsPage() {
		System.out.println("clicked on order details page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Order Details");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickOrderDetails", true);
		return mv;
	}

	@RequestMapping(value = { "/wishList" })
	public ModelAndView showWishListPage() {
		System.out.println("clicked on wish list page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Wish List");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickWishList", true);
		return mv;
	}

	@RequestMapping(value = { "/myCart" })
	public ModelAndView showMyCartPage() {
		System.out.println("clicked on my cart page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "My Cart");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickMyCart", true);
		return mv;
	}

	@RequestMapping(value = { "/selectAddress" })
	public ModelAndView showSelectAddressPage() {
		System.out.println("clicked on select address page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Select Address");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickSelectAddress", true);
		return mv;
	}

	@RequestMapping(value = { "/confirmPurchase" })
	public ModelAndView showConfirmPurchasePage() {
		System.out.println("clicked on confirm purchase page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Confirm Purchase");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickConfirmPurchase", true);
		return mv;
	}

	@RequestMapping(value = { "/paymentMode" })
	public ModelAndView showPaymentModePage() {
		System.out.println("clicked on payment mode page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Payment Mode");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickPaymentMode", true);
		return mv;
	}

	@RequestMapping(value = { "/orderDetailsButton" })
	public ModelAndView showOrderDetailsButtonPage() {
		System.out.println("clicked on order details button page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Order Details Button");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickOrderDetailsButton", true);
		return mv;
	}

	@RequestMapping(value = { "/addProduct" })
	public ModelAndView showAddProductPage(@ModelAttribute("command") Product product,BindingResult result) {
		System.out.println("clicked on add product page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Product");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				
				//passing the join of product and category
				mv.addObject("listProducts", productDAO.getPlist());
		
		mv.addObject("isUserClickAddProduct", true);
		mv.addObject("product",product);
		return mv;
	}
	
	
	
	
	
	@RequestMapping(value = { "/addCategory" })
	public ModelAndView showAddCategoryPage(@ModelAttribute("command") Category category, BindingResult result) {
		System.out.println("clicked on add category page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add New Brand");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickAddCategory", true);
		mv.addObject("category",category);
		return mv;
	}
	
	
	
	

	@RequestMapping(value = { "/addSupplier" })
	public ModelAndView showAddSupplierPage(@ModelAttribute("supplier") Supplier supplier, BindingResult result) {
		System.out.println("clicked on add supplier page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add supplier");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickAddSupplier", true);
		mv.addObject("supplier",supplier);
		
		// getting table of suppliers
		mv.addObject("suppliers",supplierDAO.list());
		
		return mv;
	}

	
	
	
	@RequestMapping(value = { "/adminsProducts" })
	public ModelAndView showAdminsProductsPage() {
		System.out.println("clicked on admins products page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Admins Products");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickAdminsProducts", true);
		return mv;
	}

	@RequestMapping(value = { "/adminsHome" })
	public ModelAndView showAdminsHomePage() {
		System.out.println("clicked on admins home page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Admins Home");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickAdminsHome", true);
		return mv;
	}

	@RequestMapping(value = { "/adminsProDetails" })
	public ModelAndView showAdminsProDetailsPage() {
		System.out.println("clicked on admins product details page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Admins Product Details");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickAdminsProDetails", true);
		return mv;
	}
	/*
	 * Methods to load all the products and based on category
	 */

	@RequestMapping(value = { "/show/all/products" })
	public ModelAndView showAllProducts() {

		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		//passing the list of products
		mv.addObject("products", productDAO.getPlist());
		
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = { "/show/category/{id}/products" })
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

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
		return mv;
	}
	
	@RequestMapping(value = { "/productDetails/{id}" })
	public ModelAndView showProductDetailsPage(@PathVariable("id") int id) {
		System.out.println("clicked on product details page");
		ModelAndView mv = new ModelAndView("page");
		
		
		mv.addObject("title", "Product Details");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("products",productDAO.getPlistByPId(id));
		
		mv.addObject("isUserClickProductDetails", true);
		return mv;
	}
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

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
		return mv;
	}
	
	/* ========================== uploadImage() method product methods here ======================== */
	
	@Autowired
	ServletContext req;
	@Autowired
	private HttpServletRequest request;
	
	@PostMapping("/admin/productAddition")
	public ModelAndView productAddition(@ModelAttribute("product") Product product,  HttpServletRequest request) {
		// actually you have to take the data from db
		// temporarily
		ModelAndView mv = new ModelAndView("page");
		
		
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

		return mv;
	}
	
	@RequestMapping("/admin/productDeletion/{id}")
	public ModelAndView productDeletion(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
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

		return mv;
	}
	
	@RequestMapping("/admin/productUpdate/{id}")
	public ModelAndView productUpdate(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		ModelAndView mv = new ModelAndView("page");
		
		Product product=null;
		product=productDAO.get(id);
		
		//passing list of categories to navbar
		mv.addObject("categories",categoryDAO.list());
		
		//passing this category info
		mv.addObject("product",product);
		
		mv.addObject("isUserClickedUpdateProduct",true);
		
		
		return mv;
	}
	
	
	/*====================================== category deletion ===========================================*/
	
	@RequestMapping("/admin/categoryDeletion/{id}")
	public ModelAndView categoryDeletion(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
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
		
		
		return mv;
	}
	
	@RequestMapping("/admin/categoryUpdate/{id}")
	public ModelAndView categoryUpdate(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		ModelAndView mv = new ModelAndView("page");
		
		Category category=null;
		category=categoryDAO.get(id);
		
		//passing list of categories to navbar
		mv.addObject("categories",categoryDAO.list());
		
		//passing this category info
		mv.addObject("category",category);
		
		mv.addObject("isUserClickedUpdateCategory",true);
		
		
		return mv;
	}
	
	@PostMapping("/admin/categoryAddition")
	public ModelAndView categoryAddition(@ModelAttribute("category") Category category) {
		// actually you have to take the data from db
		// temporarily
		ModelAndView mv = new ModelAndView("page");
		
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
		return mv;
	}
	
/*====================================== Supplier deletion ===========================================*/
	
	@RequestMapping("/admin/supplierDeletion/{id}")
	public ModelAndView supplierDeletion(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
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
		
		
		return mv;
	}
	
	@RequestMapping("/admin/supplierUpdate/{id}")
	public ModelAndView supplierUpdate(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		ModelAndView mv = new ModelAndView("page");
		
		Supplier supplier=null;
		supplier=supplierDAO.get(id);
		
		//passing list of categories to navbar
		mv.addObject("categories",categoryDAO.list());
		
		//passing this supplier info
		mv.addObject("supplier",supplier);
		
		mv.addObject("isUserClickedUpdateSupplier",true);
		
		
		return mv;
	}
	
	@PostMapping("/admin/supplierAddition")
	public ModelAndView supplierAddition(@ModelAttribute("supplier") Supplier supplier) {
		// actually you have to take the data from db
		// temporarily
		ModelAndView mv = new ModelAndView("page");
		
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
		return mv;
	}
	
}
