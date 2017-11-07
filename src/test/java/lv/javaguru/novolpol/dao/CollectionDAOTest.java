package lv.javaguru.novolpol.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import junit.framework.Assert;
import lv.javaguru.novopol.dal.DBConnectionPool;
import lv.javaguru.novopol.dal.dao.CollectionDAO;
import lv.javaguru.novopol.dal.dao.impl.CollectionDAOImpl;
import lv.javaguru.novopol.domain.Collection;
import lv.javaguru.novopol.domain.builder.CollectionBuilder;

public class CollectionDAOTest {

	private static final String SQL_DELETE_ALL_COLLECTIONS = "DELETE FROM public.collections";

	private static UUID idToRemove=null;
	
	public void clearTable() {
		try (Connection connection = DBConnectionPool.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ALL_COLLECTIONS)) {
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void insertTest() {
		clearTable();
		CollectionDAO dao = new CollectionDAOImpl();
		Collection collection =dao.addCollection(createCollection());
		collection.setName("Vasil Lohankins");
		Collection collectionToRemove =dao.addCollection(createCollection());
		idToRemove = collectionToRemove.getId();
		System.out.println(idToRemove);
		
		dao.updateCollection(collection);
		Assert.assertNotNull(collection.getId());
	}
	
	private Collection createCollection() {
		List<String> keywords = new ArrayList<String>();
		keywords.add("Test keyword");
		Collection collection = CollectionBuilder.createCollection().withName("VIP").build();
		return collection;
	}

	@Test
	public void selectAllTest() {
		CollectionDAO dao = new CollectionDAOImpl();
		List<Collection> list=dao.getAllCollections();
		System.out.println(list);
	}
	
	@Test
	public void deleteTest() {
		CollectionDAO dao = new CollectionDAOImpl();
		dao.removeCollection(idToRemove);
	}

}
