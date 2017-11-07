package lv.javaguru.novopol.logic.service.producer.impl;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.ProducerDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.dal.dao.impl.ProducerDAOImpl;
import lv.javaguru.novopol.logic.api.article.ListArticlesRequest;
import lv.javaguru.novopol.logic.api.article.ListArticlesResponse;
import lv.javaguru.novopol.logic.api.producer.ListProducersRequest;
import lv.javaguru.novopol.logic.api.producer.ListProducersResponse;
import lv.javaguru.novopol.logic.service.producer.ListProducersService;

public class ListProducersServiceImpl implements ListProducersService {

private ProducerDAO dao = new ProducerDAOImpl();
	
	@Override
	public ListProducersResponse getProducers(ListProducersRequest request) {
		return new ListProducersResponse(dao.getAllProducers());
	}
}
