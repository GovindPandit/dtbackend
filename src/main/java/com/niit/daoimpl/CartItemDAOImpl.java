package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDAO;
import com.niit.model.CartItem;
import com.niit.model.User;

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

	public List<CartItem> displayCartByUser(User user) 
	{
		try
		{
			//HQL - Hibernate Query Language
			Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.CartItem where user.userid= :userid");
			return query.setParameter("userid", user.getUserid()).getResultList();
			
		}
		catch (Exception e) 
		{
			return null;
		}
		
	}

	public CartItem displayCartById(CartItem cartItem) 
	{
		try
		{
			//HQL - Hibernate Query Language
			Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.CartItem where cartitemid= :cartitemid");
			return (CartItem)query.setParameter("cartitemid", cartItem.getCartitemid()).getResultList().get(0);
			
		}
		catch (Exception e) 
		{
			return null;
		}
		

	}

}
