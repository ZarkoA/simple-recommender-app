package com.example.simple.recommendation.spring.dao;

import java.util.List;

import com.example.simple.recommendation.spring.entity.Article;
import com.example.simple.recommendation.spring.entity.Language;

public interface ArticleDao {
	
	public void add(Article article);
	public List<Article> listArticles();
	public Article getArticleById(long articleId);
	public List<Language> listMissingLanguages(Article article);
}
