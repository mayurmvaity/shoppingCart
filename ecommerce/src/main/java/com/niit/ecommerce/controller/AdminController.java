package com.niit.ecommerce.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.OrderDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Category;
import com.niit.shoppingbackend.dto.Ordertable;
import com.niit.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminController {

	private static Logger log = Logger.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = { "/show/all/adminsProducts" })
	public ModelAndView showAdminsProductsPage() {
		
		log.debug("Starting of showAdminsProductsPage method");
		
		System.out.println("clicked on admins products page");
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", categoryDAO.list());

		//passing the list of products
		mv.addObject("products", productDAO.list());
		
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

	@RequestMapping(value = { "/viewCategories" })
	public ModelAndView viewCategories() {
		
		log.debug("Starting of viewCategories method");
		
		System.out.println("clicked on view all categories page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "View All Categories");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		mv.addObject("isUserClickViewCategories", true);
		
		
		
		log.debug("End of viewCategories method");
		
		return mv;
	}
	
	@RequestMapping(value = { "/viewSuppliers" })
	public ModelAndView viewSuppliers() {
		
		log.debug("Starting of viewSuppliers method");
		
		System.out.println("clicked on view all suppliers page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "View All Suppliers");
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		// getting table of suppliers
		mv.addObject("suppliers",supplierDAO.list());
		
		mv.addObject("isUserClickViewSuppliers", true);
		
		
		
		log.debug("End of viewSuppliers method");
		
		return mv;
	}
	
	@RequestMapping(value = { "/adminsProDetails/{id}" })
	public ModelAndView adminsProDetails(@PathVariable("id") int id) {
		
		log.debug("Starting of adminsProDetails page method");
		
		System.out.println("clicked on adminsProDetails page");
		ModelAndView mv = new ModelAndView("page");
		
		
		Product product=null;
		product=productDAO.get(id);
		
		
		mv.addObject("title", product.getCategory().getName() +" "+product.getPname()+" "+product.getPcolor());
		
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		//passing details of product by id
		mv.addObject("product",product);
		
		
		
		
		mv.addObject("isUserClickAdminsProDetails", true);
		
		log.debug("End of adminsProDetails page method");
		
		return mv;
	}
	
	@RequestMapping(value="/deliveryUpdate")
	public ModelAndView deliveryUpdate()
	{
		log.debug("Starting of deliveryUpdate page");
		ModelAndView mv = new ModelAndView("page");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				
				// passing the list of orders
				mv.addObject("allorders", orderDAO.getByOrdered());
				
				mv.addObject("adminClickedDeliveryUpdate",true);
		
				mv.addObject("title","Delivery status");
				
		log.debug("End of deliveryUpdate page");
		return mv;
	}
	
	@RequestMapping(value="/makeDispatch/{orderid}")
	public ModelAndView makeDispatch(@PathVariable("orderid") int orderid)
	{
		log.debug("Starting of make dispatch method");
		ModelAndView mv = new ModelAndView("page");
		Ordertable order=orderDAO.get(orderid);
		
		order.setDispatched(true);
		boolean b=orderDAO.update(order);
		if(b) System.out.println("Order dispatched made true");
		else System.out.println("Order not dispatched");
		
		/******************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		// passing the list of orders
		mv.addObject("allorders", orderDAO.getByOrdered());
		/*********************/
		
		mv.addObject("title","Delivery status");
		
		mv.addObject("adminClickedDeliveryUpdate",true);
		log.debug("Starting of make dispatch method");
		return mv;
	}
	
	@RequestMapping(value="/cancelDispatch/{orderid}")
	public ModelAndView cancelDispatch(@PathVariable("orderid") int orderid)
	{
		log.debug("Starting of make dispatch method");
		ModelAndView mv = new ModelAndView("page");
		Ordertable order=orderDAO.get(orderid);
		
		order.setDispatched(false);
		boolean b=orderDAO.update(order);
		if(b) System.out.println("Order dispatched cancelled true");
		else System.out.println("Order dispatched not cancelled");
		
		/******************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		// passing the list of orders
		mv.addObject("allorders", orderDAO.getByOrdered());
		/*********************/
		
		mv.addObject("title","Delivery status");
		
		mv.addObject("adminClickedDeliveryUpdate",true);
		log.debug("Starting of make dispatch method");
		return mv;
	}
	
	@RequestMapping(value="/makeDelivered/{orderid}")
	public ModelAndView makeDelivered(@PathVariable("orderid") int orderid)
	{
		log.debug("Starting of make delivered method");
		ModelAndView mv = new ModelAndView("page");
		Ordertable order=orderDAO.get(orderid);
		
		order.setDelivered(true);
		boolean b=orderDAO.update(order);
		if(b) System.out.println("Order delivered made true");
		else System.out.println("Order not delivered");
		
		/******************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		// passing the list of orders
		mv.addObject("allorders", orderDAO.getByOrdered());
		/*********************/
		
		mv.addObject("title","Delivery status");
		
		mv.addObject("adminClickedDeliveryUpdate",true);
		log.debug("End of make delivered method");
		return mv;
	}
	
	@RequestMapping(value="/cancelDelivered/{orderid}")
	public ModelAndView cancelDelivered(@PathVariable("orderid") int orderid)
	{
		log.debug("Starting of cancel delivered method");
		ModelAndView mv = new ModelAndView("page");
		Ordertable order=orderDAO.get(orderid);
		
		order.setDelivered(false);
		boolean b=orderDAO.update(order);
		if(b) System.out.println("Order delivered cancelled true");
		else System.out.println("Order delivered not cancelled");
		
		/******************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		
		// passing the list of orders
		mv.addObject("allorders", orderDAO.getByOrdered());
		/*********************/
		
		mv.addObject("title","Delivery status");
		
		mv.addObject("adminClickedDeliveryUpdate",true);
		log.debug("End of cancel delivered method");
		return mv;
	}
}
