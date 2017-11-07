package lv.javaguru.novopol.logic.service.collection.impl;

import lv.javaguru.novopol.dal.dao.CollectionDAO;
import lv.javaguru.novopol.dal.dao.impl.CollectionDAOImpl;
import lv.javaguru.novopol.logic.api.collection.UpdateCollectionRequest;
import lv.javaguru.novopol.logic.api.collection.UpdateCollectionResponse;
import lv.javaguru.novopol.logic.service.collection.UpdateCollectionService;

public class UpdateCollectionServiceImpl implements UpdateCollectionService{

	private CollectionDAO dao = new CollectionDAOImpl();
	
	@Override
	public UpdateCollectionResponse updateCollection(UpdateCollectionRequest request) {
		return new UpdateCollectionResponse (dao.removeCollection(request.getCollection()));
	}

}
