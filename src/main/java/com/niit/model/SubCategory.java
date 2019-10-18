package com.niit.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name="subcategories")
public class SubCategory 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subcategoryid;
	private String subcategoryname;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Category category;
	
	public int getSubcategoryid() 
	{
		return subcategoryid;
	}
	
	public void setSubcategoryid(int subcategoryid) 
	{
		this.subcategoryid = subcategoryid;
	}
	
	public String getSubcategoryname() 
	{
		return subcategoryname;
	}
	
	public void setSubcategoryname(String subcategoryname) 
	{
		this.subcategoryname = subcategoryname;
	}
}
