package lv.javaguru.novopol.dal.dao;

import java.sql.Connection;
import java.sql.SQLException;

import lv.javaguru.novopol.dal.DBConnectionPool;

public abstract class AbstractDAO {
	
	
	protected Connection getPoolConnection () throws ClassNotFoundException, SQLException, InterruptedException {
		DBConnectionPool connectionPool	=DBConnectionPool.getInstance();
		return connectionPool.getConnection();
	}
}
