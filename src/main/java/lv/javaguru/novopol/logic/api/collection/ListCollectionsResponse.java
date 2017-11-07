package lv.javaguru.novopol.logic.api.collection;

import java.util.List;

import lv.javaguru.novopol.domain.Collection;

public class ListCollectionsResponse {
	private final List<Collection> collections;

	public ListCollectionsResponse(List<Collection> collections) {
		super();
		this.collections = collections;
	}

	public List<Collection> getCollection() {
		return collections;
	}
}
