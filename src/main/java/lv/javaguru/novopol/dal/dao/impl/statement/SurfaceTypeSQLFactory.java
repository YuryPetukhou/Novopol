package lv.javaguru.novopol.dal.dao.impl.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurfaceTypeSQLFactory extends SQLStatementFactory {
	private static final String SQL_GET_SURFACE_TYPE_BY_ID = "SELECT id FROM public.surface_types WHERE keyword=?";
	private static final String SQL_INSERT_SURFACE_TYPE = "INSERT INTO public.surface_types (id,created_dt, updated_dt, created_by,updated_by,surface_type) VALUES (uuid_generate_v4(),now(),now(),'Auto','Auto',?)";
	
	public PreparedStatement insertSurfaceType(Connection connection, String surfaceType) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_SURFACE_TYPE);
		statement.setString(1, surfaceType);
		return statement;
	}

	public PreparedStatement getKeyWordId(Connection connection, String surfaceType) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_SURFACE_TYPE_BY_ID);
		statement.setString(1, surfaceType);
		return statement;
	}

}
