package com.DaoImpl;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.Dao.CategoryDao;
import com.Dao.UserDao;
import com.Model.Category;
import com.Model.Product;
import com.Model.User;

@SuppressWarnings("unused")

@Repository("categoryDaoImpl")

public class CategoryDaoImpl implements CategoryDao
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	
	public void insertCategory(Category category)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(category);
		session.getTransaction().commit();
	}
	
	public List<Category> retrieve()
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		List<Category> li=session.createQuery("from Category").list();
		session.getTransaction().commit();
		return li;
	}
	
	public Category findById(int cid)
	{
		Session session=sessionFactory.openSession();
		Category c=null;
		try
		{
			session.beginTransaction();
			c=session.get(Category.class, cid);
			session.getTransaction().commit();
		}
		catch(HibernateException ex)
		{
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		return c;
		
	}
	
		public void deleteCategory(int cid)
		{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			Category category=(Category)session.get(Category.class, cid);
			session.delete(category);
			session.getTransaction().commit();
		}
		
		public void updateCategory(Category c)
		{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			session.update(c);
			session.getTransaction().commit();
			
		}

}
