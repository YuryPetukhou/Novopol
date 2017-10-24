package lv.javaguru.novopol.logic.service.product;

import lv.javaguru.novopol.logic.api.product.ListProductsRequest;
import lv.javaguru.novopol.logic.api.product.ListProductsResponse;

public interface ListProductsService {
	ListProductsResponse getProducts (ListProductsRequest request);
}
