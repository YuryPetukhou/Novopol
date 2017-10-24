package lv.javaguru.novopol.logic.api.product;

import lv.javaguru.novopol.domain.News;
import lv.javaguru.novopol.domain.Product;

public class AddProductRequest {
	private final Product product;

	public AddProductRequest(Product product) {
		super();
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
}
