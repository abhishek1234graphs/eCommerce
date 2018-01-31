package com.controller;

import java.security.Principal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DaoImpl.CartDaoImpl;
import com.DaoImpl.CategoryDaoImpl;
import com.DaoImpl.OrdersDaoImpl;
import com.DaoImpl.ProductDaoImpl;
import com.DaoImpl.SupplierDaoImpl;
import com.DaoImpl.UserDaoImpl;
import com.Model.Cart;
import com.Model.Orders;
import com.Model.Product;
import com.Model.User;

@Controller
//@EnableAspectJAutoProxy(proxyTargetClass = true) 
public class CartController {

	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	@Autowired
	CategoryDaoImpl categoryDaoImpl;
	
	@Autowired 
	ProductDaoImpl productDaoImpl;
	
	@Autowired
	CartDaoImpl cartDaoImpl;
	
	@Autowired
	UserDaoImpl userDaoImpl;
	
	@Autowired
	OrdersDaoImpl ordersDaoImpl;

	
	
	@RequestMapping(value="/prodDetails/{pid}")
	public ModelAndView prodDetails(@PathVariable("pid")int pid)
	{
		ModelAndView mav=new ModelAndView();
		Product prod=productDaoImpl.findById(pid);
		mav.addObject("prod",prod);
		mav.setViewName("prodDetails");
		return mav;
	}
	
	@RequestMapping(value="/addToCart",method=RequestMethod.POST)
	public ModelAndView addToCart(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView();
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		try
		{
			int pid=Integer.parseInt(request.getParameter("pid"));
			Double price=Double.parseDouble(request.getParameter("pPrice"));
			int qty=Integer.parseInt(request.getParameter("qty"));
			String pname=request.getParameter("pName");
			String imgName=request.getParameter("imgname");
			Cart cartExist=cartDaoImpl.getCartById(pid, userEmail);
			
			if(cartExist == null)
			{
				Cart cm = new Cart();
				cm.setCartPrice(price);
				cm.setCartProductId(pid);
				cm.setCartStock(qty);
				cm.setCartImage(imgName);
				cm.setCartProductName(pname);
				
				User u = userDaoImpl.findUserByEmail(userEmail);
				cm.setCartUserDetails(u);
				cartDaoImpl.insert(cm);
			}
			else if(cartExist != null)
			{
				Cart cm = new Cart();
				cm.setCartId(cartExist.getCartId());
				cm.setCartPrice(price);
				cm.setCartProductId(pid);
				cm.setCartStock(qty);
				cm.setCartImage(imgName);
				cm.setCartProductName(pname);
				
				User u = userDaoImpl.findUserByEmail(userEmail);
				cm.setCartUserDetails(u);
				cartDaoImpl.updateCart(cm);
			}
			
			mav.addObject("cartInfo",cartDaoImpl.findByCartId(userEmail));
			mav.setViewName("cart");
			
			return mav;
		}	
			catch(Exception e)
			{
				e.printStackTrace();
				
				mav.setViewName("cart");
				return mav;
			}
		}
	
	@RequestMapping(value="/checkout",method=RequestMethod.GET)
	public ModelAndView checkoutProcess(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView();
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		User user=userDaoImpl.findUserByEmail(userEmail);
		List<Cart>cart=(List<Cart>) cartDaoImpl.findByCartId(userEmail);
		mav.addObject("user", user);
		mav.addObject("cart", cart);
		return mav;
	}

	@RequestMapping(value="/Orderprocess",method=RequestMethod.POST)
	public ModelAndView orderSave(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView("ack");
		Orders ord=new Orders();
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		Double total=Double.parseDouble(request.getParameter("total"));
		String payment=request.getParameter("payment");
		User user=userDaoImpl.findUserByEmail(userEmail);
		ord.setTotal(total);
		ord.setUser(user);
		ord.setPayment(payment);
		ordersDaoImpl.insert(ord);
		mav.addObject(" orderDetails",user);
		mav.setViewName("ack");
		return mav;
	}

	@RequestMapping(value="/deleteCart/{cartId}")
	public ModelAndView deleteCartItem(@PathVariable("cartId")int cartId,HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView();
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		cartDaoImpl.deleteCart(cartId);
		mav.addObject("cartInfo", cartDaoImpl.findByCartId(userEmail));
		mav.setViewName("cart");
		return mav;
	}
	
	@RequestMapping(value="/goToCart",method=RequestMethod.GET)
	public ModelAndView goToCart(HttpServletRequest request)
	{
		ModelAndView mav=new ModelAndView();
		Principal principal=request.getUserPrincipal();
		String userEmail=principal.getName();
		mav.addObject("cartInfo", cartDaoImpl.findByCartId(userEmail));
		mav.setViewName("cart");
		return mav;
	}


}

