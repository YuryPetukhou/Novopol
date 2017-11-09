package lv.javaguru.novopol.logic.service.collection.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.CollectionDAO;
import lv.javaguru.novopol.logic.api.collection.UpdateCollectionRequest;
import lv.javaguru.novopol.logic.api.collection.UpdateCollectionResponse;
import lv.javaguru.novopol.logic.service.collection.UpdateCollectionService;

@Component
public class UpdateCollectionServiceImpl implements UpdateCollectionService{
	@Autowired
	private CollectionDAO dao ;
	
	@Override
	public UpdateCollectionResponse updateCollection(UpdateCollectionRequest request) {
		return new UpdateCollectionResponse (dao.removeCollection(request.getCollection()));
	}

}
