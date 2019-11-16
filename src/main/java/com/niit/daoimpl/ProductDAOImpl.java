package com.niit.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public void addProduct(Product product) 
	{
		product.setStatus("A");
		sessionFactory.getCurrentSession().save(product);
	}

	public void deleteProduct(Product product) 
	{
		sessionFactory.getCurrentSession().delete(product);
	}

	public void updateProduct(Product product) 
	{
		sessionFactory.getCurrentSession().update(product);
	}

	public List<Product> displayProducts()
	{
		try
		{
			//HQL - Hibernate Query Language
			return sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product").list();
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public Product displayProductById(Product product)
	{
		try
		{
			 //positional arguments - ?
			 //Named      arguments - :anyname
			
			 Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product where productid= :productid");
			 query.setParameter("productid", product.getProductid());
			 return (Product)query.getResultList().get(0);
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public Product displayProductByName(Product product) 
	{
		try
		{
			 //positional arguments - ?
			 //Named      arguments - :anyname
			
			 Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product where productname= :productname");
			 query.setParameter("productname", product.getProductname());
			 return (Product)query.getResultList().get(0);
		}
		catch (Exception e) 
		{
			return null;
		}
	}
	
	public List<Product> searchByName(String name) 
	{
		try
		{
			Query query=sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product where lower(productname) like :productname ");
			query.setParameter("productname", "%"+name.toLowerCase()+"%");
			return query.getResultList();
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return null;
		}
	}

	public List<Product> displayProductByPriceAsc() 
	{
		try
		{
			 return sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product order by price asc").list();
		}
		catch (Exception e) 
		{
			return null;
		}
	}

	public List<Product> displayProductByPriceDesc() 
	{
		try
		{
			
			List<Product> products=sessionFactory.getCurrentSession().createQuery("from com.niit.model.Product order by price desc").list();
			return products;
		}
		catch (Exception e) 
		{
			return null;
		}
	
	}

}
