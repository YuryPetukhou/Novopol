package lv.javaguru.novopol.logic.api.article;

public class UpdateArticleResponse {
	private final boolean updated;
	
	public UpdateArticleResponse(boolean updated) {
		super();
		this.updated = updated;
	}

	public boolean isUpdated() {
		return updated;
	}
	
}
