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
		SessionFactory sessionFactory;		//SessionFactory is factory class through which we get session & perform db oprtaion
		//(one client request required one session factory )
		//session= session object provides an interface between application & data in db
		
		public UserDaoImpl(SessionFactory sessionFactory)
		{
			super();
			this.sessionFactory=sessionFactory;
		}
		//==============insert user===================================
		public void insertUser(User user)
		{
			Session session=sessionFactory.openSession();	//creating session object
			session.beginTransaction();						//creating transaction object
			session.saveOrUpdate(user);				//saveOrUpdate=persists or updates the given object. 
													
			session.getTransaction().commit();		//transaction is commited.commit=permanantly save transaction into db
			
		}
		/*//=========find user by email====================
		public User findById(String email)
		{
			Session session=sessionFactory.openSession();
			session.beginTransaction();
			User u=null;
			try
			{
				session.getTransaction();
				u=session.get(User.class, email);
				session.getTransaction().commit();
			}
			catch(HibernateException ex)
			{
				ex.printStackTrace();
				session.getTransaction().rollback();//rollback=restore db to last commited state
			}
			return u;
			
		}*/

}
