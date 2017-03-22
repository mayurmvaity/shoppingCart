package com.niit.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dao.UserDAO;

@Controller
@RequestMapping(value = { "/user" })
public class OrderController {

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

	
}
