package com.example.simple.recommendation.spring.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "LANGUAGE",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"LANGUAGE_KEY"})}
)
public class Language {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true)
	private long languageId;

	@Column(name = "LANGUAGE_KEY", unique = true)
	private String languageKey;

	@Column(name = "DESCRIPTION")
	private String description;
	
	public String getLanguageKey() {
		return languageKey;
	}

	public void setLanguageKey(String languageKey) {
		this.languageKey = languageKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getLanguageId() {
		return languageId;
	}

	public void setLanguageId(long languageId) {
		this.languageId = languageId;
	}
	
	public Language() {
	}

	public Language(String languageKey, String description) {
		this.languageKey = languageKey;
		this.description = description;
	}
}
