package com.Beveragebackend;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DaoImpl.*;
import com.Model.*;

public class UserTestCases
{
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
	   User us=new User();
	   System.out.println("Started..............");
	   us.setEmail("test@gmail.com");
	   us.setName("test");
	   us.setPassword("test");
	   us.setAddress("test address");
	   us.setRole("ROLE_USER");
	   us.setPhone("9458763214");
	   userDao.insertUser(us);
	   assertEquals(us.getEmail(),us.getEmail());
	   System.out.println("END.............");
   }
}
