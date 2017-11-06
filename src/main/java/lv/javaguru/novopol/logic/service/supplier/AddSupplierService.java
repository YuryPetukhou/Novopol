package lv.javaguru.novopol.logic.service.supplier;

import lv.javaguru.novopol.logic.api.supplier.AddSupplierRequest;
import lv.javaguru.novopol.logic.api.supplier.AddSupplierResponse;

public interface AddSupplierService {
	AddSupplierResponse addSupplier(AddSupplierRequest request);
}
