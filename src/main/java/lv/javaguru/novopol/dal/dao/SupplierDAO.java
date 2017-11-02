package lv.javaguru.novopol.dal.dao;

import java.util.List;

import lv.javaguru.novopol.domain.Supplier;

public interface SupplierDAO {

	Supplier addSupplier(Supplier Supplier);
	boolean updateSupplier(Supplier Supplier);
	List<Supplier> getAllSuppliers ();
	
}
