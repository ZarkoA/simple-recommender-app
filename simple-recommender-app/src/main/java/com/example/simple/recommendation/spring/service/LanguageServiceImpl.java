package com.example.simple.recommendation.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simple.recommendation.spring.dao.LanguageDao;
import com.example.simple.recommendation.spring.entity.Language;

@Service
public class LanguageServiceImpl implements LanguageService {
	
	@Autowired
	private LanguageDao languageDao;

	@Transactional
	@Override
	public void addLanguage(Language language) {
		languageDao.add(language);
	}

	@Transactional
	@Override
	public Language getLanguageByKey(String languageKey) {
		return languageDao.getLanguageByKey(languageKey);
	}

	@Transactional
	@Override
	public List<Language> listLanguages() {
		return languageDao.listLanguages();
	}

}
