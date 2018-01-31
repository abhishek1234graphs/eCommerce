package com.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Cart implements Serializable
{

	@Id
	@GeneratedValue
	private int cartId;
	private int cartProductId;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userMailId")
	private User cartUserDetails;
	private Double cartPrice;
	private int cartStock;
	private String cartImage;
	private String cartProductName;
	
	public Cart()
	{
		
	}
	
	public Cart(int cartId, int cartProductId,
			User cartUserDetails, Double cartPrice, int cartStock, String cartProductName)
	{
		this.cartId=cartId;
		this.cartProductId=cartProductId;
		this.cartUserDetails=cartUserDetails;
		this.cartPrice=cartPrice;
		this.cartStock=cartStock;
		this.cartProductName=cartProductName;
		
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}

	public User getCartUserDetails() {
		return cartUserDetails;
	}

	public void setCartUserDetails(User cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}

	public Double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(Double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getCartStock() {
		return cartStock;
	}

	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}

	public String getCartImage() {
		return cartImage;
	}

	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}

	public String getCartProductName() {
		return cartProductName;
	}

	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	
}
