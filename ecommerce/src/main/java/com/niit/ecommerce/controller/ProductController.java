package com.niit.ecommerce.controller;

import javax.servlet.ServletContext;
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
import com.niit.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value={ "/admin" })
public class ProductController {

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
	
	@RequestMapping(value = { "/addProduct" })
	public ModelAndView showAddProductPage(@ModelAttribute("command") Product product,BindingResult result) {
		
		log.debug("Starting of show add product page  method");
		
		System.out.println("clicked on add product page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Product");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				
				//passing the list of products for the table below
				mv.addObject("listProducts", productDAO.list());
		
		mv.addObject("isUserClickAddProduct", true);
		mv.addObject("product",product);
		
		log.debug("End of show add product page  method");
			
		return mv;
	}
	
	
	
	
	@Autowired
	ServletContext req;
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value={ "/productAddition" }, method = RequestMethod.POST)
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
		System.out.println(product);
		
		String p=req.getRealPath("/");
		String path=product.getFilePath(p,req.getContextPath());
		//product.uploadFileHandler(path,product.getImage());
		
		if(product.getPid()==0) {
		boolean b=productDAO.add(product);
		System.out.println(b);
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
		
		Product product1=new Product();
		mv.addObject("product",product1);
				
		
		
		/*******************/
		// passing the list of categories
				mv.addObject("categories", categoryDAO.list());

				//passing the list of products
				mv.addObject("products", productDAO.list());
		/***********************/
		
		mv.addObject("isUserClickAdminsProducts", true);
		
		log.debug("End of product addition  method");
		
		return mv;
	}
	
	@RequestMapping("/productDeletion/{id}")
	public ModelAndView productDeletion(@PathVariable("id") int id, @ModelAttribute("product") Product product1, BindingResult result ) {
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
		
		/*******************/
		// passing the list of categories
				mv.addObject("categories", categoryDAO.list());

				//passing the list of products
				mv.addObject("products", productDAO.list());
		/***********************/
		mv.addObject("isUserClickAdminsProducts", true);
		return mv;
	}
	
	@RequestMapping("/productUpdate/{id}")
	public ModelAndView productUpdate(@PathVariable("id") int id, @ModelAttribute("product") Product product1, BindingResult result ) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of product update  method");
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product=null;
		product=productDAO.get(id);
		
		/*******************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		//passing the list of products for the table below
		mv.addObject("listProducts", productDAO.list());
		/***********************/
		
		//passing this category info
		mv.addObject("product",product);
		
		mv.addObject("isUserClickedUpdateProduct",true);
		
		log.debug("End of product update  method");
		
		return mv;
	}
	
	
	
	
}
