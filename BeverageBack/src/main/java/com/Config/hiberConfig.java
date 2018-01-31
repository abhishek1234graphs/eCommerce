package com.Config;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;						//To create object of hibernate session
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.Model.Cart;
import com.Model.Category;
import com.Model.Orders;
import com.Model.Product;
import com.Model.Supplier;
import com.Model.User;


@Configuration				
@ComponentScan("com.*")			 
								
@EnableTransactionManagement	
public class hiberConfig{

@Autowired						
								
@Bean(name="dataSource")	
public DataSource getH2DataSource()
{
System.out.println("Data Source Method");
DriverManagerDataSource dataSource = new DriverManagerDataSource();		
dataSource.setDriverClassName("org.h2.Driver");			
dataSource.setUrl("jdbc:h2:tcp://localhost/~/BeveragesProj");	
dataSource.setUsername("sa");							
dataSource.setPassword("");								

System.out.println("Data Source Created");
System.out.println("Database h2 is connected");
return dataSource;
}
private Properties getHibernateProperties() 
{
System.out.println("Hibernate Properties");
Properties properties = new Properties();
properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
properties.put("hibernate.hbm2ddl.auto", "update");	
properties.put("hibernate.show_sql", "true");	
return properties;
}

@Autowired
@Bean(name = "sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource) {
LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);	//spring-orm
sessionBuilder.addProperties(getHibernateProperties());
sessionBuilder.addAnnotatedClass(User.class); 
sessionBuilder.addAnnotatedClass(Category.class); 
sessionBuilder.addAnnotatedClass(Product.class); 
sessionBuilder.addAnnotatedClass(Supplier.class); 
sessionBuilder.addAnnotatedClass(Cart.class);
sessionBuilder.addAnnotatedClass(Orders.class);

return sessionBuilder.buildSessionFactory();
}

@Autowired
@Bean(name="UserDaoImpl")
public UserDaoImpl getUserDAO(SessionFactory sessionFactory)
{
return new UserDaoImpl(sessionFactory);
}


@Autowired
@Bean(name="CategoryDaoImpl")
public CategoryDaoImpl getCategoryDAO(SessionFactory sessionFactory)
{
return new CategoryDaoImpl(sessionFactory);
}

@Autowired
@Bean(name="ProductDaoImpl")
public ProductDaoImpl getProductDAO(SessionFactory sessionFactory)
{
return new ProductDaoImpl(sessionFactory);
}


@Autowired
@Bean(name="CartDaoImpl")
public CartDaoImpl getCartDao(SessionFactory sessionFactory)
{
return new CartDaoImpl(sessionFactory);
}

@Autowired
@Bean(name="OrdersDaoImpl")
public OrdersDaoImpl getOrdersDao(SessionFactory sessionFactory)
{
return new OrdersDaoImpl(sessionFactory);
}



@Autowired
@Bean(name = "transactionManager")			
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
{
System.out.println("Transaction.....");
HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
return transactionManager;
}
}