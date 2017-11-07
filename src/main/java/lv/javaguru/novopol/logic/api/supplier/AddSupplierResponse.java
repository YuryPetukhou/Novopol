package lv.javaguru.novopol.logic.api.supplier;

import lv.javaguru.novopol.domain.Supplier;

public class AddSupplierResponse {
	private final Supplier collection;

	public AddSupplierResponse (Supplier collection) {
		super();
		this.collection = collection;
	}

	public Supplier getSupplier() {
		return collection;
	}
}
