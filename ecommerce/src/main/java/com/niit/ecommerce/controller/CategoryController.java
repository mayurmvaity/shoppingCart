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
import com.niit.shoppingbackend.dto.Category;

@Controller
@RequestMapping(value={ "/admin" })
public class CategoryController {

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
	
	@RequestMapping(value = { "/addCategory" })
	public ModelAndView showAddCategoryPage(@ModelAttribute("command") Category category, BindingResult result) {
		
		log.debug("Starting of show add category page method");
		
		System.out.println("clicked on add category page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add New Brand");
		
		/*************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		/***************/
		
		mv.addObject("isUserClickAddCategory", true);
		
		mv.addObject("category",category);
		
		log.debug("End of show add category page method");
		
		return mv;
	}
	
	
	
	@RequestMapping("/categoryDeletion/{id}")
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
		
		/*************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		/***************/
		
		mv.addObject("isUserClickViewCategories", true);
		log.debug("End of category deletion method");
		
		return mv;
	}
	
	@RequestMapping("/categoryUpdate/{id}")
	public ModelAndView categoryUpdate(@PathVariable("id") int id) {
		// actually you have to take the data from db
		// temporarily
		
		 log.debug("starting of category update method");
		
		ModelAndView mv = new ModelAndView("page");
		
		Category category=null;
		category=categoryDAO.get(id);
		
		/*************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		/***************/
		
		//passing this category info
		mv.addObject("category",category);
		
		mv.addObject("isUserClickedUpdateCategory",true);
		
		 log.debug("End of category update method");
			
		return mv;
	}
	
	@RequestMapping(value={ "/categoryAddition" }, method = RequestMethod.POST)
	public ModelAndView categoryAddition(@ModelAttribute("category") @Valid Category category, BindingResult result) throws Exception {
		// actually you have to take the data from db
		// temporarily
		
		log.debug("starting of category addition method");
		
		ModelAndView mv = new ModelAndView("page");
		
		if(result.hasErrors())
		{
			
			/*************/
			//passing the list of categories
			mv.addObject("categories",categoryDAO.list());
			/***************/
			
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
		
		/*************/
		//passing the list of categories
		mv.addObject("categories",categoryDAO.list());
		/***************/
		
		mv.addObject("isUserClickViewCategories", true);
		log.debug("End of category addition method");
		
		return mv;
	}
	
	
}
