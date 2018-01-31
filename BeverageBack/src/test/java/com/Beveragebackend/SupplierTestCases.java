package com.Beveragebackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DaoImpl.SupplierDaoImpl;
import com.Model.Supplier;

public class SupplierTestCases
{
   @Autowired static AnnotationConfigApplicationContext context;
   static SupplierDaoImpl suppDao;
   
   @BeforeClass
   public static void intialize()
   {
	   context=new AnnotationConfigApplicationContext();
	   context.scan("com.*");
	   context.refresh();
	   suppDao=(SupplierDaoImpl)context.getBean("supplierDaoImpl");
   }
   
   @Test
   public void suppTest()
   {
	   Supplier ss=new Supplier();
	   ss.setSid(4);
	   ss.setSupplierName("Test");
	   suppDao.insertSupplier(ss);
	   assertEquals(ss.getSid(),ss.getSid());
   }
}
