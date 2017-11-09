package lv.javaguru.novopol.logic.service.collection.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.CollectionDAO;
import lv.javaguru.novopol.logic.api.collection.AddCollectionRequest;
import lv.javaguru.novopol.logic.api.collection.AddCollectionResponse;
import lv.javaguru.novopol.logic.service.collection.AddCollectionService;

@Component
public class AddCollectionServiceImpl implements AddCollectionService {
	@Autowired
	private CollectionDAO dao;
	
	@Override
	public AddCollectionResponse addCollection(AddCollectionRequest request) {
		return new AddCollectionResponse(dao.addCollection(request.getCollection()));
	}

}
