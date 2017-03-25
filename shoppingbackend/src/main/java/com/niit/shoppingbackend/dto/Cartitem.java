package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cartitem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemid;
	
	@Column
	private int cartid;
	@Column
	private int ino;
	@Column
	private long iprice;
	@Column
	private int iquantity;
	@Column
	private long itotal;
	
	@Column(name="is_active")
	private boolean active = true;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public long getIprice() {
		return iprice;
	}
	public void setIprice(long iprice) {
		this.iprice = iprice;
	}
	public int getIquantity() {
		return iquantity;
	}
	public void setIquantity(int iquantity) {
		this.iquantity = iquantity;
	}
	public long getItotal() {
		return itotal;
	}
	public void setItotal(long itotal) {
		this.itotal = itotal;
	}
	@Override
	public String toString() {
		return "Cartitem [itemid=" + itemid + ", cartid=" + cartid + ", ino=" + ino + ", iprice=" + iprice
				+ ", iquantity=" + iquantity + ", itotal=" + itotal + "]";
	} 
	
	
	

}
