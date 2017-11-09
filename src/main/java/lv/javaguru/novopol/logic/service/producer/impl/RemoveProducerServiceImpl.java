package lv.javaguru.novopol.logic.service.producer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ProducerDAO;
import lv.javaguru.novopol.logic.api.producer.RemoveProducerRequest;
import lv.javaguru.novopol.logic.api.producer.RemoveProducerResponse;
import lv.javaguru.novopol.logic.service.producer.RemoveProducerService;

@Component
public class RemoveProducerServiceImpl implements RemoveProducerService {

	@Autowired
	private ProducerDAO dao;
	
	@Override
	public RemoveProducerResponse removeProducer(RemoveProducerRequest request) {
		return new RemoveProducerResponse(dao.removeProducer(request.getId()));
	}

}
