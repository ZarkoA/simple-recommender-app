package com.example.simple.recommendation.spring.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ARTICLE",
	uniqueConstraints = @UniqueConstraint(columnNames={"ARTICLE_CODE", "LANGUAGE_KEY"})
)
public class Article {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true)
	private Long articleId;

	@Column(name = "ARTICLE_CODE")
	private String articleCode; //identifying same article in different languages
	
	@Column(name = "TITLE")
	private String title;
	
	@OneToOne
	@JoinColumn(name = "LANGUAGE_KEY")
	private Language language;
	
	@Column(name = "CONTENT")
	private String content;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "articles")
	private Category category;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="ARTICLE_KEYWORD", 
			joinColumns = @JoinColumn(name = "ARTICLE_ID"), 
			inverseJoinColumns = @JoinColumn(name = "KEYWORD_ID"))
	private List<Keyword> keywords;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public String getArticleCode() {
		return articleCode;
	}

	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public List<Keyword> getKeyworsInArticle() {
		return keywords;
	}

	public void setKeywordsInArticle(List<Keyword> keywords) {
		this.keywords = keywords;
	}
	
	public int getKeywordCount() {
		return keywords.size();
	}

	public Article() {
	}
	
	public Article(String title, String articleCode, Language language, String content, Category category) {
		this.title = title;
		this.articleCode = articleCode;
		this.language = language;
		this.content = content;
		this.category = category;
	}

	public Article(String title, String articleCode, Language language, String content, Category category, List<Keyword> keywords) {
		this.title = title;
		this.articleCode = articleCode;
		this.language = language;
		this.content = content;
		this.category = category;
		this.keywords = keywords;
	}
}
