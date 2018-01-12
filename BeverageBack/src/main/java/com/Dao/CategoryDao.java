package com.Dao;

import java.util.List;


import com.Model.Category;

//interface for category
public interface CategoryDao 
{
	public void insertCategory(Category category);
	public List<Category>retrieve();
	public Category findById(int cid);
	public void deleteCategory(int cid);
	public void updateCategory(Category c);
	

}
