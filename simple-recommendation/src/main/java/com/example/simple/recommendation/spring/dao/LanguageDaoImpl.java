package com.example.simple.recommendation.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.simple.recommendation.spring.entity.Language;

@Repository
public class LanguageDaoImpl implements LanguageDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Language language) {
		sessionFactory.getCurrentSession().save(language);
	}

	@Override
	public Language getLanguageByKey(String languageKey) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("from Language as L where L.languageKey = :languageKey");
		query.setParameter("languageKey", languageKey);
		
		return (Language) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Language> listLanguages() {
		return sessionFactory.getCurrentSession().createQuery("from Language").list();
	}
}
