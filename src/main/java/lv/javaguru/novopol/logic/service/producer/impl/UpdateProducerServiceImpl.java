package lv.javaguru.novopol.logic.service.producer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ProducerDAO;
import lv.javaguru.novopol.logic.api.producer.UpdateProducerRequest;
import lv.javaguru.novopol.logic.api.producer.UpdateProducerResponse;
import lv.javaguru.novopol.logic.service.producer.UpdateProducerService;

@Component
public class UpdateProducerServiceImpl implements UpdateProducerService {
	
	@Autowired
	private ProducerDAO dao;
	
	@Override
	public UpdateProducerResponse updateProducer(UpdateProducerRequest request) {
		return new UpdateProducerResponse(dao.updateProducer(request.getProducer()));
	}

}
