package com.niit.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.niit.shoppingbackend.dao.AddressDAO;
import com.niit.shoppingbackend.dao.CartDAO;
import com.niit.shoppingbackend.dao.CartitemDAO;
import com.niit.shoppingbackend.dao.OrderDAO;
import com.niit.shoppingbackend.dao.OrderiDAO;
import com.niit.shoppingbackend.dao.ProductDAO;
import com.niit.shoppingbackend.dao.UserDAO;
import com.niit.shoppingbackend.dto.Address;
import com.niit.shoppingbackend.dto.Cart;
import com.niit.shoppingbackend.dto.Cartitem;
import com.niit.shoppingbackend.dto.OrderData;
import com.niit.shoppingbackend.dto.Orderi;
import com.niit.shoppingbackend.dto.Ordertable;
import com.niit.shoppingbackend.dto.Product;
import com.niit.shoppingbackend.dto.UserTable;

@Component
public class FlowController {

	
	@Autowired
	private UserTable user;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private Cartitem cartitem;
	
	@Autowired
	private CartitemDAO cartitemDAO;
	
	@Autowired
	private Ordertable order;
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private Orderi orderi;
	
	@Autowired
	private OrderiDAO orderiDAO;
	
	@Autowired
	private OrderData orderData;
	
	@Autowired
	private Address address;
	
	@Autowired
	private AddressDAO addressDAO;
	
	public OrderData initFlow()
	{
		user = userDAO.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		orderData.setCart(user.getCart());
		orderData.setCartitems(cartitemDAO.getByUserid(user.getUid()));
		orderData.setAddresses(addressDAO.getByAid(user.getUid()));
		orderData.setUser(user);
		return orderData;
	}
	
	public String selectShippingAddress(OrderData orderData) {
		
		int addressid=orderData.getAddressid();
		address=addressDAO.get(addressid);
		
		orderData.setShippingAddress(address);
		
		return "success";
	}
	
	/*public String selectShippingAddress(OrderData orderData,int addressid) {
		
		//orderData.getAddressid();
		address=addressDAO.get(addressid);
		
		orderData.setShippingAddress(address);
		
		return "success";
	}*/
	
	public String choosePaymentMode(OrderData orderData) {
		
		user=userDAO.getUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
		cart=user.getCart();
		
		// order set here
		order=new Ordertable();
		order.setAddress(orderData.getShippingAddress());
		order.setAmount(cart.getTotalcost());
		order.setOrdered(true);
		order.setUser(user);
		order.setPayment(orderData.getPaymentMode());
		boolean b=orderDAO.add(order);			// order added to the table
		if(b) System.out.println("order added");
		else System.out.println("Order not added");
		
		// getting cart items list
		List<Cartitem> cartilist = cartitemDAO.getByUserid(user.getUid());
		
		// adding those cart items to order list
		for(Cartitem ci: cartilist)
		{
			orderi = new Orderi();
			orderi.setProduct(ci.getProduct());
			orderi.setOrder(order);
			orderi.setQuantity(ci.getIquantity());
			orderi.setOrdered(true);
			orderi.setUid(user.getUid());
			orderi.setItotal(ci.getItotal());
			orderi.setAddress(orderData.getShippingAddress());
			boolean c = orderiDAO.add(orderi);
			if(c) System.out.println("orderitem added");
			else System.out.println("orderitem not added");
			
			// cartitems deleted here
			boolean d = cartitemDAO.delete(ci);
			if(d) System.out.println("Cartitem deleted");
			else System.out.println("cartitem not deleted");
			
			// manipulating stock amount
			product = productDAO.get(ci.getProduct().getPid());
			int stock=product.getStock();
			stock=stock-ci.getIquantity();
			product.setStock(stock);
			boolean f=productDAO.update(product);
			if(f) System.out.println("Product stock updated");
			else System.out.println("Product stock not updated");
			
		}
		
		// cart reset here
		cart.setItems(0);
		cart.setTotalcost(0);
		boolean e = cartDAO.update(cart);
		if(e) System.out.println("cart reset");
		else System.out.println("cart not reset");
		
		return "success";
		
	}	
}
