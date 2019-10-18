package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO 
{
	public void addProduct(Product product);
	public void deleteProduct(Product product);
	public void updateProduct(Product product);
	public List<Product> displayProducts();
	public Product displayProductById(Product product);
	public Product displayProductByName(Product product);
}
