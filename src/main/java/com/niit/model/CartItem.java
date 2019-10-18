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
@Table(name="CartItems")
public class CartItem
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int caritemtid;
	@Column
	private int quantity;
	private float totalprice;
	
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

	public int getCaritemtid() {
		return caritemtid;
	}

	public void setCaritemtid(int caritemtid) {
		this.caritemtid = caritemtid;
	}

	public int getQuantity()
	{
		return quantity;
	}
	
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	
	public float getTotalprice()
	{
		return totalprice;
	}
	
	public void setTotalprice(float totalprice)
	{
		this.totalprice = totalprice;
	}
	
	
}
