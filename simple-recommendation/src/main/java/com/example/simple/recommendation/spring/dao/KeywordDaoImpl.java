package com.example.simple.recommendation.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.simple.recommendation.spring.entity.Keyword;

@Repository
public class KeywordDaoImpl implements KeywordDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addKeyword(Keyword keyword) {
		sessionFactory.getCurrentSession().save(keyword);
	}

	@Override
	public int getArticleKeywordCount(long articleId) {

		Query query = sessionFactory.getCurrentSession().createQuery("from ArticleKeyword as AK where AK.article.articleId = :articleId");
		query.setParameter("articleId", articleId);
		return query.list().size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Keyword> listKeywords() {
		return sessionFactory.getCurrentSession().createQuery("from Keyword").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Keyword> listArticleKeywords(long articleId) {

		Query query = sessionFactory.getCurrentSession().createQuery("from ArticleKeyword as AK where AK.article.articleid = :articleId");
		query.setParameter("articleId", articleId);
		
		return query.list();
	}

}
