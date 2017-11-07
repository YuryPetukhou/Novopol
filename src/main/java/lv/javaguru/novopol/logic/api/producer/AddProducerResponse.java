package lv.javaguru.novopol.logic.api.producer;

import lv.javaguru.novopol.domain.Producer;

public class AddProducerResponse {
	private final Producer producer;

	public AddProducerResponse (Producer producer) {
		super();
		this.producer = producer;
	}

	public Producer getProducer() {
		return producer;
	}
}
