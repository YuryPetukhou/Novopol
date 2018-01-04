package lv.javaguru.novopol.domain.builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.Article;
import lv.javaguru.novopol.domain.Keyword;

public class ArticleBuilder {

	private String content;
	private String header;
	private String author;
	private String summary;
	private String source;
	private LocalDateTime postDate;
	private List<Keyword> keywords;
	private UUID id;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	private String createdBy;
	private String updatedBy;
	
	public static ArticleBuilder createArticle() {
		return new ArticleBuilder();
	}
	
	public ArticleBuilder withContent(String text) {
		this.content = text;
		return this;
	}
	public ArticleBuilder withHeader(String header) {
		this.header = header;
		return this;
	}
	public ArticleBuilder withAuthor(String author) {
		this.author = author;
		return this;
	}
	public ArticleBuilder withSource(String source) {
		this.source = source;
		return this;
	}
	public ArticleBuilder withSummary(String summary) {
		this.summary = summary;
		return this;
	}
	public ArticleBuilder withPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
		return this;
	}
	public ArticleBuilder withId(UUID id) {
		this.id = id;
		return this;
	}
	public ArticleBuilder withCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}
	public ArticleBuilder withupdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
		return this;
	}
	public ArticleBuilder withcreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public ArticleBuilder withupdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}
	public ArticleBuilder withKeywords(List<Keyword> keywords) {
		this.keywords = keywords;
		return this;
	}
	
	public Article build() {
		Article article = new Article();
		article.setId(id);
		article.setCreatedDateTime(createdDateTime);
		article.setUpdatedDateTime(updatedDateTime);
		article.setCreatedBy(createdBy);
		article.setUpdatedBy(updatedBy);
		article.setAuthor(author);
		article.setHeader(header);
		article.setKeywords(keywords);
		article.setPostDate(postDate);
		article.setSource(source);
		article.setSummary(summary);
		article.setText(content);
		return article;
	}
}
