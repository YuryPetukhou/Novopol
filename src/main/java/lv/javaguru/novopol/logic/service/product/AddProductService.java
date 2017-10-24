package lv.javaguru.novopol.logic.service.product;

import lv.javaguru.novopol.logic.api.product.AddProductRequest;
import lv.javaguru.novopol.logic.api.product.AddProductResponse;

public interface AddProductService {
	AddProductResponse addProduct(AddProductRequest request);
}
