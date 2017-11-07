package lv.javaguru.novopol.logic.service.news.impl;

import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.dal.dao.impl.NewsDAOImpl;
import lv.javaguru.novopol.logic.api.news.ListNewsRequest;
import lv.javaguru.novopol.logic.api.news.ListNewsResponse;
import lv.javaguru.novopol.logic.service.news.ListNewsService;

public class ListNewsServiceImpl implements ListNewsService {

private NewsDAO dao = new NewsDAOImpl();
	
	@Override
	public ListNewsResponse getNews(ListNewsRequest request) {
		return new ListNewsResponse(dao.getAllNews());
	}

}
