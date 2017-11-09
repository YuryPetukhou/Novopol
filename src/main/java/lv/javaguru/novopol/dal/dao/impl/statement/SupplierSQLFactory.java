package lv.javaguru.novopol.dal.dao.impl.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.stereotype.Component;

import lv.javaguru.novopol.domain.Supplier;

@Component
public class SupplierSQLFactory extends SQLStatementFactory {

	private static final String SQL_GET_ALL_SUPPLIERS = "SELECT id,created_dt, updated_dt, created_by,updated_by,name,country,city,state,zipcode,street,house,office,phone,email,website,contact_person FROM public.suppliers ORDER BY created_dt DESC LIMIT ? OFFSET ?";
	private static final String SQL_INSERT_SUPPLIER = "INSERT INTO public.suppliers (id,created_dt, updated_dt, created_by,updated_by,name,country,city,state,zipcode,street,house,office,phone,email,website,contact_person) VALUES (uuid_generate_v4(),now(),now(),'Auto','Auto',?,?,?,?,?,?,?,?,?,?,?,?) RETURNING id";
	private static final String SQL_UPDATE_SUPPLIER = "UPDATE public.suppliers SET updated_dt=now(), updated_by='Auto',name=?,country=?,city=?,state=?,zipcode=?,street=?,house=?,office=?,phone=?,email=?,website=?,contact_person=? WHERE id = ?";
	private static final String SQL_DELETE_SUPPLIER_BY_ID = "DELETE FROM public.suppliers WHERE id=?";
	
	public PreparedStatement updateSupplierStatement(Connection connection, Supplier supplier) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_SUPPLIER);
		statement.setString(1, supplier.getName());
		statement.setString(2, supplier.getCountry());
		statement.setString(3, supplier.getCity());
		statement.setString(4, supplier.getState());
		statement.setString(5, supplier.getZipcode());
		statement.setString(6, supplier.getStreet());
		statement.setString(7, supplier.getHouse());
		statement.setString(8, supplier.getOffice());
		statement.setString(9, supplier.getPhone());
		statement.setString(10, supplier.getEmail());
		statement.setString(11, supplier.getWebsite());
		statement.setString(12, supplier.getContactPerson());
		statement.setObject(13, supplier.getId());
		return statement;
	}

	public PreparedStatement insertSupplierStatement(Connection connection, Supplier supplier) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_SUPPLIER);
		statement.setString(1, supplier.getName());
		statement.setString(2, supplier.getCountry());
		statement.setString(3, supplier.getCity());
		statement.setString(4, supplier.getState());
		statement.setString(5, supplier.getZipcode());
		statement.setString(6, supplier.getStreet());
		statement.setString(7, supplier.getHouse());
		statement.setString(8, supplier.getOffice());
		statement.setString(9, supplier.getPhone());
		statement.setString(10, supplier.getEmail());
		statement.setString(11, supplier.getWebsite());
		statement.setString(12, supplier.getContactPerson());
		return statement;
	}

	public PreparedStatement removeSupplierStatement(Connection connection, UUID supplierId) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_SUPPLIER_BY_ID);
		statement.setObject(1, supplierId);
		return statement;
	}

	public PreparedStatement getAllSuppliersStatement(Connection connection, int pageNumber, int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_SUPPLIERS);
		int firstNewsNumber = pageNumber * entriesPerPage;
		statement.setInt(1, entriesPerPage);
		statement.setInt(2, firstNewsNumber);
		return statement;
	}
}
