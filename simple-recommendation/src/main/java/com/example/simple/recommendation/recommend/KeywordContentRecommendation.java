package com.example.simple.recommendation.recommend;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.simple.recommendation.spring.entity.Article;

@Component
public class KeywordContentRecommendation implements Recommendable {

	@Override
	public List<String> recommend(Article article) {
		
		//TODO: implement logic based on the keywords found in the content of an article
		
		return null;
	}
}
