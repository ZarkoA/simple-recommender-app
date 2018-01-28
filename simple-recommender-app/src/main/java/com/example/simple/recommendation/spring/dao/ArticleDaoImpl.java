package com.example.simple.recommendation.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.simple.recommendation.spring.entity.Article;
import com.example.simple.recommendation.spring.entity.Language;

@Repository
public class ArticleDaoImpl implements ArticleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Article article) {
		sessionFactory.getCurrentSession().save(article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> listArticles() {
		return sessionFactory.getCurrentSession().createQuery("from Article").list();
	}
	
	@Override
	public Article getArticleById(long articleId) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Article where articleId = :articleId");
		query.setParameter("articleId", articleId);
		return (Article) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Language> listMissingLanguages(Article article) {

		Query query = sessionFactory.getCurrentSession().createQuery(
				"from Language as L where L.languageKey not in (select A.language.languageKey from Article as A where A.language = L and A.articleCode = :articleCode)");
		query.setParameter("articleCode", article.getArticleCode());
		
		return query.list();
	}

}
