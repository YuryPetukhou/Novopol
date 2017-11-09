package lv.javaguru.novopol.logic.service.article.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.logic.api.article.AddArticleRequest;
import lv.javaguru.novopol.logic.api.article.AddArticleResponse;
import lv.javaguru.novopol.logic.service.article.AddArticleService;

@Component
public class AddArticleServiceImpl implements AddArticleService {
	@Autowired
	private ArticleDAO dao;
	
	@Override
	public AddArticleResponse addArticle(AddArticleRequest request) {
		return new AddArticleResponse(dao.addArticle(request.getArticle()).getId());
	}

}
