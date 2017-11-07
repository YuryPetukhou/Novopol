package lv.javaguru.novopol.logic.api.collection;

import lv.javaguru.novopol.domain.Collection;

public class AddCollectionResponse {
	private final Collection collection;

	public AddCollectionResponse (Collection collection) {
		super();
		this.collection = collection;
	}

	public Collection getCollection() {
		return collection;
	}
}
