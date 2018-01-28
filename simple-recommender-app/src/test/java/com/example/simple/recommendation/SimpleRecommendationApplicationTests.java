package com.example.simple.recommendation;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.simple.recommendation.database.DataLoader;
import com.example.simple.recommendation.database.DataLoaderImpl;
import com.example.simple.recommendation.recommend.LanguageRecommendation;
import com.example.simple.recommendation.spring.config.AppConfig;
import com.example.simple.recommendation.spring.entity.Article;
import com.example.simple.recommendation.spring.service.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleRecommendationApplicationTests {
	
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private LanguageRecommendation recommender;

	private List<Article> articles;
	
	@BeforeClass
	public static void loadData() {
		context = new AnnotationConfigApplicationContext(AppConfig.class);

		DataLoader loader = new DataLoaderImpl(context);
		loader.loadData();
	}
	
	@AfterClass
	public static void closeContext() {
		context.close();
	}
	
	@Test
	public void articlesExist() {
		articles = articleService.listArticles();
		assertTrue(articles.size() > 0);
	}
	
	@Test
	public void recommend() {

		Article article = articleService.getArticle(1);
		assertTrue(article != null);
		List<String> recommended = recommender.recommend(article);
		assertTrue(recommended.size() > 0);
	}
}
