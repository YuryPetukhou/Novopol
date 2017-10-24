package lv.javaguru.novopol.logic.api.product;

public class RemoveProductResponse {
	private final boolean removed;

	public RemoveProductResponse(boolean removed) {
		super();
		this.removed = removed;
	}

	public boolean isRemoved() {
		return removed;
	}
}
