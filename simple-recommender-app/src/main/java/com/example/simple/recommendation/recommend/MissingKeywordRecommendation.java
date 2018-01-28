package com.example.simple.recommendation.recommend;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.simple.recommendation.spring.entity.Article;

@Component
public class MissingKeywordRecommendation implements Recommendable {

	@Override
	public List<String> recommend(Article article) {
		return null;
	}
}
