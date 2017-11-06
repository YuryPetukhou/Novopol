package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.CollectionDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.CollectionSQLFactory;
import lv.javaguru.novopol.domain.Collection;
import lv.javaguru.novopol.domain.Supplier;
import lv.javaguru.novopol.domain.builder.CollectionBuilder;
import lv.javaguru.novopol.domain.builder.SupplierBuilder;

public class CollectionDAOImpl extends DAOImpl implements CollectionDAO {

	private CollectionSQLFactory sqlFactory = new CollectionSQLFactory();

	public CollectionDAOImpl() {
		super();
	}

	public CollectionDAOImpl(int pageNumber, int entriesPerPage) {
		super(pageNumber, entriesPerPage);
	}

	public Collection addCollection(Collection collection) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertCollectionStatement(connection, collection);
				ResultSet rs = statement.executeQuery();) {
			if (rs.next()) {
				collection.setId((UUID) rs.getObject(1));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}

		if (collection.getProducer() != null) {
			insertProducerLine(collection);
		}

		return collection;

	}


	private void insertProducerLine(Collection collection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean updateCollection(Collection collection) {
		updateCollectionTable(collection);
		updateCollectionProducer(collection);
		return true;
	}

	

	private void updateCollectionTable(Collection collection) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.updateCollectionTable(connection, collection);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}

		
	}

	private void updateCollectionProducer(Collection collection) {
		if (collection.getProducer() != null) {
			try (Connection connection = getPoolConnection();
					PreparedStatement statement = sqlFactory.updateCollectionProducer(connection, collection);) {
				statement.executeUpdate();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new DBException(e);
			}
		} else {
			try (Connection connection = getPoolConnection();
					PreparedStatement statement = sqlFactory.removeCollectionProducer(connection, collection);) {
				statement.executeUpdate();
			} catch (Throwable e) {
				e.printStackTrace();
				throw new DBException(e);
			}
		}

	}

	
	@Override
	public List<Collection> getAllCollections() {
		List<Collection> collectionsList = new ArrayList<Collection>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getAllCollectionsStatement(connection, pageNumber,
						entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Collection collection = prepareCollection(resultSet);
				collectionsList.add(collection);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return collectionsList;

	}

	private Collection prepareCollection(ResultSet resultSet) throws SQLException {
		Collection collection = CollectionBuilder.createCollection().withId((UUID) resultSet.getObject(1))
				.withName(resultSet.getString(6)).withDescription(resultSet.getString(7)).build();
		return collection;
	}

	@Override
	public boolean removeCollection(Collection collection) {
		return removeCollection(collection.getId());
	}

	@Override
	public boolean removeCollection(UUID collectionId) {
		if (collectionId == null) {
			return false;
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.removeCollectionStatement(connection, collectionId)) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.removeCollectionProducer(connection, collectionId)) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		
		return true;
	}

}
