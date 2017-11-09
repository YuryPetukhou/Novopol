package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.SupplierDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.SupplierSQLFactory;
import lv.javaguru.novopol.domain.Supplier;
import lv.javaguru.novopol.domain.builder.SupplierBuilder;

@Component
public class SupplierDAOImpl extends DAOImpl implements SupplierDAO {
	@Autowired
	private SupplierSQLFactory sqlFactory;// = new SupplierSQLFactory();

	@Override
	public Supplier addSupplier(Supplier supplier) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertSupplierStatement(connection, supplier);
				ResultSet rs = statement.executeQuery();) {

			if (rs.next()) {
				supplier.setId((UUID) rs.getObject(1));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return supplier;
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		if (supplier.getId() == null) {
			return false;
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.updateSupplierStatement(connection, supplier)) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return true;

	}

	@Override
	public List<Supplier> getAllSuppliers() {
		List<Supplier> suppliersList = new ArrayList<Supplier>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getAllSuppliersStatement(connection, pageNumber,
						entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				Supplier article = prepareSupplier(resultSet);
				suppliersList.add(article);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return suppliersList;

	}

	private Supplier prepareSupplier(ResultSet resultSet) throws SQLException {
		Supplier supplier = SupplierBuilder.createSupplier().withId((UUID) resultSet.getObject(1))
				.withName(resultSet.getString(6)).withCountry(resultSet.getString(7)).withCity(resultSet.getString(8))
				.withState(resultSet.getString(9)).withZipCode(resultSet.getString(10))
				.withStreet(resultSet.getString(11)).withHouse(resultSet.getString(12))
				.withOffice(resultSet.getString(13)).withPhone(resultSet.getString(14))
				.withEmail(resultSet.getString(15)).withWebsite(resultSet.getString(16))
				.withContactPerson(resultSet.getString(17)).build();
		return supplier;
	}

	@Override
	public boolean removeSupplier(Supplier supplier) {
		return removeSupplier(supplier.getId());
	}

	@Override
	public boolean removeSupplier(UUID supplierId) {
		if (supplierId == null) {
			return false;
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.removeSupplierStatement(connection, supplierId)) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return true;
	}

}
