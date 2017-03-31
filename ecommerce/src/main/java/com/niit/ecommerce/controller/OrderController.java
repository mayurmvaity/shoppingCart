package com.niit.ecommerce.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.CartDAO;
import com.niit.shoppingbackend.dao.CartitemDAO;
import com.niit.shoppingbackend.dao.CategoryDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.Cartitem;
import com.niit.shoppingbackend.dto.Product;
import com.niit.shoppingbackend.dto.UserTable;

@Controller
@RequestMapping(value = { "/user" })
public class OrderController {

	private static Logger log = Logger.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private CartitemDAO cartitemDAO;
	
	
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

	@RequestMapping(value = { "/selectAddress/{id}" })
	public ModelAndView showSelectAddressPage(@PathVariable("id") int id, @ModelAttribute("address") Address address ,BindingResult result) {
		log.debug("Starting of show select address page method");
		
		
		System.out.println("clicked on select address page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Select Address");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				
				
				//passing the list of addresses
				mv.addObject("addresses",addressDAO.getByAid(id));
		
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
	
	@RequestMapping(value= {"/addToCart/{userid}/{id}"})
	public ModelAndView addToCart(@PathVariable("id") int id, @PathVariable("userid") int userid, HttpServletRequest request) {
		log.debug("beginning of add to cart method");
		
		ModelAndView mv = new ModelAndView("page");
		
		 
		 Product product= productDAO.get(id);
		UserTable user=userDAO.get(userid);
		
		if(!(cartitemDAO.productExists(userid, id)))
		{
		// cartitem added
		Cartitem cartitem = new Cartitem();
		cartitem.setUserid(user.getUid());
		
		
		cartitem.setProduct(product);
		cartitem.setIprice(product.getPrice());
		
		int quantity=1;
		cartitem.setIquantity(quantity);
		long total=product.getPrice()*quantity;
		cartitem.setItotal(total);
		
		
		
		boolean b=cartitemDAO.add(cartitem);
		if(b) { 
			
			mv.addObject("CartMsg","cartitem added");
			
			//cart actions
			Cart cart=user.getCart();
			int i=cart.getItems();
			cart.setItems(++i);
			long cost=cart.getTotalcost();
			cost=cost+cartitem.getItotal();
			cart.setTotalcost(cost);
			
			boolean c=cartDAO.update(cart);
			if(c) mv.addObject("CartUpdated","Cart updated");
			else mv.addObject("CartUpdated","cart did Not update");
			
			
			}
		else mv.addObject("CartMsg","cartitem not added");
		
		}
		else
		{
			// for same product
			Cartitem cartitem = cartitemDAO.getByPid(userid, id);
			int q=cartitem.getIquantity();
			cartitem.setIquantity(++q);
			long tc=cartitem.getItotal();
			tc+=cartitem.getIprice();
			cartitem.setItotal(tc);
			
			boolean b=cartitemDAO.update(cartitem);
			if(b) {
				mv.addObject("CartMsg","cartitem added");
				
				Cart cart=user.getCart();
				int i=cart.getItems();
				cart.setItems(++i);
				long tcost=cart.getTotalcost();
				tcost=tcost+cartitem.getIprice();
				cart.setTotalcost(tcost);
				
				boolean c=cartDAO.update(cart);
				if(c) mv.addObject("CartUpdated","Cart updated for same product");
				else mv.addObject("CartUpdated","cart did Not update for same product");
				
			} 
			else mv.addObject("CartMsg","cartitem same product found not added");
			
			
		}
			
		
		mv.addObject("userClickHome", true);
		
		log.debug("end of add to cart method");
		return mv;
	}
	
	@RequestMapping(value="/removeCartitem/{id}")
	public ModelAndView removeCartitem(@PathVariable("id") int id)
	{
		log.debug("Beginning of remove cart");
		ModelAndView mv = new ModelAndView("page");
		
		Cartitem cartitem = null;
		cartitem=cartitemDAO.get(id);
		
		int userid=cartitem.getUserid();
		UserTable user=userDAO.get(userid);
		Cart cart=user.getCart();
		
		long cost=cartitem.getItotal();
		int q=cartitem.getIquantity();
		
		
		boolean b=cartitemDAO.delete(cartitem);
		
		if(b) {
			
			
			int items=cart.getItems();
			items=items-q;
			
			cart.setItems(items);
			long cartCost=cart.getTotalcost();
			cartCost=cartCost-cost;
			cart.setTotalcost(cartCost);
			
			boolean c=cartDAO.update(cart);
			if(c) mv.addObject("CartUpdated","Cart updated");
			else mv.addObject("CartUpdated","Cart did not update");
			
			mv.addObject("CartMsg","Cart item deleted");
		}
		else
		{
			mv.addObject("CartMsg","Cart item not deleted");
		}
		
		mv.addObject("isUserClickMyCart",true);
		
		log.debug("End of remove cart");
		return mv;
		
		
	}
	
	
}
