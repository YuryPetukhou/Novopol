package lv.javaguru.novopol.logic.service.collection;

import lv.javaguru.novopol.logic.api.collection.AddCollectionRequest;
import lv.javaguru.novopol.logic.api.collection.AddCollectionResponse;

public interface AddCollectionService {
	
	AddCollectionResponse addCollection(AddCollectionRequest request);


}
