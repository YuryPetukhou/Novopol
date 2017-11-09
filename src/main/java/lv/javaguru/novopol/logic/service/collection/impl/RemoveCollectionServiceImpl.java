package lv.javaguru.novopol.logic.service.collection.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.CollectionDAO;
import lv.javaguru.novopol.dal.dao.impl.CollectionDAOImpl;
import lv.javaguru.novopol.logic.api.collection.RemoveCollectionRequest;
import lv.javaguru.novopol.logic.api.collection.RemoveCollectionResponse;
import lv.javaguru.novopol.logic.service.collection.RemoveCollectionService;

@Component
public class RemoveCollectionServiceImpl implements RemoveCollectionService {
	@Autowired
	private CollectionDAO dao;
	
	@Override
	public RemoveCollectionResponse removeCollection(RemoveCollectionRequest request) {
		return new RemoveCollectionResponse(dao.removeCollection(request.getId()));
	}

}
