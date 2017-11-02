package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.SupplierDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.SurfaceTypeSQLFactory;
import lv.javaguru.novopol.domain.Supplier;

public class SupplierDAOImpl extends DAOImpl implements SupplierDAO {

	private SupplierSQLFactory sqlFactory = new SupplierSQLFactory();
	
	

}
