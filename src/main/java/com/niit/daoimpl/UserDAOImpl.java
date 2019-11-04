package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addUser(User user)
	{
		user.setEnabled(true);
		user.setAuthority("user");
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		sessionFactory.getCurrentSession().save(user);
		return true;
	}

	public void deleteUser(User user)
	{
		sessionFactory.getCurrentSession().delete(user);
	}

	public void updateUser(User user) 
	{
		sessionFactory.getCurrentSession().update(user);
	}

	public List<User> displayUsers() 
	{
		try
		{
			//HQL - Hibernate Query Language
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.User").list();
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public User displayUserById(User user) 
	{
		try
		{
			 //positional arguments - ?
			 //Named      arguments - :anyname
			
			 Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.User where userid= :userid");
			 query.setParameter("userid", user.getUserid());
			 return (User)query.getResultList().get(0);
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public User displayUserByUserName(User user) 
	{
		try
		{
			Criteria ctx=sessionFactory.getCurrentSession().createCriteria(User.class);
			return (User)ctx.add(Restrictions.eq("username", user.getUsername())).list().get(0);
		}
		catch (Exception e) 
		{
			return null;
		}
	}
}
