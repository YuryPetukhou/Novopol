package lv.javaguru.novopol.logic.service.article.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.logic.api.article.UpdateArticleRequest;
import lv.javaguru.novopol.logic.api.article.UpdateArticleResponse;
import lv.javaguru.novopol.logic.service.article.UpdateArticleService;

@Component
public class UpdateArticleServiceImpl implements UpdateArticleService {
	@Autowired
	private ArticleDAO dao;
	
	@Override
	public UpdateArticleResponse updateArticle(UpdateArticleRequest request) {
		return new UpdateArticleResponse(dao.updateArticle(request.getArticle()));
	}

}
