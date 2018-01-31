package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.CartDao;
import com.Model.Cart;

@Repository("CartDaoImpl")
public class CartDaoImpl implements CartDao
{
    @Autowired
    SessionFactory sessionFactory;
    
    public CartDaoImpl(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }

	@Override
	public void insert(Cart cart) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(cart);
		session.getTransaction().commit();	
	}
	
	public List<Cart> findByCartId(String userId)
	{
		Session session=sessionFactory.openSession();
		List<Cart> cr=null;
		try
		{
			session.beginTransaction();
			cr=(List<Cart>)session.createQuery("from Cart where userMailId=:email").setString("email",userId).list();
		    session.getTransaction().commit();
		}
		catch(HibernateException e)
		{
			System.out.println(e);
			session.getTransaction().rollback();
		}
		
		return cr;
	}


    
    public Cart getCartById(int cartProductId, String userEmail)
    {
    	Session session=sessionFactory.openSession();
    	Cart cr=null;
    	session.beginTransaction();
    	cr=(Cart)session.createQuery("from Cart where userMailId=:email and cartProductId=:id").setString("email", userEmail).setInteger("id",cartProductId).uniqueResult();
        session.getTransaction().commit();
        return cr;
    }
    
    public void deleteCart(int cartId)
    {
    	Session session=sessionFactory.openSession();
    	session.beginTransaction();
    	Cart cr=(Cart)session.get(Cart.class, cartId);
    	session.delete(cr);
    	session.getTransaction().commit();
    }
    
    public void updateCart(Cart cr)
    {
    	Session session=sessionFactory.openSession();
    	session.beginTransaction();
    	session.update(cr);
    	session.getTransaction().commit();
    }
}























