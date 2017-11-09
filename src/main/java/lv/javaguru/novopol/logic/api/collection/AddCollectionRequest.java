package lv.javaguru.novopol.logic.api.collection;

import lv.javaguru.novopol.domain.Collection;

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
