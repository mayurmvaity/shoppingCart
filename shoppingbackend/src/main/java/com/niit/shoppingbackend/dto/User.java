package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uid;
	private String type;
	private String pw;
	
	private String fname;
	private String lname;
	
	private String email;
	private int pno;
	
	private String add1;
	private String add2;
	private String add3;
	private String city;
	private String state;
	private int pincode;
	
	@Column(name = "is_active")
	private boolean active;
	
}
