package lv.javaguru.novopol.logic.service.news.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.logic.api.news.ListNewsRequest;
import lv.javaguru.novopol.logic.api.news.ListNewsResponse;
import lv.javaguru.novopol.logic.service.news.ListNewsService;

@Component
public class ListNewsServiceImpl implements ListNewsService {
	@Autowired
	private NewsDAO dao;

	@Override
	public ListNewsResponse getNews(ListNewsRequest request) {
		return new ListNewsResponse(dao.getAllNews());
	}

}
