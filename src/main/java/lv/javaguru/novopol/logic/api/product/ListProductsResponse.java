package lv.javaguru.novopol.logic.api.product;

import java.util.List;

import lv.javaguru.novopol.domain.Product;

public class ListProductsResponse {
	private final List<Product> products;

	public ListProductsResponse(List<Product> products) {
		super();
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}
}
