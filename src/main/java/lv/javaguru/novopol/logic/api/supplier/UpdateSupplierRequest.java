package lv.javaguru.novopol.logic.api.supplier;

import lv.javaguru.novopol.domain.Supplier;

public class UpdateSupplierRequest {
	private final Supplier article;

	public UpdateSupplierRequest(Supplier article) {
		this.article = article;
	}
	
	public Supplier getSupplier() {
		return article;
	}
}
