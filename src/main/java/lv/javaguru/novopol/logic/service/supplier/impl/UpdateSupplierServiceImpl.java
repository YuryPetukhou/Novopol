package lv.javaguru.novopol.logic.service.supplier.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.dao.SupplierDAO;
import lv.javaguru.novopol.logic.api.supplier.UpdateSupplierRequest;
import lv.javaguru.novopol.logic.api.supplier.UpdateSupplierResponse;
import lv.javaguru.novopol.logic.service.supplier.UpdateSupplierService;

@Component
public class UpdateSupplierServiceImpl implements UpdateSupplierService {
	@Autowired
	private SupplierDAO dao;
	
	@Override
	public UpdateSupplierResponse updateSupplier(UpdateSupplierRequest request) {
		return new UpdateSupplierResponse(dao.updateSupplier(request.getSupplier()));
	}

}
