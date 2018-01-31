package com.focusbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.DaoImpl.CategoryDaoImpl;
import com.Model.Category;

public class CategoryTestCases {
	@Autowired static AnnotationConfigApplicationContext context;
	   static CategoryDaoImpl catDao;
	   
	   @BeforeClass
	   public static void intialize()
	   {
		   context=new AnnotationConfigApplicationContext();
		   context.scan("com.*");
		   context.refresh();
		   catDao=(CategoryDaoImpl)context.getBean("categoryDaoImpl");
	   }
	   
	   @Test
	   public void catTest()
	   {
		   Category cc=new Category();
		   cc.setCid(4);
		   cc.setName("Test");
		   catDao.insertCategory(cc);
		   assertEquals(cc.getCid(),cc.getCid());
	   }
}
