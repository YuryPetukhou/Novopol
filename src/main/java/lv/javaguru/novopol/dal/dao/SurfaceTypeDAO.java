package lv.javaguru.novopol.dal.dao;

import java.util.UUID;

public interface SurfaceTypeDAO {
	UUID insertSurfaceType(String surfaceType);
	UUID getSurfaceTypeId(String surfaceType);
}
