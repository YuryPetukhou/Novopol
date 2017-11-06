package lv.javaguru.novopol.logic.service.collection;

import lv.javaguru.novopol.logic.api.collection.UpdateCollectionRequest;
import lv.javaguru.novopol.logic.api.collection.UpdateCollectionResponse;

public interface UpdateCollectionService {
	UpdateCollectionResponse updateCollection (UpdateCollectionRequest request);
}
