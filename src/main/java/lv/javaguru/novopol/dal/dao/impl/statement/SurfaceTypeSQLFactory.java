package lv.javaguru.novopol.dal.dao.impl.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class SurfaceTypeSQLFactory extends SQLStatementFactory {
	private static final String SQL_GET_SURFACE_TYPE_BY_ID = "SELECT id FROM public.surface_types WHERE type=?";
	private static final String SQL_INSERT_SURFACE_TYPE = "INSERT INTO public.surface_types (id,created_dt, updated_dt, created_by,updated_by,type) VALUES (uuid_generate_v4(),now(),now(),'Auto','Auto',?) RETURNING id";
	private static final String SQL_UPDATE_SURFACE_TYPE_BY_ID = "UPDATE public.surface_types SET updated_dt=now(), updated_by='Auto',type=? WHERE id=?";
	private static final String SQL_DELETE_SURFACE_TYPE = "DELETE FROM public.surface_types WHERE type=?";
	private static final String SQL_GET_ALL_SURFACE_TYPES = "SELECT type FROM public.surface_types ORDER BY created_dt DESC LIMIT ? OFFSET ?";
	
	public PreparedStatement insertSurfaceType(Connection connection, String surfaceType) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_SURFACE_TYPE);
		statement.setString(1, surfaceType);
		return statement;
	}

	public PreparedStatement getSurfaceTypeId(Connection connection, String surfaceType) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_SURFACE_TYPE_BY_ID);
		statement.setString(1, surfaceType);
		return statement;
	}

	public PreparedStatement updateSurfaceTypeById(Connection connection, UUID id, String surfaceType) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_SURFACE_TYPE_BY_ID);
		statement.setString(1, surfaceType);
		statement.setObject(2, id);
		return statement;
	}

	public PreparedStatement deleteSurfaceType(Connection connection, String surfaceType) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_DELETE_SURFACE_TYPE);
		statement.setString(1, surfaceType);
		return statement;
	}

	public PreparedStatement getAllSurfaceTypesStatement(Connection connection, int pageNumber, int entriesPerPage) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_SURFACE_TYPES);
		int firstNewsNumber = pageNumber * entriesPerPage;
		statement.setInt(1, entriesPerPage);
		statement.setInt(2, firstNewsNumber);
		return statement;
	}

}
