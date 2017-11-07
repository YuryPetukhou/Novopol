package lv.javaguru.novopol.dal.dao.impl.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import lv.javaguru.novopol.domain.Collection;

public class CollectionSQLFactory extends SQLStatementFactory {

	private static final String SQL_GET_ALL_COLLECTIONS = "SELECT id,created_dt, updated_dt, created_by,updated_by,name,description FROM public.collections ORDER BY created_dt DESC LIMIT ? OFFSET ?";
	private static final String SQL_INSERT_COLLECTION = "INSERT INTO public.collections (id,created_dt, updated_dt, created_by,updated_by,name,description) VALUES (uuid_generate_v4(),now(),now(),'Auto','Auto',?,?) RETURNING id";
	private static final String SQL_UPDATE_COLLECTION = "UPDATE public.collections SET updated_dt=now(), updated_by='Auto',name=?,description=? WHERE id = ?";
	private static final String SQL_DELETE_COLLECTION_BY_ID = "DELETE FROM public.collections WHERE id=?";
	private static final String SQL_DELETE_COLLECTION_PRODUCER = "DELETE FROM public.collections_producers WHERE collection_id=?";
	private static final String SQL_UPDATE_COLLECTION_PRODUCER = "UPDATE public.collections_producers SET producer_id WHERE collection_id=?";
	
	
	public PreparedStatement insertCollectionStatement(Connection connection, Collection collection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_COLLECTION);
		statement.setString(1, collection.getName());
		statement.setString(2, collection.getDescription());
		return statement;
	}

	public PreparedStatement removeCollectionProducer(Connection connection, Collection collection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_COLLECTION_PRODUCER);
		statement.setObject(1, collection.getId());
		return statement;
	}

	public PreparedStatement removeCollectionProducer(Connection connection, UUID collectionId) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_COLLECTION_PRODUCER);
		statement.setObject(1, collectionId);
		return statement;
	}
	
	public PreparedStatement updateCollectionProducer(Connection connection, Collection collection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_COLLECTION_PRODUCER);
		statement.setObject(1, collection.getProducer().getId());
		statement.setObject(2, collection.getId());
		return statement;
	}

	public PreparedStatement updateCollectionTable(Connection connection, Collection collection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_COLLECTION);
		statement.setString(1, collection.getName());
		statement.setString(2, collection.getDescription());
		statement.setObject(3, collection.getId());
		return statement;
	}

	public PreparedStatement getAllCollectionsStatement(Connection connection, int pageNumber, int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_COLLECTIONS);
		int firstNewsNumber = pageNumber * entriesPerPage;
		statement.setInt(1, entriesPerPage);
		statement.setInt(2, firstNewsNumber);
		return statement;
	}

	public PreparedStatement removeCollectionStatement(Connection connection, UUID collectionId) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_COLLECTION_BY_ID);
		statement.setObject(1, collectionId);
		return statement;
	}

	

}
