package com.niit.ecommerce.controller;

import java.security.Principal;
import java.util.List;

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
import com.niit.shoppingbackend.dao.OrderDAO;
import com.niit.shoppingbackend.dao.OrderiDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.SupplierDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.Cartitem;
import com.niit.shoppingbackend.dto.Orderi;
import com.niit.shoppingbackend.dto.Ordertable;
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
	private OrderiDAO orderiDAO;
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private OrderDAO orderDAO;

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

	@RequestMapping(value = { "/confirmPurchase/{id}/{aid}" })
	public ModelAndView showConfirmPurchasePage(@PathVariable("id") int id,@PathVariable("aid") int aid) {
		
		log.debug("Starting of show confirm purchase page method");
		
		
		System.out.println("clicked on confirm purchase page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Confirm Purchase");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
				
				
				UserTable user=userDAO.get(id);
				
				// passing a user
				mv.addObject("user",user);
				
				// passing cartitems list
				mv.addObject("cartitems",cartitemDAO.getByUserid(user.getUid()));
				
				// passing shipping address
				mv.addObject("shipadd",addressDAO.get(aid));
				
				// passing cart of user
				mv.addObject("cartx",user.getCart());
				
				Ordertable ordertable = new Ordertable();		// order created
				boolean d = orderDAO.add(ordertable);
				System.out.println(d+" "+ordertable.toString());
				
				Cart cart=user.getCart();
				ordertable.setAmount(cart.getTotalcost());					// total cost set in order table
				ordertable.setAddress(addressDAO.get(aid)); 			// address id set in order table
				ordertable.setUser(user);  								// user set in order table
				ordertable.setOrdered(false); 							// ordered set to false
				System.out.println(ordertable.toString());
				boolean c=orderDAO.update(ordertable);					// order added to table
				if(c) mv.addObject("OrderMsgx","ordertable tuple added");
				else mv.addObject("OrderMsgx","ordertable tuple not added");
				
				// setting orderid in cartitem table
				int oid=ordertable.getOrderid();
				// passing orderid to page
				mv.addObject("oid",oid);
				
				System.out.println(oid);
				try {
				List<Cartitem> clist = cartitemDAO.getByUserid(id);
				
					if(clist != null){
						for(Cartitem citem : clist)
						{
							citem.setOid(oid);
							boolean b=cartitemDAO.update(citem);
							
							System.out.println(citem.getOid()+" "+b);
						}
						
						mv.addObject("OrderMsg","Cartitems updated");
					}
					else
					{
						mv.addObject("OrderMsg","Cartitems NOT updated");
					}
				}
				catch(Exception e)
				{
					mv.addObject("OrderMsg","Cartitems NOT updated");
				}
				
		mv.addObject("isUserClickConfirmPurchase", true);
		
		log.debug("End of show confirm purchase page method");
		
		return mv;
	}

	@RequestMapping(value = { "/paymentMode/{orderid}" })
	public ModelAndView showPaymentModePage(@PathVariable("orderid") int orderid) {
		
		log.debug("Starting of show payment mode page method");
		
		System.out.println("clicked on payment mode page");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Payment Mode");
		
		//passing the list of categories
				mv.addObject("categories",categoryDAO.list());
		
				// passing the ordertable
				mv.addObject("orderitem",orderDAO.get(orderid));
		mv.addObject("isUserClickPaymentMode", true);
		log.debug("End of show payment mode page method");
		
		return mv;
	}

	@RequestMapping(value= { "/addPaymentMode/{userid}/{oid}" })
	public ModelAndView addPaymentMode(@ModelAttribute("orderitem") Ordertable order, @PathVariable("userid") int userid, @PathVariable("oid") int oid, BindingResult result) {
		
		log.debug("beginning of add payment mode");
		ModelAndView mv = new ModelAndView("page");
		
		order.setOrdered(true);
		
		List<Cartitem> clist = cartitemDAO.getByUserid(userid);
		for(Cartitem cl: clist)
		{
			boolean b=cartitemDAO.placeOrder(cl);
			if(b) {
				mv.addObject("OrderMsgx","Cart item set to ordered"); System.out.println("cartitem set to ordered");
				}
			else { 
				mv.addObject("OrderMsgx","Cart item not set to ordered");
				System.out.println("cartitem not set to ordered");
			}
			
			Orderi orderi=new Orderi();
			orderi.setUid(cl.getUserid());
			orderi.setQuantity(cl.getIquantity());
			orderi.setItotal(cl.getItotal());
			orderi.setOrdered(true);
			orderi.setDelivered(false);
			//orderi.setPid(cl.getProduct().getPid());
			orderi.setProduct(cl.getProduct());
			orderi.setOrderid(oid);
			
			boolean x=orderiDAO.add(orderi);
			if(x) System.out.println("Order item added to orderi table");
			else System.out.println("Order item not added to orderi table");
			
		}
		
		Cart cart=cartDAO.get(userDAO.get(userid).getCart().getCartid());
		cart.setItems(0);
		cart.setTotalcost(0);
		
		boolean x = cartDAO.update(cart);
		if(x) System.out.println("cart cleared");
		else System.out.println("cart not cleared");
		
		boolean b=orderDAO.update(order);
		System.out.println("order pay type="+order.getPayment());
		
		if(b) mv.addObject("OrderMsg","Payment Mode added || order has been placed");
		else mv.addObject("OrderMsg","Payment mode NOT added");
		
		// passing order details to orderdetails page
		//mv.addObject("carto",cartitemDAO.getOrderedItems(userid, oid));
		mv.addObject("carto",orderiDAO.getUndelivered(userid));
		
		
		mv.addObject("isUserClickOrderDetails",true);
		log.debug("beginning of add payment mode");
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
	
	@RequestMapping(value= {"/addToCart/{id}"})
	public ModelAndView addToCart(Principal principal, @PathVariable("id") int id, HttpServletRequest request) {
		log.debug("beginning of add to cart method");
		
		ModelAndView mv = new ModelAndView("page");
		UserTable user=null;
		try{
		
		user=userDAO.getUserByEmail(principal.getName());
		}
		catch(Exception e)
		{
			System.out.println(e+"THUIS IS EXCEPTION");
		}
		 Product product= productDAO.get(id);
		//UserTable user=userDAO.get(userid);
		
		if(!(cartitemDAO.productExists(user.getUid(), id)))
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
			Cartitem cartitem = cartitemDAO.getByPid(user.getUid(), id);
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
