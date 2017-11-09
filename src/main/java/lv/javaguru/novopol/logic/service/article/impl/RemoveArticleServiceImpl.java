package lv.javaguru.novopol.logic.service.article.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.logic.api.article.RemoveArticleRequest;
import lv.javaguru.novopol.logic.api.article.RemoveArticleResponse;
import lv.javaguru.novopol.logic.service.article.RemoveArticleService;

@Component
public class RemoveArticleServiceImpl implements RemoveArticleService {
	@Autowired
	private ArticleDAO dao;
	
	@Override
	public RemoveArticleResponse removeArticle(RemoveArticleRequest request) {
		return new RemoveArticleResponse(dao.removeArticle(request.getId()));
	}

}
