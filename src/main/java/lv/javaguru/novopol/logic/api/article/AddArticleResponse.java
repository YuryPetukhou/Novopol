package lv.javaguru.novopol.logic.api.article;

import java.util.UUID;

public class AddArticleResponse {
	private final UUID id;

	public AddArticleResponse (UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}
}
