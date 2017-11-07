package lv.javaguru.novopol.logic.api.supplier;

public class UpdateSupplierResponse {
private final boolean updated;
	
	public UpdateSupplierResponse(boolean updated) {
		super();
		this.updated = updated;
	}

	public boolean isUpdated() {
		return updated;
	}
	
}
