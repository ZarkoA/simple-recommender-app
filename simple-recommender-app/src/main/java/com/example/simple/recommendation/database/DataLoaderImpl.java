package com.example.simple.recommendation.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.simple.recommendation.spring.entity.Article;
import com.example.simple.recommendation.spring.entity.ArticleMeta;
import com.example.simple.recommendation.spring.entity.Category;
import com.example.simple.recommendation.spring.entity.Keyword;
import com.example.simple.recommendation.spring.entity.Language;
import com.example.simple.recommendation.spring.service.ArticleMetaService;
import com.example.simple.recommendation.spring.service.ArticleService;
import com.example.simple.recommendation.spring.service.CategoryService;
import com.example.simple.recommendation.spring.service.KeywordService;
import com.example.simple.recommendation.spring.service.LanguageService;

public class DataLoaderImpl implements DataLoader {

	private ArticleService articleService;
	private KeywordService keywordService;
	private LanguageService languageService;
	private CategoryService categoryService;
	private ArticleMetaService articleMetaService;
	private AnnotationConfigApplicationContext context;

	public DataLoaderImpl(AnnotationConfigApplicationContext newContext) {

		context = newContext;

		articleService = context.getBean(ArticleService.class);
		keywordService = context.getBean(KeywordService.class);
		languageService = context.getBean(LanguageService.class);
		categoryService = context.getBean(CategoryService.class);
		articleMetaService = context.getBean(ArticleMetaService.class);
	};

	@Override
	public void loadData() {

		Language english = new Language("EN", "English");
		Language german = new Language("DE", "German");
		Language croatian = new Language("HR", "Croatian");

		Category sport = new Category("Sport");
		Category news = new Category("News");

		// Keyword footballEnglish = new Keyword("Football", "EN");
		// Keyword basketballEnglish = new Keyword("Basketball", "EN");
		// Keyword golfEnglish = new Keyword("Golf", "EN");

		Keyword footballEnglish = new Keyword("Football", english);
		Keyword basketballEnglish = new Keyword("Basketball", english);
		Keyword golfEnglish = new Keyword("Golf", english);
		//
		// Keyword footballEnglish = new Keyword("Football");
		// Keyword basketballEnglish = new Keyword("Basketball");
		// Keyword golfEnglish = new Keyword("Golf");

		Keyword fußballGerman = new Keyword("Fußball", german);
		Keyword basketballGerman = new Keyword("Basketball", german);
		Keyword golfGerman = new Keyword("Golf", german);

		Keyword politicsEnglish = new Keyword("Politics", english);
		Keyword economyEnglish = new Keyword("Economy", english);
		Keyword weatherEnglish = new Keyword("Weather", english);
		Keyword artsEnglish = new Keyword("Arts", english);

		Keyword politicsCroatian = new Keyword("Politika", croatian);
		Keyword economyCroatian = new Keyword("Ekonomija", croatian);
		Keyword weatherCroatian = new Keyword("Vrijeme", croatian);

//		List<Keyword> sportsEnglishKeywords = new ArrayList<Keyword>(Arrays.asList(footballEnglish, basketballEnglish, golfEnglish));
		List<Keyword> sportsGermanKeywords = new ArrayList<Keyword>(Arrays.asList(fußballGerman, basketballGerman, golfGerman));
		List<Keyword> newsEnglishKeywords = new ArrayList<Keyword>(Arrays.asList(politicsEnglish, economyEnglish, weatherEnglish, artsEnglish));
		List<Keyword> newsCroatianKeywords = new ArrayList<Keyword>(Arrays.asList(politicsCroatian, economyCroatian, weatherCroatian));

		Article sportEnglish = new Article("Sports", "C_01", english, "Sport is good...", sport);
		Article sportGerman = new Article("Sport", "C_01", german, "Sport ist super...", sport, sportsGermanKeywords);
		Article newsEnglish = new Article("News", "C_02", english, "Todays News...", news, newsEnglishKeywords);
		Article newsCroatian = new Article("Novosti", "C_02", croatian, "Novosti danas...", news, newsCroatianKeywords);

		ArticleMeta sportImprovementEnglish = new ArticleMeta(english, 500, 5, 5, sport);
		ArticleMeta sportImprovementGerman = new ArticleMeta(german, 400, 7, 5, news);
		ArticleMeta newsImprovementCroatian = new ArticleMeta(croatian, 750, 6, 5, news);
		ArticleMeta newsImprovementEnglish = new ArticleMeta(english, 900, 5, 3, news);

		languageService.addLanguage(english);
		languageService.addLanguage(german);
		languageService.addLanguage(croatian);

		categoryService.addCategory(sport);
		categoryService.addCategory(news);

		articleService.addArticle(sportEnglish);
		articleService.addArticle(sportGerman);
		articleService.addArticle(newsEnglish);
		articleService.addArticle(newsCroatian);

		keywordService.addKeyword(footballEnglish);
		keywordService.addKeyword(basketballEnglish);
		keywordService.addKeyword(golfEnglish);

//		keywordService.addKeyword(fußballGerman);
//		keywordService.addKeyword(basketballGerman);
//		keywordService.addKeyword(golfGerman);
//		keywordService.addKeyword(politicsEnglish);
//		keywordService.addKeyword(economyEnglish);
//		keywordService.addKeyword(weatherEnglish);
//		keywordService.addKeyword(artsEnglish);
//		keywordService.addKeyword(politicsCroatian);
//		keywordService.addKeyword(economyCroatian);
//		keywordService.addKeyword(weatherCroatian);
		
		articleMetaService.addArticleMeta(sportImprovementEnglish);
		articleMetaService.addArticleMeta(sportImprovementGerman);
		articleMetaService.addArticleMeta(newsImprovementCroatian);
		articleMetaService.addArticleMeta(newsImprovementEnglish);
	}
}
