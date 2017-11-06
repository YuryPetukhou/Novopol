package lv.javaguru.novopol.logic.service.supplier;

import lv.javaguru.novopol.logic.api.supplier.ListSuppliersRequest;
import lv.javaguru.novopol.logic.api.supplier.ListSuppliersResponse;

public interface ListSuppliersService {
	ListSuppliersResponse getSuppliers (ListSuppliersRequest request);
}
