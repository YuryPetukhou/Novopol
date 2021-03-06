package lv.javaguru.novopol.logic.service.collection.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.CollectionDAO;
import lv.javaguru.novopol.logic.api.collection.ListCollectionsRequest;
import lv.javaguru.novopol.logic.api.collection.ListCollectionsResponse;
import lv.javaguru.novopol.logic.service.collection.ListCollectionsService;

@Component
public class ListCollectionsServiceImpl implements ListCollectionsService {
	@Autowired
	private CollectionDAO dao ;	
	
	@Override
	public ListCollectionsResponse getCollections(ListCollectionsRequest request) {
		return new ListCollectionsResponse(dao.getAllCollections());
	}

}
