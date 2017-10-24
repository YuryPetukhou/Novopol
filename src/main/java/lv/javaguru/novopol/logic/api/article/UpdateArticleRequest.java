package lv.javaguru.novopol.logic.api.article;

import lv.javaguru.novopol.domain.Article;

public class UpdateArticleRequest {
	private final Article article;

	public UpdateArticleRequest(Article article) {
		this.article = article;
	}
	
	public Article getArticle() {
		return article;
	}

}
