package com.example.simple.recommendation.spring.dao;

import java.util.List;

import com.example.simple.recommendation.spring.entity.ArticleMeta;

public interface ArticleMetaDao {

	public void addArticleMeta(ArticleMeta improvement);
	public List<ArticleMeta> listArticleMetas();
}
