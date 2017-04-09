package com.niit.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Component
@Entity
public class Orderi implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1010966304885824794L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oitemid;
	
	@OneToOne
	@JoinColumn(name="orderid")
	private Ordertable order;
	
	@Column
	private int uid;
	
	/*@Column
	private int pid;*/
	
	@OneToOne
	@JoinColumn(name="pid")
	private Product product;
	
	@Column 
	private int quantity;
	
	@Column
	private long itotal;
	
	@OneToOne
	@JoinColumn(name="addid")
	private Address address;
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name="is_ordered")
	private boolean ordered = false;
	
	

	public int getOitemid() {
		return oitemid;
	}

	public void setOitemid(int oitemid) {
		this.oitemid = oitemid;
	}

	

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getItotal() {
		return itotal;
	}

	public void setItotal(long itotal) {
		this.itotal = itotal;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name="is_delivered")
	private boolean delivered = false;
	
	@Column(name="is_active")
	private boolean active = true;

	@Override
	public String toString() {
		return "Orderi [oitemid=" + oitemid + ", order=" + order + ", uid=" + uid + ", product=" + product
				+ ", quantity=" + quantity + ", itotal=" + itotal + ", address=" + address + ", ordered=" + ordered
				+ ", delivered=" + delivered + ", active=" + active + "]";
	}

	public Ordertable getOrder() {
		return order;
	}

	public void setOrder(Ordertable order) {
		this.order = order;
	}

	



	
	
	
}
