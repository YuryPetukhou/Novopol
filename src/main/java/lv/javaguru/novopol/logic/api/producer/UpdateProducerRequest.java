package lv.javaguru.novopol.logic.api.producer;

import lv.javaguru.novopol.domain.Producer;

public class UpdateProducerRequest {
	private final Producer article;

	public UpdateProducerRequest(Producer article) {
		this.article = article;
	}
	
	public Producer getProducer() {
		return article;
	}
}
