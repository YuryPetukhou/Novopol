package lv.javaguru.novopol.logic.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ProductDAO;
import lv.javaguru.novopol.logic.api.product.UpdateProductRequest;
import lv.javaguru.novopol.logic.api.product.UpdateProductResponse;
import lv.javaguru.novopol.logic.service.product.UpdateProductService;

@Component
public class UpdateProductServiceImpl implements UpdateProductService {

	@Autowired
	private ProductDAO dao ;

	@Override
	public UpdateProductResponse updateProduct(UpdateProductRequest request) {
		return new UpdateProductResponse(dao.updateProduct(request.getProduct()));
	}

}
