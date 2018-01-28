package com.example.simple.recommendation.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simple.recommendation.spring.dao.ArticleDao;
import com.example.simple.recommendation.spring.entity.Article;
import com.example.simple.recommendation.spring.entity.Language;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Transactional
	@Override
	public void addArticle(Article article) {
		articleDao.add(article);
	}

	@Transactional
	@Override
	public List<Article> listArticles() {
		return articleDao.listArticles();
	}

	@Transactional
	@Override
	public Article getArticle(long articleId) {
		return articleDao.getArticleById(articleId);
	}

	@Transactional
	@Override
	public List<Language> listMissingLanguages(Article article) {
		return articleDao.listMissingLanguages(article);
	}
}
