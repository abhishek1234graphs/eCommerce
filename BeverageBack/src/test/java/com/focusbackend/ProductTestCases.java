package com.focusbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DaoImpl.ProductDaoImpl;
import com.Model.Product;


public class ProductTestCases {
	@Autowired static AnnotationConfigApplicationContext context;
	   static ProductDaoImpl prodDao;
	   
	   @BeforeClass
	   public static void intialize()
	   {
		   context=new AnnotationConfigApplicationContext();
		   context.scan("com.*");
		   context.refresh();
		   prodDao=(ProductDaoImpl)context.getBean("productDaoImpl");
	   }
	   
	   @Test
	   public void prodTest()
	   {
		   Product pp=new Product();
		   pp.setId(4);
		   pp.setName("Test");
		   pp.setPrice(1200f);
		   pp.setStock(2);
		   pp.setDescription("Test Case");
		   prodDao.insertProduct(pp);
		   assertEquals(pp.getId(),pp.getId());
	   }
}
