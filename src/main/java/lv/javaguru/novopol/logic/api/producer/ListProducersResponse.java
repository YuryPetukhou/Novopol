package lv.javaguru.novopol.logic.api.producer;

import java.util.List;

import lv.javaguru.novopol.domain.Producer;

public class ListProducersResponse {
	private final List<Producer> producers;

	public ListProducersResponse(List<Producer> producers) {
		super();
		this.producers = producers;
	}

	public List<Producer> getProducer() {
		return producers;
	}
}
