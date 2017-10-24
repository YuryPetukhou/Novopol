package lv.javaguru.novopol.logic.api.news;

import java.util.UUID;

public class RemoveNewsRequest {
	private final UUID id;

	public RemoveNewsRequest(UUID id) {
		super();
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
