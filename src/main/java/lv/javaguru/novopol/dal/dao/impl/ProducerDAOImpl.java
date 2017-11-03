package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.ProducerDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.ProducerSQLFactory;
import lv.javaguru.novopol.domain.Producer;
import lv.javaguru.novopol.domain.builder.ProducerBuilder;

public class ProducerDAOImpl extends DAOImpl implements ProducerDAO {

	private ProducerSQLFactory sqlFactory = new ProducerSQLFactory();

	@Override
	public Producer addProducer(Producer supplier) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertProducerStatement(connection, supplier);
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
	public boolean updateProducer(Producer supplier) {
		if (supplier.getId() == null) {
			return false;
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.updateProducerStatement(connection, supplier)) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return true;

	}

	@Override
	public List<Producer> getAllProducers() {
		List<Producer> suppliersList = new ArrayList<Producer>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getAllProducersStatement(connection, pageNumber,
						entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				Producer article = prepareProducer(resultSet);
				suppliersList.add(article);
			}

		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return suppliersList;

	}

	private Producer prepareProducer(ResultSet resultSet) throws SQLException {
		Producer supplier = ProducerBuilder.createProducer().withId((UUID) resultSet.getObject(1))
				.withName(resultSet.getString(6)).withCountry(resultSet.getString(7)).withCity(resultSet.getString(8))
				.withState(resultSet.getString(9)).withZipCode(resultSet.getString(10))
				.withStreet(resultSet.getString(11)).withHouse(resultSet.getString(12))
				.withOffice(resultSet.getString(13)).withPhone(resultSet.getString(14))
				.withEmail(resultSet.getString(15)).withWebsite(resultSet.getString(16))
				.withContactPerson(resultSet.getString(17)).build();
		return supplier;
	}

	@Override
	public boolean removeProducer(Producer supplier) {
		return removeProducer(supplier.getId());
	}

	@Override
	public boolean removeProducer(UUID supplierId) {
		if (supplierId == null) {
			return false;
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.removeProducerStatement(connection, supplierId)) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return true;
	}

}
