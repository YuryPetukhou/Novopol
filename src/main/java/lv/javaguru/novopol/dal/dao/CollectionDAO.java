package lv.javaguru.novopol.dal.dao;

import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.domain.Collection;

public interface CollectionDAO {
	Collection addCollection(Collection Collection);
	boolean updateCollection(Collection Collection);
	List<Collection> getAllCollections ();	
	boolean removeCollection(Collection collection);
	boolean removeCollection(UUID collectionId);
}
