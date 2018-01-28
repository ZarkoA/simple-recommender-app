package com.example.simple.recommendation.spring.service;

import java.util.List;

import com.example.simple.recommendation.recommend.Recommendable;
import com.example.simple.recommendation.spring.entity.Article;

public interface RecommendationService {
	
	public List<String> recommend(Article article, Recommendable recommendable);
}
