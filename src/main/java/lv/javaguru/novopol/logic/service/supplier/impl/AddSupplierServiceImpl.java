package lv.javaguru.novopol.logic.service.supplier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.SupplierDAO;
import lv.javaguru.novopol.logic.api.supplier.AddSupplierRequest;
import lv.javaguru.novopol.logic.api.supplier.AddSupplierResponse;
import lv.javaguru.novopol.logic.service.supplier.AddSupplierService;

@Component
public class AddSupplierServiceImpl implements AddSupplierService{

	@Autowired
	private SupplierDAO dao;
	
	@Override
	public AddSupplierResponse addSupplier(AddSupplierRequest request) {
		return new AddSupplierResponse(dao.addSupplier(request.getSupplier()));
	}

}
