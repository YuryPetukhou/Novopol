package lv.javaguru.novopol.logic.api.supplier;

import lv.javaguru.novopol.domain.Supplier;

public class AddSupplierRequest {
	private final Supplier supplier;

	public AddSupplierRequest(Supplier collection) {
		super();
		this.supplier = collection;
	}

	public Supplier getSupplier() {
		return supplier;
	}
}
