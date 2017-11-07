package lv.javaguru.novopol.logic.api.producer;

public class UpdateProducerResponse {
private final boolean updated;
	
	public UpdateProducerResponse(boolean updated) {
		super();
		this.updated = updated;
	}

	public boolean isUpdated() {
		return updated;
	}
	
}
