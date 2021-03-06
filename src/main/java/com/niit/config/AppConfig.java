package com.niit.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.daoimpl.CartItemDAOImpl;
import com.niit.daoimpl.OrderDAOImpl;
import com.niit.daoimpl.ProductDAOImpl;
import com.niit.daoimpl.UserDAOImpl;

//MyComment
@Configuration
@ComponentScan(basePackages="com.niit")
@EnableTransactionManagement
public class AppConfig
{
	@Bean(name = "dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");

		dataSource.setUsername("sa");
		dataSource.setPassword("faculty@123");
		return dataSource;
	}
	
	  private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.hbm2ddl.auto", "update");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	return properties;
	    }
	 
	   @Bean (name = "sessionFactory")
	   @Autowired
	   public LocalSessionFactoryBean getSessionFactory() 
	   {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(getDataSource());
	      sessionFactory.setPackagesToScan("com.niit.model");
	      sessionFactory.setHibernateProperties(getHibernateProperties());	 
	      return sessionFactory;
	   }
	   
	    @Bean(name = "transactionManager")
			@Autowired
			public HibernateTransactionManager getTransactionManager(
					SessionFactory sessionFactory) {
				HibernateTransactionManager transactionManager = new HibernateTransactionManager(
						sessionFactory);

				return transactionManager;
			}
	    
	    @Bean(name="userDAO")
	    @Autowired
	    public UserDAOImpl getUserDAO()
	    {
	    	return new UserDAOImpl();
	    }
	    
	    @Bean(name="orderDAO")
	    @Autowired
	    public OrderDAOImpl getOrderDAO()
	    {
	    	return new OrderDAOImpl();
	    }
	    
	    @Bean(name="productDAO")
	    @Autowired
	    public ProductDAOImpl getProductDAO()
	    {
	    	return new ProductDAOImpl();
	    }
	    
	    @Bean(name="cartDAO")
	    @Autowired
	    public CartItemDAOImpl getCartDAO()
	    {
	    	return new CartItemDAOImpl();
	    }
}