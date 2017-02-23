package com.niit.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting","Welcome to Spring Web MVC");
		mv.addObject("title","Home");
		mv.addObject("msg","WELCOME TO SHOPPING CART");
		mv.addObject("userClickHome",true);
		return mv;
	}
	@RequestMapping(value = { "/register" })
	public ModelAndView showRegistrationPage() {
		System.out.println("clicked on reg page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Sign Up");
		mv.addObject("isUserClickRegPage",true);
		return mv;
	}
	@RequestMapping(value = { "/login" })
	public ModelAndView showLoginPage() {
		System.out.println("clicked on login page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","login");
		mv.addObject("isUserClickLoginPage",true);
		return mv;
	}
	@PostMapping("/validate")
	public ModelAndView validateCredentials(@RequestParam(value="userID",required=true) String id,
			@RequestParam(value="password",required=true) String pwd)
	{
		//actually you have to take the data from db
		//temporarily
		ModelAndView mv=new ModelAndView("page");
		
		if(id.equals("niit") && pwd.equals("niit@123"))
		{
			mv.addObject("successMessageU","Valid credentials");
			session.setAttribute("loginMessage","Welcome :"+id);
			session.setAttribute("username", id);
			mv.addObject("title","Home");
			
		}
		else if(id.equals("admin") && pwd.equals("admin"))
		{
			mv.addObject("successMessageA","Valid credentials");
			session.setAttribute("adminMessage","Welcome :"+id);
			session.setAttribute("adminName", id);
			mv.addObject("title","Admin Console");
		}
		else
		{
			mv.addObject("errorMessage","Invalid credentials please try again");
			mv.addObject("title","Log In");
		}
		
		return mv;
	}
	@RequestMapping("/logout")
	public ModelAndView logout()
	{
		System.out.println("Clicked on logout link");
		ModelAndView mv =new ModelAndView("page");
		session.invalidate();		//session.removeAttribute("loginMessage");
		mv.addObject("title","Home");
		mv.addObject("isUserClickedLogout",true);
		
		return mv;
	}
	
	@RequestMapping(value = { "/productList" })
	public ModelAndView showProductListPage() {
		System.out.println("clicked on product list page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Product list");
		mv.addObject("isUserClickProductList",true);
		return mv;
	}
	@RequestMapping(value = { "/contactUs" })
	public ModelAndView showContactUsPage() {
		System.out.println("clicked on contact us page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("isUserClickContactUs",true);
		return mv;
	}
	
	@RequestMapping(value = { "/aboutUs" })
	public ModelAndView showAboutUsPage() {
		System.out.println("clicked on about us page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("isUserClickAboutUs",true);
		return mv;
	}
	
	@RequestMapping(value = { "/productDetails" })
	public ModelAndView showProductDetailsPage() {
		System.out.println("clicked on product details page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Product Details");
		mv.addObject("isUserClickProductDetails",true);
		return mv;
	}
	@RequestMapping(value = { "/personalInfo" })
	public ModelAndView showPersonalInfoPage() {
		System.out.println("clicked on personal info page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Personal Information");
		mv.addObject("isUserClickPersonalInfo",true);
		return mv;
	}
	@RequestMapping(value = { "/changeMobNo" })
	public ModelAndView showChangeMobNoPage() {
		System.out.println("clicked on change mobile no page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Change Mobile Number");
		mv.addObject("isUserClickChangeMobNo",true);
		return mv;
	}
	@RequestMapping(value = { "/changePW" })
	public ModelAndView showChangePWPage() {
		System.out.println("clicked on change PW page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Change Password");
		mv.addObject("isUserClickChangePW",true);
		return mv;
	}
	@RequestMapping(value = { "/manageAddress" })
	public ModelAndView showManageAddressPage() {
		System.out.println("clicked on manage addresses page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Manage Addresses");
		mv.addObject("isUserClickManageAddress",true);
		return mv;
	}
	@RequestMapping(value = { "/myAccount" })
	public ModelAndView showMyAccountPage() {
		System.out.println("clicked on my account page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","My Account");
		mv.addObject("isUserClickMyAccount",true);
		return mv;
	}
	@RequestMapping(value = { "/orderDetails" })
	public ModelAndView showOrderDetailsPage() {
		System.out.println("clicked on order details page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Order Details");
		mv.addObject("isUserClickOrderDetails",true);
		return mv;
	}
	@RequestMapping(value = { "/wishList" })
	public ModelAndView showWishListPage() {
		System.out.println("clicked on wish list page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Wish List");
		mv.addObject("isUserClickWishList",true);
		return mv;
	}
	@RequestMapping(value = { "/myCart" })
	public ModelAndView showMyCartPage() {
		System.out.println("clicked on my cart page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","My Cart");
		mv.addObject("isUserClickMyCart",true);
		return mv;
	}
	@RequestMapping(value = { "/selectAddress" })
	public ModelAndView showSelectAddressPage() {
		System.out.println("clicked on select address page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Select Address");
		mv.addObject("isUserClickSelectAddress",true);
		return mv;
	}
	@RequestMapping(value = { "/confirmPurchase" })
	public ModelAndView showConfirmPurchasePage() {
		System.out.println("clicked on confirm purchase page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Confirm Purchase");
		mv.addObject("isUserClickConfirmPurchase",true);
		return mv;
	}
	@RequestMapping(value = { "/paymentMode" })
	public ModelAndView showPaymentModePage() {
		System.out.println("clicked on payment mode page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Payment Mode");
		mv.addObject("isUserClickPaymentMode",true);
		return mv;
	}
	@RequestMapping(value = { "/orderDetailsButton" })
	public ModelAndView showOrderDetailsButtonPage() {
		System.out.println("clicked on order details button page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Order Details Button");
		mv.addObject("isUserClickOrderDetailsButton",true);
		return mv;
	}
	@RequestMapping(value = { "/addProduct" })
	public ModelAndView showAddProductPage() {
		System.out.println("clicked on add product page");
		ModelAndView mv = new ModelAndView("page");
				mv.addObject("title","Add Product");
		mv.addObject("isUserClickAddProduct",true);
		return mv;
	}
	@RequestMapping(value = { "/addCategory" })
	public ModelAndView showAddCategoryPage() {
		System.out.println("clicked on add category page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Add New Brand");
		mv.addObject("isUserClickAddCategory",true);
		return mv;
	}
	@RequestMapping(value = { "/adminsProducts" })
	public ModelAndView showAdminsProductsPage() {
		System.out.println("clicked on admins products page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Admins Products");
		mv.addObject("isUserClickAdminsProducts",true);
		return mv;
	}
	@RequestMapping(value = { "/adminsHome" })
	public ModelAndView showAdminsHomePage() {
		System.out.println("clicked on admins home page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Admins Home");
		mv.addObject("isUserClickAdminsHome",true);
		return mv;
	}
	@RequestMapping(value = { "/adminsProDetails" })
	public ModelAndView showAdminsProDetailsPage() {
		System.out.println("clicked on admins product details page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Admins Product Details");
		mv.addObject("isUserClickAdminsProDetails",true);
		return mv;
	}
}
