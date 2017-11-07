package lv.javaguru.novopol.logic.service.news.impl;

import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.dal.dao.impl.NewsDAOImpl;
import lv.javaguru.novopol.logic.api.news.RemoveNewsRequest;
import lv.javaguru.novopol.logic.api.news.RemoveNewsResponse;
import lv.javaguru.novopol.logic.service.news.RemoveNewsService;

public class RemoveNewsServiceImpl implements RemoveNewsService {

private NewsDAO dao = new NewsDAOImpl();
	
	@Override
	public RemoveNewsResponse removeNews(RemoveNewsRequest request) {
		return new RemoveNewsResponse(dao.removeNews(request.getId()));
	}

}
