package lv.javaguru.novopol.logic.service.supplier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.SupplierDAO;
import lv.javaguru.novopol.logic.api.supplier.ListSuppliersRequest;
import lv.javaguru.novopol.logic.api.supplier.ListSuppliersResponse;
import lv.javaguru.novopol.logic.service.supplier.ListSuppliersService;

@Component
public class ListSuppliersServiceImpl implements ListSuppliersService {

	@Autowired
	private SupplierDAO dao;
	
	@Override
	public ListSuppliersResponse getSuppliers(ListSuppliersRequest request) {
		return new ListSuppliersResponse(dao.getAllSuppliers());
	}

}
