package lv.javaguru.novopol.dal.dao.impl.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KeywordSQLFactory extends SQLStatementFactory{

	private static final String SQL_GET_KEYWORD_BY_ID = "SELECT id FROM public.keywords WHERE keyword=?";
	private static final String SQL_INSERT_KEYWORD = "INSERT INTO public.keywords (id,created_dt, updated_dt, created_by,updated_by,keyword) VALUES (uuid_generate_v4(),now(),now(),'Auto','Auto',?) RETURNING id";
	
	public PreparedStatement insertKeyword(Connection connection, String keyword) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_INSERT_KEYWORD);
		statement.setString(1, keyword);
		return statement;
	}

	public PreparedStatement getKeyWordId(Connection connection, String keyword) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(SQL_GET_KEYWORD_BY_ID);
		statement.setString(1, keyword);
		return statement;
	}
}
