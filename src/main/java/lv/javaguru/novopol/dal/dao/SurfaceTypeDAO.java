package lv.javaguru.novopol.dal.dao;

import java.util.List;
import java.util.UUID;

public interface SurfaceTypeDAO {
	UUID insertSurfaceType(String surfaceType);
	UUID getSurfaceTypeId(String surfaceType);
	boolean updateSurfaceType(String surfaceType,UUID id);
	boolean removeSurfaceType(String surfaceType);
	List<String> getAllSurfaceTypes();
}
