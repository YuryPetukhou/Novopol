package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lv.javaguru.novopol.dal.DBException;
import lv.javaguru.novopol.dal.dao.SurfaceTypeDAO;
import lv.javaguru.novopol.dal.dao.impl.statement.SurfaceTypeSQLFactory;
import lv.javaguru.novopol.domain.Collection;

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
				PreparedStatement statement = sqlFactory.getSurfaceTypeId(connection, surfaceType);
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
	public boolean updateSurfaceType(String surfaceType, UUID id) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.updateSurfaceTypeById(connection, id,surfaceType);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return true;
	}

	@Override
	public boolean removeSurfaceType(String surfaceType) {
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.deleteSurfaceType(connection, surfaceType);) {
			statement.executeUpdate();
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return true;
	}

	@Override
	public List<String> getAllSurfaceTypes() {
		List<String> surfaceTypesList = new ArrayList<String>();
		try (Connection connection = getPoolConnection();
				PreparedStatement statement = sqlFactory.getAllSurfaceTypesStatement(connection, pageNumber,
						entriesPerPage);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				
				surfaceTypesList.add(resultSet.getString(1));
			}
		} catch (Throwable e) {
			e.printStackTrace();
			throw new DBException(e);
		}
		return surfaceTypesList;
	}

	

}
