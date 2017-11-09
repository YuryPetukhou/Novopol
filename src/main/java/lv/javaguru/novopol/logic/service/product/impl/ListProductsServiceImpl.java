package lv.javaguru.novopol.logic.service.product.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.ProductDAO;
import lv.javaguru.novopol.logic.api.product.ListProductsRequest;
import lv.javaguru.novopol.logic.api.product.ListProductsResponse;
import lv.javaguru.novopol.logic.service.product.ListProductsService;

@Component
public class ListProductsServiceImpl implements ListProductsService {

	@Autowired
	private ProductDAO dao ;
	
	@Override
	public ListProductsResponse getProducts(ListProductsRequest request) {
		return new ListProductsResponse(dao.getAllProducts());
	}

}
