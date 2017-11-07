package lv.javaguru.novopol.logic.service.article.impl;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.logic.api.article.UpdateArticleRequest;
import lv.javaguru.novopol.logic.api.article.UpdateArticleResponse;
import lv.javaguru.novopol.logic.service.article.UpdateArticleService;

public class UpdateArticleServiceImpl implements UpdateArticleService {

	private ArticleDAO dao = new ArticleDAOImpl();
	
	@Override
	public UpdateArticleResponse updateArticle(UpdateArticleRequest request) {
		return new UpdateArticleResponse(dao.updateArticle(request.getArticle()));
	}

}
