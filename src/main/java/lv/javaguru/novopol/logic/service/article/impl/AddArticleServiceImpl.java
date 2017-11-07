package lv.javaguru.novopol.logic.service.article.impl;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.logic.api.article.AddArticleRequest;
import lv.javaguru.novopol.logic.api.article.AddArticleResponse;
import lv.javaguru.novopol.logic.service.article.AddArticleService;

public class AddArticleServiceImpl implements AddArticleService {

	private ArticleDAO dao = new ArticleDAOImpl();
	
	@Override
	public AddArticleResponse addArticle(AddArticleRequest request) {
		return new AddArticleResponse(dao.addArticle(request.getArticle()).getId());
	}

}
