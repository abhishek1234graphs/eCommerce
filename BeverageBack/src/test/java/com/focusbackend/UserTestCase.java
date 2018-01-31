package com.focusbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DaoImpl.UserDaoImpl;
import com.Model.User;


public class UserTestCase {
	@Autowired static AnnotationConfigApplicationContext context;
	   static UserDaoImpl userDao;
	   
	   @BeforeClass
	   public static void intialize()
	   {
		   context=new AnnotationConfigApplicationContext();
		   context.scan("com.*");
		   context.refresh();
		  userDao=(UserDaoImpl)context.getBean("UserDaoImpl");
	   }
	   
	   @Test
	   public void userTest()
	   {
		   User uu=new User();
		   uu.setEmail("test@gmail.com");
		   uu.setName("Test");
		   uu.setPassword("Test");
		   uu.setRole("ROLE_USER");
		   uu.setAddress("Test");
		   uu.setPhone("9889625415");
		   userDao.insertUser(uu);
		   assertEquals(uu.getEmail(),uu.getEmail());
	   }
}
