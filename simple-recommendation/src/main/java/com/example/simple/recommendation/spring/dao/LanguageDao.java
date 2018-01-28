package com.example.simple.recommendation.spring.dao;

import java.util.List;

import com.example.simple.recommendation.spring.entity.Language;

public interface LanguageDao {

	public void add(Language language);
	public Language getLanguageByKey(String languageKey);
	public List<Language> listLanguages();
}
