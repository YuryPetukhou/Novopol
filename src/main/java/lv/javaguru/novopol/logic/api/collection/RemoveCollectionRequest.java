package lv.javaguru.novopol.logic.api.collection;

import java.util.UUID;

public class RemoveCollectionRequest {
	private final UUID id;

	public RemoveCollectionRequest (UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

}
