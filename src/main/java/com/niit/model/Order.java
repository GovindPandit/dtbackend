package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name="Orders")
public class Order
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderid;
	@Column
	private float totalprice;
	private String orderstatus;
	
	private String orderdate;
	private String returndate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Product product;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}


	public float getTotalprice() {
		return totalprice;
	}
	
	public int getOrderid() {
		return orderid;
	}
	
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	

	
	public String getOrderstatus() {
		return orderstatus;
	}
	
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	public String getOrderdate() {
		return orderdate;
	}
	
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	
	public String getReturndate() {
		return returndate;
	}
	
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	
}
