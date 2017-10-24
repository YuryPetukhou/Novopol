package lv.javaguru.novopol.logic.api.news;

import java.util.UUID;

public class AddNewsResponse {
	private final UUID id;

	public AddNewsResponse(UUID id) {
		super();
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
