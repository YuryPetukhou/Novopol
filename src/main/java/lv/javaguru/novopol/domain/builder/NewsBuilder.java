package lv.javaguru.novopol.domain.builder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.News;

public class NewsBuilder {
	private String text;
	private String header;
	private String author;
	private String summary;
	private String source;
	private LocalDateTime postDate;
	private List<String> keywords;
	private UUID id;
	private LocalDateTime createdDateTime;
	private LocalDateTime updatedDateTime;
	private String createdBy;
	private String updatedBy;
	
	public static NewsBuilder createNews() {
		return new NewsBuilder();
	}
	
	public NewsBuilder withContent(String text) {
		this.text = text;
		return this;
	}
	public NewsBuilder withHeader(String header) {
		this.header = header;
		return this;
	}
	public NewsBuilder withAuthor(String author) {
		this.author = author;
		return this;
	}
	public NewsBuilder withSource(String source) {
		this.text = source;
		return this;
	}
	public NewsBuilder withSummary(String summary) {
		this.summary = summary;
		return this;
	}
	public NewsBuilder withPostDate(LocalDateTime postDate) {
		this.postDate = postDate;
		return this;
	}
	public NewsBuilder withKeywords(List<String> keywords) {
		this.keywords = keywords;
		return this;
	}
	
	public NewsBuilder withId(UUID id) {
		this.id = id;
		return this;
	}
	public NewsBuilder withCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
		return this;
	}
	public NewsBuilder withupdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
		return this;
	}
	public NewsBuilder withcreatedBy(String createdBy) {
		this.createdBy = createdBy;
		return this;
	}
	public NewsBuilder withupdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}
	
	public News build() {
		News news = new News();
		news.setId(id);
		news.setCreatedDateTime(createdDateTime);
		news.setUpdatedDateTime(updatedDateTime);
		news.setCreatedBy(createdBy);
		news.setUpdatedBy(updatedBy);
		news.setAuthor(author);
		news.setHeader(header);
		news.setKeywords(keywords);
		news.setPostDate(postDate);
		news.setSource(source);
		news.setSummary(summary);
		news.setText(text);
		return news;
	}

}
