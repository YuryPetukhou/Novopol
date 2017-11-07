package lv.javaguru.novopol.logic.api.supplier;

import java.util.List;

import lv.javaguru.novopol.domain.Supplier;

public class ListSuppliersResponse {
	private final List<Supplier> suppliers;

	public ListSuppliersResponse(List<Supplier> suppliers) {
		super();
		this.suppliers = suppliers;
	}

	public List<Supplier> getSupplier() {
		return suppliers;
	}
}
