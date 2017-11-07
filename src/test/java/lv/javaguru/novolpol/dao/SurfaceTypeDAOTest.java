package lv.javaguru.novolpol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import lv.javaguru.novopol.dal.DBConnectionPool;
import lv.javaguru.novopol.dal.dao.SurfaceTypeDAO;
import lv.javaguru.novopol.dal.dao.impl.SurfaceTypeDAOImpl;

public class SurfaceTypeDAOTest {

	private static final String SQL_DELETE_ALL_COLLECTIONS = "DELETE FROM public.surface_types";

	private static String surfaceTypeToRemove=null;
	
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
		SurfaceTypeDAO dao = new SurfaceTypeDAOImpl();
		String surfaceType ="FloorType";
		surfaceTypeToRemove=surfaceType;
		
		UUID surfaceTypeToRemove =dao.insertSurfaceType(surfaceType);
		
		
		UUID surfaceTypeId =dao.insertSurfaceType("NFloorType");
		dao.updateSurfaceType("UFloorType", surfaceTypeId);
	}
	


	@Test
	public void selectAllTest() {
		SurfaceTypeDAO dao = new SurfaceTypeDAOImpl();
		List<String> list=dao.getAllSurfaceTypes();
		System.out.println(list);
	}
	
	@Test
	public void deleteTest() {
		SurfaceTypeDAO dao = new SurfaceTypeDAOImpl();
		dao.removeSurfaceType(surfaceTypeToRemove);
	}

}
