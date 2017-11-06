package lv.javaguru.novopol.logic.service.collection;

import lv.javaguru.novopol.logic.api.collection.RemoveCollectionRequest;
import lv.javaguru.novopol.logic.api.collection.RemoveCollectionResponse;

public interface RemoveCollectionService {
	RemoveCollectionResponse removeCollection (RemoveCollectionRequest request);
}
