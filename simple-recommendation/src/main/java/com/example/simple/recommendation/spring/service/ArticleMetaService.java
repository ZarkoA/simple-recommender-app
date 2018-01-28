package com.example.simple.recommendation.spring.service;

import java.util.List;

import com.example.simple.recommendation.spring.entity.ArticleMeta;

public interface ArticleMetaService {
	
	public void addArticleMeta(ArticleMeta articleMeta);
	public List<ArticleMeta> listArticleMetas();
}
