package lv.javaguru.novopol.logic.service.article.impl;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.logic.api.article.ListArticlesRequest;
import lv.javaguru.novopol.logic.api.article.ListArticlesResponse;
import lv.javaguru.novopol.logic.service.article.ListArticlesService;

public class ListArticleServiceImpl implements ListArticlesService {

	private ArticleDAO dao = new ArticleDAOImpl();
	
	@Override
	public ListArticlesResponse getArticles(ListArticlesRequest request) {
		return new ListArticlesResponse(dao.getAllArticles());
	}

}
