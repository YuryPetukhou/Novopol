package lv.javaguru.novopol.logic.api.article;

import java.util.List;

import lv.javaguru.novopol.domain.Article;

public class ListArticlesResponse {
	private final List<Article> articles;

	public ListArticlesResponse (List<Article> articles) {
		this.articles = articles;
	}

	public List<Article> getArticles() {
		return articles;
	}
	
}
