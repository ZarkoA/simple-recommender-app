package com.example.simple.recommendation.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.simple.recommendation.spring.dao.KeywordDao;
import com.example.simple.recommendation.spring.entity.Keyword;

@Service
public class KeywordServiceImpl implements KeywordService {

	@Autowired
	private KeywordDao keywordDao;
	
	@Transactional
	@Override
	public void addKeyword(Keyword keyword) {
		keywordDao.addKeyword(keyword);
	}

	@Transactional
	@Override
	public int getArticleKeywordCount(long articleId) {
		return keywordDao.getArticleKeywordCount(articleId);
	}

	@Transactional
	@Override
	public List<Keyword> listKeywords() {
		return keywordDao.listKeywords();
	}

	@Transactional
	@Override
	public List<Keyword> listArticleKeywords(long articleId) {
		return keywordDao.listArticleKeywords(articleId);
	}
}
