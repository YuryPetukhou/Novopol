package lv.javaguru.novopol.logic.service.producer.impl;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.ProducerDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.dal.dao.impl.ProducerDAOImpl;
import lv.javaguru.novopol.logic.api.article.AddArticleRequest;
import lv.javaguru.novopol.logic.api.article.AddArticleResponse;
import lv.javaguru.novopol.logic.api.producer.AddProducerRequest;
import lv.javaguru.novopol.logic.api.producer.AddProducerResponse;
import lv.javaguru.novopol.logic.service.producer.AddProducerService;

public class AddProducerServiceImpl implements AddProducerService {

private ProducerDAO dao = new ProducerDAOImpl();
	

@Override
public AddProducerResponse addProducer(AddProducerRequest request) {
	return new AddProducerResponse(dao.addProducer(request.getProducer()));
}
}
