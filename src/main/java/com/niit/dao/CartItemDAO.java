package com.niit.dao;

import java.util.List;

import com.niit.model.CartItem;
import com.niit.model.User;

public interface CartItemDAO
{
	public void addCart(CartItem cart);
	public void deleteCart(CartItem cart);
	public void updateCart(CartItem cart);
	public List<CartItem> displayCartByUser(User user);
	public CartItem displayCartById(CartItem cartItem);
}
