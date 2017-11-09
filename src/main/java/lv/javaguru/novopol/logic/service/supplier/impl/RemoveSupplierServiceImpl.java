package lv.javaguru.novopol.logic.service.supplier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.SupplierDAO;
import lv.javaguru.novopol.logic.api.supplier.RemoveSupplierRequest;
import lv.javaguru.novopol.logic.api.supplier.RemoveSupplierResponse;
import lv.javaguru.novopol.logic.service.supplier.RemoveSupplierService;

@Component
public class RemoveSupplierServiceImpl implements RemoveSupplierService {

	@Autowired
	private SupplierDAO dao;
	
	@Override
	public RemoveSupplierResponse removeSupplier(RemoveSupplierRequest request) {
		return new RemoveSupplierResponse(dao.removeSupplier(request.getId()));
	}

}
