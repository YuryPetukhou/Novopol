package lv.javaguru.novopol.logic.api.producer;

import lv.javaguru.novopol.domain.Producer;

public class AddProducerRequest {
	private final Producer collection;

	public AddProducerRequest(Producer collection) {
		super();
		this.collection = collection;
	}

	public Producer getProducer() {
		return collection;
	}
}
