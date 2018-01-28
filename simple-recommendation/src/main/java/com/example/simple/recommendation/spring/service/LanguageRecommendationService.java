package com.example.simple.recommendation.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.simple.recommendation.recommend.LanguageRecommendation;
import com.example.simple.recommendation.recommend.Recommendable;
import com.example.simple.recommendation.spring.entity.Article;

@Service
public class LanguageRecommendationService implements RecommendationService {
	
	@Override
	public List<String> recommend(Article article, Recommendable recommendable) {

		LanguageRecommendation languageRecommendation = (LanguageRecommendation) recommendable;
		List<String> recommendedLanguages = languageRecommendation.recommend(article);
		
		return recommendedLanguages;
	}
}
