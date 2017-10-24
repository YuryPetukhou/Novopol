package lv.javaguru.novopol.logic.api.article;

import java.util.UUID;

public class RemoveArticleRequest {
	private final UUID id;

	public RemoveArticleRequest (UUID id) {
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

}
