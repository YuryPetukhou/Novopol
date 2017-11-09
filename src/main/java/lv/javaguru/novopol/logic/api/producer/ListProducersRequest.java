package lv.javaguru.novopol.logic.api.producer;

import java.util.List;

import lv.javaguru.novopol.domain.Producer;

public class ListProducersRequest {
	private final List<Producer> producer;

	public ListProducersRequest(List<Producer> producer) {
		super();
		this.producer = producer;
	}

	public List<Producer> getProducer() {
		return producer;
	}
}
