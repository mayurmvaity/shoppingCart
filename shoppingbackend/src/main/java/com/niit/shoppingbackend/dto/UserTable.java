package com.niit.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.stereotype.Component;

@Component
@Table(name="usertable")
@Entity
public class UserTable implements Serializable {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 8425983882762090946L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	
	
	@Column
	@Pattern(regexp = "^([7-9]{1})([0-9]{9})", message = "Not a valid number ,Phone No. must be of 10 digits")
	private String pno;
	
	@Column
	@Size(min=8,max=20, message="Please select atleast 8 character password!")
	private String pw;
	
	@Column
	@Size(min=2,max=50, message="Please enter valid first name!")
	private String fname;
	
	@Column
	@Size(min=2,max=50, message="Please enter valid last name!")
	private String lname;
	
	@Column
	@Size(min=1,max=1)
	private String gender="M";
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column
	@Email(message="please enter valid email address")
	private String email;
	
	
	@Column
	@Size(min=2,max=50, message="Please enter valid address line!")
	private String add1;
	
	@Column
	@Size(min=2,max=50, message="Please enter valid address line!")
	private String add2;
	
	
	@Column
	@Size(min=2,max=50, message="Please enter valid address line!")
	private String add3;
	
	@Column
	@Size(min=2,max=50, message="Please enter valid city name!")
	private String city;
	
	@Column
	@Size(min=2,max=50, message="Please enter valid state name!")
	private String state;
	
	@Column
	@Min(100000)
	@Max(999999)
	private int pincode;
	
	
	

	@OneToOne
	@JoinColumn(name="cartid")
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Column
	private String role="ROLE_USER";
	
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}

	@Column(name="is_active")
	private boolean active = true;
	
	/*@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cartId")
	@JsonIgnore
	private Cart cart;*/
	
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
	@Override
	public String toString() {
		return "UserTable [uid=" + uid + ", pno=" + pno + ", pw=" + pw + ", fname=" + fname + ", lname=" + lname
				+ ", gender=" + gender + ", email=" + email + ", add1=" + add1 + ", add2=" + add2 + ", add3=" + add3
				+ ", city=" + city + ", state=" + state + ", pincode=" + pincode + ", cart=" + cart + ", role=" + role
				+ ", active=" + active + "]";
	}
	
	/*
	 * toString() method
	 * */
	
	
}
