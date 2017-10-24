package lv.javaguru.novopol.logic.service.product;

import lv.javaguru.novopol.logic.api.product.RemoveProductRequest;
import lv.javaguru.novopol.logic.api.product.RemoveProductResponse;

public interface RemoveProductService {
	RemoveProductResponse removeProduct (RemoveProductRequest request);
}
