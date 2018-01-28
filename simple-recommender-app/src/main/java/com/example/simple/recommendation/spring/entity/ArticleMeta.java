package com.example.simple.recommendation.spring.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICLE_META")
public class ArticleMeta {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true)
	private long articleMetaId;
	
	@OneToOne
	@JoinColumn(name = "LANGUAGE_KEY")
	private Language language;
	
	@Column
	private long contentLength;
	
	@Column
	private int keywordsInArticle;
	
	@Column
	private int keywordsSpecifiedNumber;
	
	@OneToOne
	@JoinColumn(name = "ID", unique = true)
	private Category category;

	public long getArticleMetaId() {
		return articleMetaId;
	}

	public void setArticleMetaId(long articleMetaId) {
		this.articleMetaId = articleMetaId;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public int getKeywordsInArticle() {
		return keywordsInArticle;
	}

	public void setKeywordsInArticle(int keywordsInArticle) {
		this.keywordsInArticle = keywordsInArticle;
	}

	public int getKeywordsSpecifiedNumber() {
		return keywordsSpecifiedNumber;
	}

	public void setKeywordsSpecifiedNumber(int keywordsSpecifiedNumber) {
		this.keywordsSpecifiedNumber = keywordsSpecifiedNumber;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ArticleMeta() {
	}
	
	public ArticleMeta(
			Language language, 
			long contentLength, 
			int keywordsInArticle,
			int keywordsSpecifiedNumber, 
			Category category) {
		
		this.language = language;
		this.contentLength = contentLength;
		this.keywordsInArticle = keywordsInArticle;
		this.keywordsSpecifiedNumber = keywordsSpecifiedNumber;
		this.category = category;
	}
}
