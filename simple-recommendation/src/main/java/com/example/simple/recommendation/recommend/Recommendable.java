package com.example.simple.recommendation.recommend;

import java.util.List;

import com.example.simple.recommendation.spring.entity.Article;

public interface Recommendable {
	
	public List<String> recommend(Article article);
}
