package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addid;
	
	private int aid;
	
	private String add1;
	private String add2;
	private String add3;
	private String city;
	private String state;
	private int pincode;
	
	@Column(name = "is_active")
	private boolean active = true;
	
	
	
	
	
	
	public int getAddid() {
		return addid;
	}






	public void setAddid(int addid) {
		this.addid = addid;
	}






	public int getAid() {
		return aid;
	}






	public void setAid(int aid) {
		this.aid = aid;
	}






	public String getAdd1() {
		return add1;
	}






	public void setAdd1(String add1) {
		this.add1 = add1;
	}






	public String getAdd2() {
		return add2;
	}






	public void setAdd2(String add2) {
		this.add2 = add2;
	}






	public String getAdd3() {
		return add3;
	}






	public void setAdd3(String add3) {
		this.add3 = add3;
	}






	public String getCity() {
		return city;
	}






	public void setCity(String city) {
		this.city = city;
	}






	public String getState() {
		return state;
	}






	public void setState(String state) {
		this.state = state;
	}






	public int getPincode() {
		return pincode;
	}






	public void setPincode(int pincode) {
		this.pincode = pincode;
	}






	public boolean isActive() {
		return active;
	}






	public void setActive(boolean active) {
		this.active = active;
	}






	@Override
	public String toString() {
		return "Address [addid=" + addid + ", aid=" + aid + ", add1=" + add1 + ", add2=" + add2 + ", add3=" + add3
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", active=" + active + "]";
	}






	
	

	
}
