package lv.javaguru.novopol.logic.api.news;

public class RemoveNewsResponse {
	private final boolean removed;

	public RemoveNewsResponse(boolean removed) {
		super();
		this.removed = removed;
	}

	public boolean isRemoved() {
		return removed;
	}
}
