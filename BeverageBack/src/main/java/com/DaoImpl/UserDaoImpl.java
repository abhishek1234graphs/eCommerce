package com.DaoImpl;
import org.hibernate.HibernateException;

import org.hibernate.Session;		//provides method to insert,update & delete object
import org.hibernate.SessionFactory;	//provides factory method to get object of session
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.UserDao;

import com.Model.User;

@Repository("UserDaoImpl")
	public class UserDaoImpl implements UserDao
	{
		@Autowired						
		SessionFactory sessionFactory;	
		
		//session= session object provides an interface between application & data in db
		
		public UserDaoImpl(SessionFactory sessionFactory)
		{
			super();
			this.sessionFactory=sessionFactory;
		}
		
		public void insertUser(User user)
		{
			Session session=sessionFactory.openSession();	
			session.beginTransaction();						
			session.saveOrUpdate(user);				
													
			session.getTransaction().commit();					
		}
		
		
		public User findUserByEmail(String email)
		{
			Session session=sessionFactory.openSession();
			User u=null;
			try
			{
				session.beginTransaction();
				u=session.get(User.class, email);
				session.getTransaction().commit();
			}
			catch(HibernateException ex)
			{
				ex.printStackTrace();
				session.getTransaction().rollback();
			}	
			return u;
			
		}

}
	
