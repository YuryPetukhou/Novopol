package lv.javaguru.novopol.logic.service.news.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.NewsDAO;
import lv.javaguru.novopol.logic.api.news.AddNewsRequest;
import lv.javaguru.novopol.logic.api.news.AddNewsResponse;
import lv.javaguru.novopol.logic.service.news.AddNewsService;

@Component
public class AddNewsServiceImpl implements AddNewsService {
	@Autowired
	private NewsDAO dao ;

	@Override
	public AddNewsResponse addNews(AddNewsRequest request) {
		return new AddNewsResponse(dao.addNews(request.getNews()).getId());
	}

}
