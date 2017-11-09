package lv.javaguru.novopol.logic.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ProductDAO;
import lv.javaguru.novopol.logic.api.product.RemoveProductRequest;
import lv.javaguru.novopol.logic.api.product.RemoveProductResponse;
import lv.javaguru.novopol.logic.service.product.RemoveProductService;

@Component
public class RemoveProductServiceImpl implements RemoveProductService {
	@Autowired
	private ProductDAO dao ;

	
	@Override
	public RemoveProductResponse removeProduct(RemoveProductRequest request) {
		return new RemoveProductResponse(dao.removeProduct(request.getId()));
	}

}
