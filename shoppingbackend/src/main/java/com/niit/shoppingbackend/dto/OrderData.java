package com.niit.shoppingbackend.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2693632508062594375L;

	/**
	 * Private fields
	 * */
	private Cart cart;
	
	private List<Cartitem> cartitems;
	
	private Ordertable order;
	
	private List<Orderi> orderitems;
	
	private UserTable user;
	
	public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}

	private List<Address> addresses;
	
	private Address shippingAddress;
	
	private String paymentMode;
	
	private int addressid;

	/*
	 * methods
	 * */
	
	public int getAddressid() {
		return addressid;
	}

	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Cartitem> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<Cartitem> cartitems) {
		this.cartitems = cartitems;
	}

	public Ordertable getOrder() {
		return order;
	}

	public void setOrder(Ordertable order) {
		this.order = order;
	}

	public List<Orderi> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<Orderi> orderitems) {
		this.orderitems = orderitems;
	}

	

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	@Override
	public String toString() {
		return "OrderData [cart=" + cart + ", cartitems=" + cartitems + ", order=" + order + ", orderitems="
				+ orderitems + ", user=" + user + ", addresses=" + addresses + ", shippingAddress=" + shippingAddress
				+ ", paymentMode=" + paymentMode + ", addressid=" + addressid + "]";
	}

	

	
	/*
	 * toString() method
	 * */
	
	
	
	
	
}
