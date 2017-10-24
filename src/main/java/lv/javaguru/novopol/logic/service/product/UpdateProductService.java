package lv.javaguru.novopol.logic.service.product;

import lv.javaguru.novopol.logic.api.product.UpdateProductRequest;
import lv.javaguru.novopol.logic.api.product.UpdateProductResponse;

public interface UpdateProductService {
	UpdateProductResponse updateProduct (UpdateProductRequest request);

}
