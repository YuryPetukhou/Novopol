package lv.javaguru.novopol.logic.api.article;

import lv.javaguru.novopol.domain.Article;

public class AddArticleRequest {
	private final Article article;

	public AddArticleRequest(Article article) {
		this.article = article;
	}
	
	public Article getArticle() {
		return article;
	}

}
