package com.niit.shoppingbackend.dto;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;


@Entity
public class Product {
	
	/*
	 * private variables
	 * */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	@NotNull
	@Size(min=1,max=50)
	private String pname;
	
	@NotNull
	@Size(min=20,max=250)
	private String pdesc;
	
	@OneToOne
	@JoinColumn(name="id")
	private Category category;
	
	
	@Min(1)
	@Max(999999)
	private int price;
	
	@Column
	private int stock;
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Column
	private String pimage;
	
	
	@NotNull
	@Size(min=1,max=20)
	private String pcolor;

	public String getPcolor() {
		return pcolor;
	}
	public void setPcolor(String pcolor) {
		this.pcolor = pcolor;
	}

	@Column(name="is_active") 
	private boolean active = true;
	
	
	@Transient
	transient private MultipartFile image;
	
	
	/*
	 * Setter getter methods
	 * */
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", category=" + category + ", price="
				+ price + ", stock=" + stock + ", pimage=" + pimage + ", pcolor=" + pcolor + ", active=" + active + "]";
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getPimage() {
		return pimage;
	}
	public void setPimage(String pimage) {
		this.pimage = pimage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	/*
	 * toString() method
	 * 
	 * */
	
	
	
	
	
	public String getFilePath(String path1,String contextPath) {

		String fileName=null;
		
		if (!image.isEmpty()) {
			try {
				

				fileName=image.getOriginalFilename();
				byte[] bytes = image.getBytes();
				String npath=path1+"\\assets\\images\\"+fileName;

				
				BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(new File(npath)));  
				stream.write(bytes);  
				stream.close();
				String dbfileName = contextPath+"/resources/images/"+fileName;
				//String dbfileName = fileName;
				this.setPimage(dbfileName);
				
				return dbfileName;
			} catch (Exception e) {
				return "You failed to upload " + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload because the file was empty.";
		}
	}
	
	
}
