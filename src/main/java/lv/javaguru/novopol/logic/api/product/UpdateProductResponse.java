package lv.javaguru.novopol.logic.api.product;

public class UpdateProductResponse {
	private final boolean updated;

	public UpdateProductResponse(boolean updated) {
		super();
		this.updated = updated;
	}

	public boolean isUpdated() {
		return updated;
	}
}
