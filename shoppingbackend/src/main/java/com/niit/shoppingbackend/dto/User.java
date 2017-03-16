package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	
	
	private long pno;
	
	
	@Size(min=8,max=20)
	private String pw;
	
	
	@Size(min=2,max=50)
	private String fname;
	
	
	@Size(min=2,max=50)
	private String lname;
	
	
	@Size(min=2,max=50)
	private String email;
	
	
	
	@Size(min=2,max=50)
	private String add1;
	
	
	@Size(min=2,max=50)
	private String add2;
	
	
	
	@Size(min=2,max=50)
	private String add3;
	
	
	@Size(min=2,max=50)
	private String city;
	
	
	@Size(min=2,max=50)
	private String state;
	
	@Min(100000)
	@Max(999999)
	private int pincode;
	
	private String role="CUSTOMER";
	@Column(name="is_active")
	private boolean active = true;
	
	
	@Size(min=8,max=20)
	transient private String currentpw;
	
	
	@Size(min=8,max=20)
	transient private String newpw1;
	
	
	@Size(min=8,max=20)
	transient private String newpw2;
	
	
	
	/* setters and getters
	 * 
	 * */
	
	public String getCurrentpw() {
		return currentpw;
	}
	public void setCurrentpw(String currentpw) {
		this.currentpw = currentpw;
	}
	public String getNewpw1() {
		return newpw1;
	}
	public void setNewpw1(String newpw1) {
		this.newpw1 = newpw1;
	}
	public String getNewpw2() {
		return newpw2;
	}
	public void setNewpw2(String newpw2) {
		this.newpw2 = newpw2;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public long getPno() {
		return pno;
	}
	public void setPno(long pno) {
		this.pno = pno;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
		return "User [uid=" + uid + ", pno=" + pno + ", pw=" + pw + ", fname=" + fname + ", lname=" + lname + ", email="
				+ email + ", add1=" + add1 + ", add2=" + add2 + ", add3=" + add3 + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + ", role=" + role + ", active=" + active + "]";
	}
	
	public boolean pwvalidate() {
		
		String c=this.currentpw;
		String p=this.pw;
		
		System.out.println("currnet pw: "+c);
		System.out.println("thispw pw: "+p);
		
		if(c.equals(p))
		{
			if(newpw1.equals(newpw2))
			{
				this.setPw(newpw1);
				System.out.println("PW changed successfully");
				return true;
			}
			else
			{
				System.out.println("new pws not matching");
				return false;
			}
		}
		else
		{
			System.out.println("wrong current pw");
			return false;
		}
		
		
	}
	
}
