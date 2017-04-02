package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cartitem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemid;
	
	@Column
	private int userid;
	
	 
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@OneToOne
	@JoinColumn(name="pid")
	private Product product;
	
	@Column
	private long iprice;
	@Column
	private int iquantity;
	@Column
	private long itotal;
	
	@Column
	private int oid=0;

	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}

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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Cartitem [itemid=" + itemid + ", userid=" + userid + ", product=" + product + ", iprice=" + iprice
				+ ", iquantity=" + iquantity + ", itotal=" + itotal + ", oid=" + oid + ", active=" + active + "]";
	}
	
	
	
	
	
	
	
	
	
	

}
