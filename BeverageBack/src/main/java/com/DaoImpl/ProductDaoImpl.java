package com.DaoImpl;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.ProductDao;
import com.Model.Category;
import com.Model.Product;


@SuppressWarnings("deprecation")

@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public void insertProduct(Product product)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(product);
		session.getTransaction().commit();
	}
	
	public List<Product> retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Product>list=session.createQuery("from Product").list();
		session.getTransaction().commit();
		return list;
	}
	
	public Product findById(int pid)
	{
		Session session=sessionFactory.openSession();
		Product p=null;
		try
		{
			session.beginTransaction();
			p=session.get(Product.class, pid);
			session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return p;
		
	}
	
	@Override
	public List<Product> getProdCatById(int cid) {
		Session session=sessionFactory.openSession();
		List<Product> prod=null;
		try
		{
		session.beginTransaction();
		prod=session.createQuery("from Product where cid=" +cid).list();
		session.getTransaction().commit();
		}
		catch(Exception e)
		{
			System.out.println(e);
			session.getTransaction().rollback();
		}
		return prod;
	}
	
	public void deleteProduct(int pid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Product p=(Product)session.get(Product.class, pid);
		session.delete(p);
		session.getTransaction().commit();
	}
	
	public void update(Product p)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
	}

	

	
	
}