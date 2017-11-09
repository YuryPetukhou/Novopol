package lv.javaguru.novopol.logic.service.news.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.logic.api.news.RemoveNewsRequest;
import lv.javaguru.novopol.logic.api.news.RemoveNewsResponse;
import lv.javaguru.novopol.logic.service.news.RemoveNewsService;

@Component
public class RemoveNewsServiceImpl implements RemoveNewsService {
	@Autowired
	private NewsDAO dao;

	@Override
	public RemoveNewsResponse removeNews(RemoveNewsRequest request) {
		return new RemoveNewsResponse(dao.removeNews(request.getId()));
	}

}
