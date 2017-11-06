package lv.javaguru.novopol.logic.service.collection;

import lv.javaguru.novopol.logic.api.collection.ListCollectionsRequest;
import lv.javaguru.novopol.logic.api.collection.ListCollectionsResponse;

public interface ListCollectionsService {
	ListCollectionsResponse getCollections (ListCollectionsRequest request);
}
