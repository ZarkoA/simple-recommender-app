package com.example.simple.recommendation.recommend;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.simple.recommendation.spring.entity.Article;
import com.example.simple.recommendation.spring.entity.Language;
import com.example.simple.recommendation.spring.service.ArticleService;

@Component
public class LanguageRecommendation implements Recommendable {

	@Autowired
	private ArticleService articleService;
	
	@Override
	public List<String> recommend(Article article) {

		List<String> missingLanguages = articleService.listMissingLanguages(article)
				.stream()
				.map(Language::getDescription)
				.collect(Collectors.toList());
		
		System.out.println("Missing languages for the article: " + article.getTitle() + " are: ");
		missingLanguages.forEach(System.out::println);
		
		return missingLanguages;
	}
 }