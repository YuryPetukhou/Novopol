package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.SurfaceTypeDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.SurfaceTypeSQLFactory;

public class SurfaceTypeDAOImpl extends DAOImpl implements SurfaceTypeDAO {

private SurfaceTypeSQLFactory sqlFactory = new SurfaceTypeSQLFactory();
	
	@Override
	public UUID insertSurfaceType(String surfaceType) {
		UUID id = null;
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.insertSurfaceType(connection, surfaceType);
				ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				id = (UUID) resultSet.getObject(1);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return id;

	}

	@Override
	public UUID getSurfaceTypeId(String surfaceType) {
		UUID id = null;
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getKeyWordId(connection, surfaceType);
				ResultSet resultSet = statement.executeQuery()) {
			if (resultSet.next()) {
				id = (UUID) resultSet.getObject(1);
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return id;
	}


}
