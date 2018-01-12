package com.Model;

import java.io.Serializable;
import java.util.*;

import javassist.SerialVersionUID;

import javax.persistence.*;
import javax.validation.*;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table (name="Supplier")
public class Supplier implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int sid;
	private String supplierName;
	
	
	
	@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER,mappedBy=("supplier"))
	private Set<Product>product=new HashSet<Product>(0);
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	public Set<Product> getProduct() {
		return product;
	}
	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	

}
