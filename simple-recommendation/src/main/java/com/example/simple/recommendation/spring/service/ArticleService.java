package com.example.simple.recommendation.spring.service;

import java.util.List;

import com.example.simple.recommendation.spring.entity.Article;
import com.example.simple.recommendation.spring.entity.Language;

public interface ArticleService {

	public void addArticle(Article article);
	public List<Article> listArticles();
	public Article getArticle(long articleId);
	public List<Language> listMissingLanguages(Article article);
}
