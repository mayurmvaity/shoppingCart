package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Supplier {
	
	/*
	 *  private variables
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	
	@NotNull
	@Size(min=2,max=50)
	private String sname;
	
	@NotNull
	@Size(min=20,max=250)
	private String sdesc;
	
	@Column(name = "is_active")
	private boolean active = true;

	/*
	 * 	setters and getters
	 * 
	 * */
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSdesc() {
		return sdesc;
	}

	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/*
	 * toString() method
	 * */
	
	@Override
	public String toString() {
		return "Supplier [sid=" + sid + ", sname=" + sname + ", sdesc=" + sdesc + ", active=" + active + "]";
	}

	
	
	
	
	
	
	
}
