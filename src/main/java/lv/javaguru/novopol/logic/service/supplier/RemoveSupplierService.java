package lv.javaguru.novopol.logic.service.supplier;

import lv.javaguru.novopol.logic.api.supplier.RemoveSupplierRequest;
import lv.javaguru.novopol.logic.api.supplier.RemoveSupplierResponse;

public interface RemoveSupplierService {
	RemoveSupplierResponse removeSupplier (RemoveSupplierRequest request);
}
