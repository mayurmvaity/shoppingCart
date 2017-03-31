package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Ordertable {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	
	@OneToOne
	@JoinColumn(name="uid")
	private UserTable user;
	
	@OneToOne
	@JoinColumn(name="addid")
	private Address address;
	
	@Column
	private long amt;

	@Column(name="is_active")
	private boolean active=true;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
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

	public long getAmt() {
		return amt;
	}

	public void setAmt(long amt) {
		this.amt = amt;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", user=" + user + ", address=" + address + ", amt=" + amt + ", active=" + active
				+ "]";
	}

	
	
	
	
	
}
