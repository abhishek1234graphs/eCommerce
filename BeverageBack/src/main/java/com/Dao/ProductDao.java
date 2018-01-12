package com.Dao;

import java.util.List;


import com.Model.Product;

public interface ProductDao 
{
	public void insertProduct(Product product);
	public List<Product> retrieve();
	public Product findById(int pid);
	public List<Product> getProdCatById(int cid);
	public void deleteProduct(int pid);
	public void update(Product p);
}
