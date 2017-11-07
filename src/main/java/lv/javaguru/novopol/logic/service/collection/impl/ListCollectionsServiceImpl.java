package lv.javaguru.novopol.logic.service.collection.impl;

import lv.javaguru.novopol.dal.dao.CollectionDAO;
import lv.javaguru.novopol.dal.dao.impl.CollectionDAOImpl;
import lv.javaguru.novopol.logic.api.collection.ListCollectionsRequest;
import lv.javaguru.novopol.logic.api.collection.ListCollectionsResponse;
import lv.javaguru.novopol.logic.service.collection.ListCollectionsService;

public class ListCollectionsServiceImpl implements ListCollectionsService {

	private CollectionDAO dao = new CollectionDAOImpl();	
	
	@Override
	public ListCollectionsResponse getCollections(ListCollectionsRequest request) {
		return new ListCollectionsResponse(dao.getAllCollections());
	}

}
