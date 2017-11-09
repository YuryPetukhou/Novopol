package lv.javaguru.novopol.logic.service.producer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ProducerDAO;
import lv.javaguru.novopol.logic.api.producer.ListProducersRequest;
import lv.javaguru.novopol.logic.api.producer.ListProducersResponse;
import lv.javaguru.novopol.logic.service.producer.ListProducersService;

@Component
public class ListProducersServiceImpl implements ListProducersService {
	@Autowired
	private ProducerDAO dao;

	@Override
	public ListProducersResponse getProducers(ListProducersRequest request) {
		return new ListProducersResponse(dao.getAllProducers());
	}
}
