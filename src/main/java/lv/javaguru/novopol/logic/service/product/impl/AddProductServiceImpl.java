package lv.javaguru.novopol.logic.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ProductDAO;
import lv.javaguru.novopol.logic.api.product.AddProductRequest;
import lv.javaguru.novopol.logic.api.product.AddProductResponse;
import lv.javaguru.novopol.logic.service.product.AddProductService;

@Component
public class AddProductServiceImpl implements AddProductService {

	@Autowired
	private ProductDAO dao ;

	@Override
	public AddProductResponse addProduct(AddProductRequest request) {
		return new AddProductResponse(dao.addProduct(request.getProduct()));
	}

}
