package lv.javaguru.novopol.logic.api.collection;

import lv.javaguru.novopol.domain.Collection;
import lv.javaguru.novopol.domain.News;

public class AddCollectionRequest {
	private final Collection collection;

	public AddCollectionRequest(Collection collection) {
		super();
		this.collection = collection;
	}

	public Collection getCollection() {
		return collection;
	}
}
