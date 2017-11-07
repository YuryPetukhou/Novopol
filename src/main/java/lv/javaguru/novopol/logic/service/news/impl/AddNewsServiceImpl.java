package lv.javaguru.novopol.logic.service.news.impl;

import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.dal.dao.impl.NewsDAOImpl;
import lv.javaguru.novopol.logic.api.news.AddNewsRequest;
import lv.javaguru.novopol.logic.api.news.AddNewsResponse;
import lv.javaguru.novopol.logic.service.news.AddNewsService;

public class AddNewsServiceImpl implements AddNewsService {

private NewsDAO dao = new NewsDAOImpl();
	
	@Override
	public AddNewsResponse addNews(AddNewsRequest request) {
		return new AddNewsResponse(dao.addNews(request.getNews()).getId());
	}

}
