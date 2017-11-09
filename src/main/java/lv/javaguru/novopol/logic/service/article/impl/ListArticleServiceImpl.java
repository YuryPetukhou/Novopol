package lv.javaguru.novopol.logic.service.article.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.logic.api.article.ListArticlesRequest;
import lv.javaguru.novopol.logic.api.article.ListArticlesResponse;
import lv.javaguru.novopol.logic.service.article.ListArticlesService;

@Component
public class ListArticleServiceImpl implements ListArticlesService {
	@Autowired
	private ArticleDAO dao;
	
	@Override
	public ListArticlesResponse getArticles(ListArticlesRequest request) {
		return new ListArticlesResponse(dao.getAllArticles());
	}

}
