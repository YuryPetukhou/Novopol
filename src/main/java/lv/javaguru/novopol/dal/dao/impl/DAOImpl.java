package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import lv.javaguru.novopol.dal.DBConnectionPool;

public abstract class DAOImpl {
	
	protected Connection getPoolConnection () throws ClassNotFoundException, SQLException, InterruptedException {
		DBConnectionPool connectionPool	=DBConnectionPool.getInstance();
		return connectionPool.getConnection();
	}
	
}
