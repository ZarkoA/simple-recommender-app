package com.example.simple.recommendation.spring.service;

import java.util.List;

import com.example.simple.recommendation.spring.entity.Category;

public interface CategoryService {
	
	public void addCategory(Category category);
	public Category getCategoryById(long categoryId);
	public Category getCategoryByTitle(String categoryTitle);
	public List<Category> listCategories();
}
