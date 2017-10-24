package lv.javaguru.novopol.dal.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import lv.javaguru.novopol.config.ConfigurationManager;
import lv.javaguru.novopol.dal.DBConnectionPool;

public abstract class DAOImpl {
	
	private static final String DEFAULT_ENTRIES_PER_PAGE="view.entriesperpage";
	protected int pageNumber;
	protected int entriesPerPage;
	
	
	public DAOImpl(int pageNumber, int entriesPerPage) {
		super();
		this.pageNumber = pageNumber;
		this.entriesPerPage = entriesPerPage;
	}

	protected Connection getPoolConnection () throws ClassNotFoundException, SQLException, InterruptedException {
		DBConnectionPool connectionPool	=DBConnectionPool.getInstance();
		return connectionPool.getConnection();
	}
	
	public DAOImpl () {
		ConfigurationManager manager =ConfigurationManager.getInstance();
		pageNumber = 0;
		entriesPerPage = Integer.parseInt(manager.getProperty(DEFAULT_ENTRIES_PER_PAGE));
	}
	
	
}
