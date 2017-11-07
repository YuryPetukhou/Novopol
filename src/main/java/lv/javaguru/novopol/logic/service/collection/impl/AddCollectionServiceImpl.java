package lv.javaguru.novopol.logic.service.collection.impl;

import lv.javaguru.novopol.dal.dao.ArticleDAO;
import lv.javaguru.novopol.dal.dao.CollectionDAO;
import lv.javaguru.novopol.dal.dao.impl.ArticleDAOImpl;
import lv.javaguru.novopol.dal.dao.impl.CollectionDAOImpl;
import lv.javaguru.novopol.logic.api.collection.AddCollectionRequest;
import lv.javaguru.novopol.logic.api.collection.AddCollectionResponse;
import lv.javaguru.novopol.logic.service.collection.AddCollectionService;

public class AddCollectionServiceImpl implements AddCollectionService {

	private CollectionDAO dao = new CollectionDAOImpl();
	
	@Override
	public AddCollectionResponse addCollection(AddCollectionRequest request) {
		return new AddCollectionResponse(dao.addCollection(request.getCollection()));
	}

}
