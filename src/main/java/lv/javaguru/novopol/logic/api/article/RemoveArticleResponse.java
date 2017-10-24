package lv.javaguru.novopol.logic.api.article;

public class RemoveArticleResponse {
	private final boolean removed;

	public RemoveArticleResponse(boolean updated) {
		super();
		this.removed = updated;
	}

	public boolean isUpdated() {
		return removed;
	}
}
