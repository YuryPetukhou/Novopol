package lv.javaguru.novopol.logic.service.article;

import lv.javaguru.novopol.logic.api.article.ListArticlesRequest;
import lv.javaguru.novopol.logic.api.article.ListArticlesResponse;

public interface ListArticlesService {
	ListArticlesResponse getArticles (ListArticlesRequest request);
}
