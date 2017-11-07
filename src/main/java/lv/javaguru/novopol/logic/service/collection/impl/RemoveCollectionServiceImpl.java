package lv.javaguru.novopol.logic.service.collection.impl;

import lv.javaguru.novopol.dal.dao.CollectionDAO;
import lv.javaguru.novopol.dal.dao.impl.CollectionDAOImpl;
import lv.javaguru.novopol.logic.api.collection.RemoveCollectionRequest;
import lv.javaguru.novopol.logic.api.collection.RemoveCollectionResponse;
import lv.javaguru.novopol.logic.service.collection.RemoveCollectionService;

public class RemoveCollectionServiceImpl implements RemoveCollectionService {

	private CollectionDAO dao = new CollectionDAOImpl();
	
	@Override
	public RemoveCollectionResponse removeCollection(RemoveCollectionRequest request) {
		return new RemoveCollectionResponse(dao.removeCollection(request.getId()));
	}

}
