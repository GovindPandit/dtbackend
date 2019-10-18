package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDAO;
import com.niit.model.CartItem;

@Transactional
@Repository("cartDAO")

public class CartItemDAOImpl implements CartItemDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addCart(CartItem cart) 
	{
		sessionFactory.getCurrentSession().save(cart);
	}

	public void deleteCart(CartItem cart) 
	{
		sessionFactory.getCurrentSession().delete(cart);
	}

	public void updateCart(CartItem cart)
	{
		sessionFactory.getCurrentSession().update(cart);
	}

	public List<CartItem> displayCart(CartItem cart) 
	{
		try
		{
			//HQL - Hibernate Query Language
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.CartItem").list();
		}
		catch (Exception e) 
		{
			return null;
		}
		
	}

}
