package lv.javaguru.novopol.logic.api.collection;

public class UpdateCollectionResponse {
private final boolean updated;
	
	public UpdateCollectionResponse(boolean updated) {
		super();
		this.updated = updated;
	}

	public boolean isUpdated() {
		return updated;
	}
	
}
