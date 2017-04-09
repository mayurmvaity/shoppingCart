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
import com.niit.shoppingbackend.dto.Supplier;

@Controller
@RequestMapping(value = { "/admin" })
public class SupplierController {
	
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

	
	@RequestMapping("/supplierDeletion/{id}")
	public ModelAndView supplierDeletion(@PathVariable("id") int id,@ModelAttribute("supplier") Supplier supplier1, BindingResult result) {
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
		
			/********************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		// getting table of suppliers
		mv.addObject("suppliers",supplierDAO.list());
			/*********************/
		mv.addObject("isUserClickViewSuppliers", true);
		log.debug("End of supplier deletion method");
		return mv;
	}
	
	@RequestMapping("/supplierUpdate/{id}")
	public ModelAndView supplierUpdate(@PathVariable("id") int id,@ModelAttribute("supplier") Supplier supplier1, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("Starting of supplier update method");
		
		ModelAndView mv = new ModelAndView("page");
		
		
		Supplier supplier=null;
		supplier=supplierDAO.get(id);
		
		
		
		//passing this supplier info
		mv.addObject("supplier",supplier);
		
		
		/********************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		// getting table of suppliers
		mv.addObject("suppliers",supplierDAO.list());
			/*********************/
		
		
		mv.addObject("isUserClickedUpdateSupplier",true);
		
		log.debug("End of supplier update method");
		return mv;
	}
	
	@RequestMapping(value={ "/supplierAddition" }, method = RequestMethod.POST)
	public ModelAndView supplierAddition(@ModelAttribute("supplier") @Valid Supplier supplier, BindingResult result) {
		// actually you have to take the data from db
		// temporarily
		log.debug("Starting of supplier addition method");
		
		ModelAndView mv = new ModelAndView("page");
		
		
		if(result.hasErrors())
		{
			
			/********************/
			//passing the list of categories
			mv.addObject("categories",categoryDAO.list());
			// getting table of suppliers
			mv.addObject("suppliers",supplierDAO.list());
				/*********************/
			
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
		
		/********************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		// getting table of suppliers
		mv.addObject("suppliers",supplierDAO.list());
			/*********************/
		
		mv.addObject("isUserClickViewSuppliers", true);
		
		log.debug("End of supplier addition method");
		return mv;
	}
	
}
