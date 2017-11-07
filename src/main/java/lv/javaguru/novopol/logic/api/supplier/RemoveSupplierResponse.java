package lv.javaguru.novopol.logic.api.supplier;

public class RemoveSupplierResponse {
	private final boolean id;

	public RemoveSupplierResponse (boolean id) {
		this.id = id;
	}

	public boolean getId() {
		return id;
	}
}
