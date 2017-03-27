package com.niit.shoppingbackend.dto;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartid;
	

	@Column
	private int items;
	@Column
	private long totalcost;
	
	/*@Column
	private int userid;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}*/

	@Column(name="is_active")
	private boolean active = true;
	
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getItems() {
		return items;
	}
	public void setItems(int items) {
		this.items = items;
	}
	public long getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(long totalcost) {
		this.totalcost = totalcost;
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", items=" + items + ", totalcost=" + totalcost + ", active=" + active + "]";
	}
	
	
	
	
	
	
	
	
}
