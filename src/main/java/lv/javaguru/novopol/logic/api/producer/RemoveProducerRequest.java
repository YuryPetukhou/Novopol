package lv.javaguru.novopol.logic.api.producer;

import java.util.UUID;

public class RemoveProducerRequest {
	private final UUID id;

	public RemoveProducerRequest (UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
