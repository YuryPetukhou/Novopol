package lv.javaguru.novopol.logic.api.producer;

public class RemoveProducerResponse {
	private final boolean id;

	public RemoveProducerResponse (boolean id) {
		this.id = id;
	}

	public boolean getId() {
		return id;
	}
}
