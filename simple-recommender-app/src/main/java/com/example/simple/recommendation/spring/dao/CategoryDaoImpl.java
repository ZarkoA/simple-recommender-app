package com.example.simple.recommendation.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.simple.recommendation.spring.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCategory(Category category) {
		sessionFactory.getCurrentSession().save(category);
	}

	@Override
	public Category getCategoryById(long categoryId) {

		Query query = sessionFactory.getCurrentSession().createQuery("from Category as C where C.categoryId = :categoryId");
		query.setParameter("categoryId", categoryId);
		
		return (Category) query.uniqueResult();
	}
	
	@Override
	public Category getCategoryByTitle(String categoryTitle) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Category as C where C.categoryTitle = :categoryTitle");
		query.setParameter("categoryTitle", categoryTitle);
		
		return (Category) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}
}
