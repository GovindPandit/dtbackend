package com.niit.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Repository;


//ORM - Object Relational Mapping

@Entity
@Table(name="Users")

public class User 
{
	//Encapsulation
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userid;
	private String status;
	
	@Column
	@Size(min=4,message="Username length should be of minimum character 4")
	private String username;
	//@Pattern(regexp="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",message="Email is invalid")
	private String email;
	@Pattern(regexp = "^\\d{10}$",message="Mobile number is invalid")
	private String mobile;
	@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#_-]).{8,16}",message="Password is weak")
	private String password;
	
	private boolean enabled;
	private String authority;
	
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//Has-a relation
	//Class name and object
	@Embedded
	private Address address;
	
	//One to many relationship
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "user")
	private Set<CartItem> cartitems;
	
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "user")
	private Set<Order> orders;
	

	
	public Set<CartItem> getCartitems() {
		return cartitems;
	}
	public void setCartitems(Set<CartItem> cartitems) {
		this.cartitems = cartitems;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
