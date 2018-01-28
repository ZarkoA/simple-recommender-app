package com.example.simple.recommendation.spring.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "KEYWORD", 
		uniqueConstraints = @UniqueConstraint(columnNames={"CONTENT", "LANGUAGE_KEY"}))
public class Keyword {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true)
	private long keywordId;
	
	@Column(name = "CONTENT")
	private String content;
	
	@OneToOne
	@JoinColumn(name = "LANGUAGE_KEY")
	private Language language;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy="keywords")
	private List<Article> articles;

	public Long getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	public Keyword() {
	}
	
	public Keyword(String keyword, Language language) {
		this.content = keyword;
		this.language = language;
	}
	
	public Keyword(String content, Language language, List<Article> articles) {
		this.content = content;
		this.articles = articles;
	}
}
