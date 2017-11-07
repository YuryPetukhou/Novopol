package lv.javaguru.novopol.logic.service.article.impl;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.logic.api.article.RemoveArticleRequest;
import lv.javaguru.novopol.logic.api.article.RemoveArticleResponse;
import lv.javaguru.novopol.logic.service.article.RemoveArticleService;

public class RemoveArticleServiceImpl implements RemoveArticleService {

	private ArticleDAO dao = new ArticleDAOImpl();
	
	@Override
	public RemoveArticleResponse removeArticle(RemoveArticleRequest request) {
		return new RemoveArticleResponse(dao.removeArticle(request.getId()));
	}

}
