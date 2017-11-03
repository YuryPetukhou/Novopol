package lv.javaguru.novopol.dal.dao;

import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.Supplier;

public interface SupplierDAO {

	Supplier addSupplier(Supplier supplier);
	boolean updateSupplier(Supplier supplier);
	List<Supplier> getAllSuppliers ();
	boolean removeSupplier(Supplier supplier);
	boolean removeSupplier(UUID supplierId);
}
