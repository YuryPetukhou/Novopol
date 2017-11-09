package lv.javaguru.novopol.logic.service.news.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.logic.api.news.UpdateNewsRequest;
import lv.javaguru.novopol.logic.api.news.UpdateNewsResponse;
import lv.javaguru.novopol.logic.service.news.UpdateNewsService;

@Component
public class UpdateNewsServiceImpl implements UpdateNewsService {
	@Autowired
	private NewsDAO dao;

	@Override
	public UpdateNewsResponse updateNews(UpdateNewsRequest request) {
		return new UpdateNewsResponse(dao.updateNews(request.getNews()));
	}

}
