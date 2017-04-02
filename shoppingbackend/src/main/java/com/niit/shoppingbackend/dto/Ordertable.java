package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

@Entity
public class Ordertable {
 
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderid;
	
	@OneToOne
	@JoinColumn(name="uid")
	private UserTable user;
	
	@OneToOne
	@JoinColumn(name="addid")
	private Address address;
	
	@Column
	private long amount;
	
	@Column(name="is_ordered")
	private boolean ordered=false;
	
	@Column
	private String payment;
	
	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	@Column(name="is_delivered")
	private boolean delivered=false;
	
	public boolean isDelivered() {
		return delivered;
	}

	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	@Column(name="is_active")
	private boolean active=true;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public UserTable getUser() {
		return user;
	}

	public void setUser(UserTable user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Ordertable [orderid=" + orderid + ", user=" + user + ", address=" + address + ", amount=" + amount
				+ ", ordered=" + ordered + ", payment=" + payment + ", delivered=" + delivered + ", active=" + active
				+ "]";
	}

	
	
	
	
	
}
