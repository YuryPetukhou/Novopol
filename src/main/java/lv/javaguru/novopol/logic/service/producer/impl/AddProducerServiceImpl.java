package lv.javaguru.novopol.logic.service.producer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ProducerDAO;
import lv.javaguru.novopol.logic.api.producer.AddProducerRequest;
import lv.javaguru.novopol.logic.api.producer.AddProducerResponse;
import lv.javaguru.novopol.logic.service.producer.AddProducerService;

@Component
public class AddProducerServiceImpl implements AddProducerService {
	@Autowired
	private ProducerDAO dao ;

	@Override
	public AddProducerResponse addProducer(AddProducerRequest request) {
		return new AddProducerResponse(dao.addProducer(request.getProducer()));
	}
}
