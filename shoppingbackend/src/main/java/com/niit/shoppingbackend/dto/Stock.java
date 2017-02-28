package com.niit.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {

	/*
	 * 	private variables
	 * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockid;
	
	private int pid;
	private int sid;
	private int price;
	private int amount;
	
	@Column(name = "is_active")
	private boolean active = true;

	/*
	 * 	Setters and getters
	 * 
	 * */
	
	
	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	/*
	 * 	toString() method
	 * */
	
	@Override
	public String toString() {
		return "Stock [stockid=" + stockid + ", pid=" + pid + ", sid=" + sid + ", price=" + price + ", amount=" + amount
				+ ", active=" + active + "]";
	}
	
	
	
	
}
