package lv.javaguru.novopol.logic.api.collection;

import lv.javaguru.novopol.domain.Collection;

public class UpdateCollectionRequest {
	private final Collection article;

	public UpdateCollectionRequest(Collection article) {
		this.article = article;
	}
	
	public Collection getCollection() {
		return article;
	}
}
