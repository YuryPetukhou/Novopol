package lv.javaguru.novopol.logic.api.product;

import lv.javaguru.novopol.domain.Product;

public class UpdateProductRequest {
	private final Product product;

	public UpdateProductRequest(Product product) {
		super();
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
}
