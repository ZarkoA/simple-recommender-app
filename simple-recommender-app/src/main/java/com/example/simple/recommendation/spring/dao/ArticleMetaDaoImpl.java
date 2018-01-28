package com.example.simple.recommendation.spring.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.simple.recommendation.spring.entity.ArticleMeta;

@Repository
public class ArticleMetaDaoImpl implements ArticleMetaDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addArticleMeta(ArticleMeta articleMeta) {
		sessionFactory.getCurrentSession().save(articleMeta);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArticleMeta> listArticleMetas() {
		return sessionFactory.getCurrentSession().createQuery("from ArticleMeta").list();
	}
}
