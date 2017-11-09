package lv.javaguru.novopol.logic.api.product;

import lv.javaguru.novopol.domain.Product;

public class AddProductResponse {
	private final Product product;

	public AddProductResponse(Product id) {
		super();
		this.product = id;
	}

	public Product getProduct() {
		return product;
	}
}
