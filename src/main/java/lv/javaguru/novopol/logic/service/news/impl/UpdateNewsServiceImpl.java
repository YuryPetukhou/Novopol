package lv.javaguru.novopol.logic.service.news.impl;

import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.dal.dao.impl.NewsDAOImpl;
import lv.javaguru.novopol.logic.api.news.UpdateNewsRequest;
import lv.javaguru.novopol.logic.api.news.UpdateNewsResponse;
import lv.javaguru.novopol.logic.service.news.UpdateNewsService;

public class UpdateNewsServiceImpl implements UpdateNewsService {

private NewsDAO dao = new NewsDAOImpl();
	
	@Override
	public UpdateNewsResponse updateNews(UpdateNewsRequest request) {
		return new UpdateNewsResponse(dao.updateNews(request.getNews()));
	}


}
