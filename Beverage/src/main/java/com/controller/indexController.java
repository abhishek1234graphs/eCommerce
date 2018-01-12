package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.Model.User;


@SuppressWarnings("unused")
@Controller
public class indexController 
{
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;

	
	@RequestMapping("/")			
	public String index(Model m)
	{
	//	m.addAttribute("catList",categoryDaoImpl.retrieve());
		return "index";
	}
	@RequestMapping("/index")
	public String home(Model m)
	{
		//m.addAttribute("catList",categoryDaoImpl.retrieve());
		return "index";
	}
		
	
	/*//===================after click on login (it go to login.jsp)=======================
	@RequestMapping("/goToLogin")
	public ModelAndView goToLogin(Model m)
	{
	//	m.addAttribute("catList",categoryDaoImpl.retrieve());
		ModelAndView mav=new ModelAndView();
		mav.setViewName("login");
		return mav;
	}*/
	
	@RequestMapping(value= "/goToRegister",method= RequestMethod.GET)
	public ModelAndView showRegister()
	{
		System.out.println("this is registration form.....");
		ModelAndView mav=new ModelAndView();
		mav.addObject("user", new User());
		mav.setViewName("register");
		return mav;
	}
	
	@RequestMapping(value= "/saveregister",method= RequestMethod.POST)
	public ModelAndView saveRegister(@Valid @ModelAttribute("user") User user,BindingResult result)
	{
		ModelAndView mav=new ModelAndView();
		System.out.println("save registration form........");
		if(result.hasErrors())
		{
			
			mav.setViewName("register");
			return mav;
		}
		else
		{
			user.setRole("ROLE_USER");
			userDaoImpl.insertUser(user);
			mav.setViewName("index");	
			return mav;
		}
		
	}
	
	@RequestMapping(value="/productCatList")
	public ModelAndView getCatTable(@RequestParam("cid") int cid)
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("productList", productDaoImpl.getProdCatById(cid));
		mav.setViewName("productCatList");
		return mav;
	}
	
	@ModelAttribute
	public void getData(Model m)
	{
		m.addAttribute("catList",categoryDaoImpl.retrieve());
	}
}