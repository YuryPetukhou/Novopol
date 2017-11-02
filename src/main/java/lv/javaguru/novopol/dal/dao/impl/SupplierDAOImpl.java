package lv.javaguru.novopol.dal.dao.impl;

import java.util.List;

import lv.javaguru.novopol.dal.dao.SupplierDAO;
import lv.javaguru.novopol.domain.Supplier;

public class SupplierDAOImpl extends DAOImpl implements SupplierDAO {

	private SupplierSQLFactory sqlFactory = new SupplierSQLFactory();

	@Override
	public Supplier addSupplier(Supplier Supplier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateSupplier(Supplier Supplier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
