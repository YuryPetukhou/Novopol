package lv.javaguru.novopol.logic.api.news;

public class UpdateNewsResponse {
	private final boolean updated;

	public UpdateNewsResponse(boolean updated) {
		super();
		this.updated = updated;
	}

	public boolean isUpdated() {
		return updated;
	}
}
